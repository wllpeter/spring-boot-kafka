package com.example.demo.mq;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Date 2020/4/3 16:17
 * @Author 86131
 * @Description
 */
@Component
public class KafkaProducer {

    private static Logger logger = LogManager.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        for (int i = 0; i < 5; i++) {
            Map<String, Object> message = new HashMap<>(16);
            message.put("ID", System.currentTimeMillis());
            message.put("msg", UUID.randomUUID().toString().replace("-", "") + "---" + i);
            logger.info("发送消息 ----->>>>>  message = {}", gson.toJson(message));
            kafkaTemplate.send("hello", gson.toJson(message));
        }
    }

}
