package com.qiushui.common.aliyun;

import com.alibaba.nls.client.AccessToken;
import com.aliyuncs.exceptions.ClientException;
import org.junit.Test;

/**
 * @author: minghua
 * @date: 2019/1/29 14:14
 * @modified By:
 */
public class AliyunTTSTest {
    @Test
    public void testAliyunTTS() {
        String text = "谢谢惠顾";
        String fileSavePath = "D:\\log\\tts\\aliyun\\goodbye.mp3";
        AliyunTTS.process(text, fileSavePath);
        AliyunTTS.shutdown();
    }

}
