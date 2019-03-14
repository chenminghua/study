package com.qiushui.common.baidu;

import org.junit.Test;

/**
 * Unit test for simple BaiduTTSUtils.
 */
public class BaiduTTSUtilsTest {

    @Test
    public void testGetTTS() {
        String fileSavePath = "D:\\log\\tts\\baidu\\cocacola.mp3";
        String context = "祝您新春愉快";
        BaiduTTSUtils.getTTS(context, fileSavePath);
    }

}
