package cn.sxgan.base.mq.rabbit.controller;

import cn.sxgan.base.mq.rabbit.direct.DirectProductService;
import cn.sxgan.base.mq.rabbit.fanout.FanoutProductService;
import cn.sxgan.base.mq.rabbit.topic.TopicProductService;
import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "springboot整合/整合RabbitMQ", description = "整合RabbitMQ")
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
    @Operation(
            summary = "fanout",
            description = "RabbitMQ fanout模式测试接口",
            parameters = {
                    @Parameter(name = "userId", description = "用户ID", required = true, example = "1234",
                            schema = @Schema(implementation = String.class)),
                    @Parameter(name = "num", description = "数字，用于设置年龄", required = true, example = "22",
                            schema = @Schema(implementation = Integer.class))
            }
    )
    @PostMapping("/fanout")
    public ResponseResult<String> testFanout(@RequestParam String userId, @RequestParam Integer num) {
        fanoutProductService.product(userId, num);
        return ResponseResult.success("发送成功");
    }
    
    /**
     * 测试链接：http://localhost:9090/mq/rabbit/direct
     *
     * @param userId
     * @param num
     * @return
     */
    @Operation(
            summary = "direct",
            description = "RabbitMQ direct模式测试接口",
            parameters = {
                    @Parameter(name = "userId", description = "用户ID", required = true, example = "1234",
                            schema = @Schema(implementation = String.class)),
                    @Parameter(name = "num", description = "数字，用于设置年龄", required = true, example = "18",
                            schema = @Schema(implementation = Integer.class)),
                    @Parameter(name = "key", description = "key,路由：key1、key2", required = true, example = "key1",
                            schema = @Schema(implementation = String.class))
            }
    )
    @PostMapping("/direct")
    public ResponseResult<String> testDirect(@RequestParam String userId, @RequestParam Integer num, @RequestParam String key) {
        directProductService.product(userId, num, key);
        return ResponseResult.success("发送成功");
    }
    
    /**
     * 测试链接：http://localhost:9090/mq/rabbit/direct
     *
     * @param userId
     * @param num
     * @return
     */
    @Operation(
            summary = "topic",
            description = "RabbitMQ topic模式测试接口",
            parameters = {
                    @Parameter(name = "userId", description = "用户ID", required = true, example = "1234",
                            schema = @Schema(implementation = String.class)),
                    @Parameter(name = "num", description = "数字，用于设置年龄", required = true, example = "18",
                            schema = @Schema(implementation = Integer.class)),
                    @Parameter(name = "key", description = "key,*表示有且仅有一个字段，#表示可以有0个，一个，或多个字段", required = true, example = "aa.email.ss.bb",
                            schema = @Schema(implementation = String.class))
            }
    )
    @PostMapping("/topic")
    public ResponseResult<String> testTopic(@RequestParam String userId, @RequestParam Integer num, @RequestParam String key) {
        topicProductService.productTopic(userId, num, key);
        return ResponseResult.success("发送成功");
    }
}
