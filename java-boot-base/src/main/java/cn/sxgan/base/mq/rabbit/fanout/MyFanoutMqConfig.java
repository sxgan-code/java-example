package cn.sxgan.base.mq.rabbit.fanout;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFanoutMqConfig {
    // 创建交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("test_fanout_exchange", true, false);
    }
    
    /**
     * 创建队列
     * durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
     * exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
     * autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
     * 一般设置一下队列的持久化就好,其余两个就是默认false
     */
    @Bean
    public Queue emailQueue() {
        return new Queue("email_queue", true);
    }
    
    @Bean
    public Queue smsQueue() {
        return new Queue("sms_queue", true);
    }
    
    @Bean
    public Queue wechatQueue() {
        return new Queue("wechat_queue", true);
    }
    
    // 绑定交换机和队列
    @Bean
    public Binding emailBind() {
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
    
    @Bean
    public Binding smsBind() {
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    
    @Bean
    public Binding wechatBind() {
        return BindingBuilder.bind(wechatQueue()).to(fanoutExchange());
    }
    
}