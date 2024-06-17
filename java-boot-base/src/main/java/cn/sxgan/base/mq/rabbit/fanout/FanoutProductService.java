package cn.sxgan.base.mq.rabbit.fanout;

import cn.sxgan.common.entity.UserMockdataPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FanoutProductService {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 生成订单信息
     *
     * @param userID 用户ID
     * @param num    产品数量
     */
    public void product(String userID, Integer num) {
        String routeKey = "";
        // 使用map集合打包数据，并发送，注意接收时使用Map类型接收
        UserMockdataPO userMockdataPO = new UserMockdataPO();
        userMockdataPO.setUserId(Integer.parseInt(userID));
        userMockdataPO.setAge(num);
        userMockdataPO.setEmail("sxgan@foxmail.com");
        log.info("用户ID信息,即将发送消息-->{}", userID);
        // 参数1：交换机名称  参数2：路由Key 参数3：object类型数据，此处发送map集合
        rabbitTemplate.convertAndSend("test_fanout_exchange", routeKey, userMockdataPO);
    }
}