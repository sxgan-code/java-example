package cn.sxgan.base.mq.rabbit.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class DirectProductService {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 生成订单信息
     *
     * @param userID 用户ID
     * @param num    产品数量
     */
    public void product(String userID, Integer num, String routeKey) {
        // 通过UUID生成随机订单号
        String productId = UUID.randomUUID().toString();
        // 使用map集合打包数据，并发送，注意接收时使用Map类型接收
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userID);
        map.put("productid", productId);
        map.put("count", num);
        log.info("生产产品中。。。。{}", productId);
        // 参数1：交换机名称  参数2：路由Key 参数3：object类型数据，此处发送map集合
        rabbitTemplate.convertAndSend("test_direct_exchange", routeKey, map);
    }
}