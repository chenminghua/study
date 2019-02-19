package com.qiushui.common.aliyun;

import org.junit.Test;

/**
 * @author: minghua
 * @date: 2019/1/29 14:14
 * @modified By:
 */
public class AliyunTTSTest {
    //my personal app
    private static final String appKey = "hfw7WsE6opS5g8sG";
    private static final String accessToken = "86e6d429278b45df803186929f6538ba";

    @Test
    public void testAliyunTTS() {
        for (int i = 1; i < 4; i++) {
            System.out.println("##############################");
            AliyunTTS tts = new AliyunTTS(appKey, "86e6d429278b45df803186929f6538ba");
            String text = "农夫山泉" + i + "瓶";
            String fileSavePath = "D:\\log\\tts\\aliyun\\cocacola_" + i + ".mp3";
            tts.process(text, fileSavePath);
            tts.shutdown();
        }
    }

}
