package com.example.demo.controller;

import com.example.demo.mq.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/4/3 16:15
 * @Author 86131
 * @Description
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producer;

    @RequestMapping("/sendMsg")
    public String sendMsg() {
        producer.send();
        return "success";
    }

}
