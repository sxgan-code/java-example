package cn.sxgan.base.mq.rabbit.fanout;

import cn.sxgan.common.entity.UserMockdataPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = {"email_queue"}) // 接收数据的队列名
public class FanoutConsumerService {
    @RabbitHandler  // 通过此注解，会将队列中的消息注入到参数msg中
    public void getMessage(UserMockdataPO user) {  // 注意接收数据的数据类型，应与发送数据的类型相同，防止反序列化失败
        log.info("收到消息=====》{user}" + user.toString());
    }
}