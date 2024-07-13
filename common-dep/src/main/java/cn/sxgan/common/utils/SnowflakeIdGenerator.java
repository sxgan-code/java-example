package cn.sxgan.common.utils;

import cn.sxgan.common.config.properties.SnowflakeProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 雪花算法
 * @Author: sxgan
 * @Date: 2024-07-13 11:54
 * @Version: 1.0
 **/
@Component
public class SnowflakeIdGenerator {
    // 数据中心id
    private final long datacenterId;
    // 数据中心id位数
    private final long datacenterBits;
    // 机器id
    private final long workerId;
    // 机器id位数
    private final long workerBits;
    // 序列id所占位数
    private final long sequenceBits;
    // 时间戳起始点（毫秒）
    private final long twepoch;
    
    // 数据中心最大id
    private final long maxDatacenterId;
    // 机器最大id
    private final long maxWorkerId;
    // 最大序列号
    private final long maxSequence;
    
    // 机器id左移位数
    private final long workerIdShift;
    // 数据中心id左移位数
    private final long datacenterIdShift;
    // 毫秒数左移位数
    private final long timestampLeftShift;
    
    // 单次批量生成id的最大数量
    private final int maxBatchCount;
    
    // 序列号
    private long sequence = 0L;
    // 上一次时间戳
    private long lastTimestamp = -1L;
    
    public SnowflakeIdGenerator(SnowflakeProperties properties) {
        // 数据中心id
        this.datacenterId = properties.getDatacenterId();
        // 数据中心id位数
        this.datacenterBits = properties.getDatacenterBits();
        // 机器id
        this.workerId = properties.getWorkerId();
        // 机器id位数
        this.workerBits = properties.getWorkerBits();
        // 序列id所占位数
        this.sequenceBits = properties.getSequenceBits();
        // 时间戳起始点（毫秒）
        this.twepoch = properties.getTwepoch();
        // 数据中心最大id
        this.maxDatacenterId = ~(-1L << properties.getDatacenterBits());
        // 机器最大id
        this.maxWorkerId = ~(-1L << properties.getWorkerBits());
        // 最大序列号
        this.maxSequence = ~(-1L << properties.getSequenceBits());
        
        this.workerIdShift = properties.getSequenceBits();
        // 数据中心id左移位数
        this.datacenterIdShift = properties.getSequenceBits() + properties.getWorkerBits();
        // 毫秒数左移位数
        this.timestampLeftShift = properties.getSequenceBits() + properties.getWorkerBits() + properties.getSequenceBits();
        // 单次批量生成id的最大数量
        this.maxBatchCount = properties.getMaxBatchCount();
        
        
        // 校验datacenterId和workerId是否超出最大值
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("数据中心Id不能大于%d或小于0", maxDatacenterId));
        }
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("机器Id不能大于%d或小于0", maxWorkerId));
        }
    }
    
    
    /**
     * id生成方法(单个)
     *
     * @return 单个ID
     */
    public synchronized long nextId() {
        // 获取当前时间的毫秒数
        long timestamp = currentTime();
        
        // 判断时钟是否回拨
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("时钟回拨，回拨毫秒数：%d", lastTimestamp - timestamp));
        }
        
        // 设置序列号
        if (lastTimestamp == timestamp) {
            // 设置序列号递增，如果当前毫秒内序列号已经达到最大值，则直到下一毫秒在重新从0开始计算序列号
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        
        lastTimestamp = timestamp;
        
        // 计算id
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }
    
    
    /**
     * id生成方法(批量)
     *
     * @return 批量ID
     */
    public synchronized List<Long> nextIds(int count) {
        if (count > maxBatchCount || count < 0) {
            throw new IllegalArgumentException(String.format("批量生成id的数量不能大于%d或小于0", maxBatchCount));
        }
        
        List<Long> ids = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            ids.add(nextId());
        }
        return ids;
    }
    
    /**
     * 循环等待直至获取到新的毫秒时间戳
     * 确保生成的时间戳总是向前移动的，即使在相同的毫秒内请求多个ID时也能保持唯一性。
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = currentTime();
        // 循环等待直至获取到新的毫秒时间戳
        while (timestamp <= lastTimestamp) {
            timestamp = currentTime();
        }
        return timestamp;
    }
    
    /**
     * 获取当前时间的毫秒数
     */
    private long currentTime() {
        return System.currentTimeMillis();
    }
    
}