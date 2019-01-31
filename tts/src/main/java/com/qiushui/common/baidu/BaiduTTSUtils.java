package com.qiushui.common.baidu;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Hello world!
 */
public class BaiduTTSUtils {
    private static final String APP_ID = "15507567";
    private static final String API_KEY = "7V0KRBq6EVk9ic6mdjd9aHAn";
    private static final String SECRET_KEY = "NCIyZ6ZAO3z7xg0CIuK3cpybDHvdktOb";

    private static AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

    public static AipSpeech getClient() {
        if (null == client) {
            client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        }
        return client;
    }

    public static void getTTS(String context, String fileSavePath) {
        // 设置可选参数
//        参数	类型      	描述	                             是否必须
//        tex	String	   合成的文本，使用UTF-8编码，
//                          请注意文本长度必须小于1024字节	     是
//        cuid	String	   用户唯一标识，用来区分用户，
//                           填写机器 MAC 地址或 IMEI 码，
//                           长度为60以内                 	否
//        spd	String	语速，取值0-9，默认为5中语速	        否
//        pit	String	音调，取值0-9，默认为5中语调	        否
//        vol	String	音量，取值0-15，默认为5中音量	        否
//        per	String	发音人选择, 0为女声，1为男声，
//                      3为情感合成-度逍遥，4为情感合成-度丫丫，
//                      默认为普通女	                        否
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");

        TtsResponse res = client.synthesis(context, "zh", 1, options);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, fileSavePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }

    }

}
