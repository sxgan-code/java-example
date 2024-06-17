package cn.sxgan.base.mq.rabbit.controller;

import cn.sxgan.base.mq.rabbit.direct.DirectProductService;
import cn.sxgan.base.mq.rabbit.fanout.FanoutProductService;
import cn.sxgan.base.mq.rabbit.topic.TopicProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: RabbitMq测试控制器
 * @Author: sxgan
 * @Date: 2024-06-17 08:55
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/mq/rabbit/")
public class TestRabbitMqController {
    @Autowired
    FanoutProductService fanoutProductService;
    @Autowired
    DirectProductService directProductService;
    @Autowired
    TopicProductService topicProductService;
    
    /**
     * 测试链接：http://localhost:9090/mq/rabbit/fanout
     *
     * @param userId
     * @param num
     * @return
     */
    @PostMapping("/fanout")
    public String testFanout(@RequestParam String userId, @RequestParam Integer num) {
        fanoutProductService.product(userId, num);
        return "发送成功";
    }
    
    /**
     * 测试链接：http://localhost:9090/mq/rabbit/direct
     *
     * @param userId
     * @param num
     * @return
     */
    @PostMapping("/direct")
    public String testDirect(@RequestParam String userId, @RequestParam Integer num, @RequestParam String key) {
        directProductService.product(userId, num, key);
        return "发送成功";
    }
    
    /**
     * 测试链接：http://localhost:9090/mq/rabbit/direct
     *
     * @param userId
     * @param num
     * @return
     */
    @PostMapping("/topic")
    public String testTopic(@RequestParam String userId, @RequestParam Integer num, @RequestParam String key) {
        topicProductService.productTopic(userId, num, key);
        return "发送成功";
    }
}
