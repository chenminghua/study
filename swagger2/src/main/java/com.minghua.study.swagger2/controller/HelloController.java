package com.minghua.study.swagger2.controller;

import com.minghua.study.swagger2.utils.AliyunTTS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-15
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    String home(String content) {
        for (int i = 1; i < 4; i++) {
            System.out.println("##############################");
            String text = content + "农夫山泉" + i + "瓶";
            String fileSavePath = "D:\\log\\tts\\aliyun\\cocacola_" + i + ".mp3";
            AliyunTTS.process(text, fileSavePath);
            //AliyunTTS.shutdown();
        }
        return "Hello World!";
    }
}
