package com.qiushui.common.aliyun;

import org.junit.Test;

/**
 * @author: minghua
 * @date: 2019/1/29 14:14
 * @modified By:
 */
public class AliyunTTSTest {
    @Test
    public void testAliyunTTS() {
        String text = "关门";
        String fileSavePath = "D:\\log\\tts\\aliyun\\close_door.mp3";
        AliyunTTS.process(text, fileSavePath);
        AliyunTTS.shutdown();
    }

}
