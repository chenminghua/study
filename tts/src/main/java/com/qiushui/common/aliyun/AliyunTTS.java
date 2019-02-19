package com.qiushui.common.aliyun;

import com.alibaba.nls.client.protocol.NlsClient;
import com.alibaba.nls.client.protocol.OutputFormatEnum;
import com.alibaba.nls.client.protocol.SampleRateEnum;
import com.alibaba.nls.client.protocol.tts.SpeechSynthesizer;
import com.alibaba.nls.client.protocol.tts.SpeechSynthesizerListener;
import com.alibaba.nls.client.protocol.tts.SpeechSynthesizerResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author: minghua
 * @date: 2019/1/29 14:11
 * @modified By:
 */
public class AliyunTTS {
    /**
     * SpeechSynthesizerDemo class
     * <p>
     * 语音合成（TTS）Demo
     */
    private String appKey = "hfw7WsE6opS5g8sG";
    private String accessToken = "86e6d429278b45df803186929f6538ba";
    NlsClient client;

    public AliyunTTS(String appKey, String token) {
        //this.appKey = appKey;
        //this.accessToken = token;
        // Step0 创建NlsClient实例,应用全局创建一个即可,默认服务地址为阿里云线上服务地址
        client = new NlsClient(accessToken);
    }

    private static SpeechSynthesizerListener getSynthesizerListener(final String fileSavePath) {
        SpeechSynthesizerListener listener = null;
        try {
            listener = new SpeechSynthesizerListener() {
                File f = new File(fileSavePath);
                FileOutputStream fout = new FileOutputStream(f);

                // 语音合成结束
                @Override
                public void onComplete(SpeechSynthesizerResponse response) {
                    // 事件名称 SynthesisCompleted
                    System.out.println("name: " + response.getName() +
                            // 状态码 20000000 表示识别成功
                            ", status: " + response.getStatus() +
                            // 语音合成文件路径
                            ", output file :" + f.getAbsolutePath()
                    );
                }

                // 语音合成的语音二进制数据
                @Override
                public void onMessage(ByteBuffer message) {
                    try {
                        byte[] bytesArray = new byte[message.remaining()];
                        message.get(bytesArray, 0, bytesArray.length);
                        System.out.println("write array:" + bytesArray.length);
                        fout.write(bytesArray);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listener;
    }

    public void process(String text, String fileSavePath) {
        SpeechSynthesizer synthesizer = null;
        try {
            // Step1 创建实例,建立连接
            synthesizer = new SpeechSynthesizer(client, getSynthesizerListener(fileSavePath));
            synthesizer.setAppKey(appKey);
            // 设置返回音频的编码格式
            synthesizer.setFormat(OutputFormatEnum.WAV);
            //设置发声人
            synthesizer.setVoice("siqi");
            // 设置返回音频的采样率
            synthesizer.setSampleRate(SampleRateEnum.SAMPLE_RATE_16K);
            // 设置用于语音合成的文本
            synthesizer.setText(text);
            // Step2 此方法将以上参数设置序列化为json发送给服务端,并等待服务端确认
            synthesizer.start();
            // Step3 等待语音合成结束
            synthesizer.waitForComplete();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            // Step4 关闭连接
            if (null != synthesizer) {
                synthesizer.close();
            }
        }
    }

    public void shutdown() {
        client.shutdown();
    }


    public static void main(String[] args) {
        System.out.println("hello");
    }


}
