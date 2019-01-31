package com.qiushui.common.aliyun;

import org.junit.Test;

/**
 * @author: minghua
 * @date: 2019/1/29 14:14
 * @modified By:
 */
public class AliyunTTSTest {
    private static final String appKey = "pxxpslI0tBHP63fd";
    private static final String accessToken = "57514053dec14df3a6c3085406d0fb82";

    @Test
    public void testAliyunTTS() {
        AliyunTTS tts = new AliyunTTS(appKey, accessToken);
        String text = "农夫山泉3瓶";
        String fileSavePath = "D:\\log\\tts\\aliyun\\cocacola.mp3";
        tts.process(text, fileSavePath);
        tts.shutdown();
    }

}
