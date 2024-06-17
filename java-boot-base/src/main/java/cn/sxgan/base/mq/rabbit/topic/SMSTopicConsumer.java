package cn.sxgan.base.mq.rabbit.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

// bindings其实就是用来确定队列和交换机绑定关系
@Slf4j
@RabbitListener(bindings =
@QueueBinding(
        // email_topic_queue 是队列名字，这个名字你可以自定随便定义。
        value = @Queue(value = "sms_topic_queue", declare = "true", autoDelete = "false"),
        // test_topic_exchange 交换机的名字 必须和生产者保持一致,这里是确定的rabbitmq模式是：topic模式
        exchange = @Exchange(value = "test_topic_exchange", type = ExchangeTypes.TOPIC),
        // RouterKey
        // 这里的key是用来指定队列和交换机绑定的关系，这里指定的是模糊匹配，*表示有且仅有一个字段，#表示可以有0个，一个，或多个字段
        key = "#.sms.#"
)
)
@Component
public class SMSTopicConsumer {
    @RabbitHandler
    public void getMessage(Map msg) {
        log.info("ssm_topic收到消息-->{}", msg);
    }
}