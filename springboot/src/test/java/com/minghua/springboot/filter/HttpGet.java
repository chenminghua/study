package com.minghua.springboot.filter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-16
 */
public class HttpGet implements Runnable{
    @Override
    public void run() {
        String url = "http://localhost:8080/hello";

        // for version 4.3+
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = httpClientBuilder.build();
        // 连接时间
        // Get请求
        org.apache.http.client.methods.HttpGet httpget = new org.apache.http.client.methods.HttpGet(url);
        try
        {
            // for version 4.3+ 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(2000)
                    .setConnectTimeout(2000).build();
            httpget.setConfig(requestConfig);

            // 设置参数
            //String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
            //httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
            // 发送请求
            HttpResponse httpResponse = httpClient.execute(httpget);

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK)
            {
                System.out.println("Method failed:" + httpResponse.getStatusLine());
            }

            // 获取返回数据
            HttpEntity entity = httpResponse.getEntity();
            String body = EntityUtils.toString(entity, Charset.forName("UTF-8"));
            //System.out.rintln(entity.getContent().);
//            if (entity != null)
//            {
//                EntityUtils.consume(entity);
//            }
        } catch (ParseException e)
        {
            throw e;
        } catch (UnsupportedEncodingException e)
        {
            try {
                throw e;
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e)
        {
            try {
                throw e;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally
        {
            try
            {
                // for 4.3+
                httpClient.close();
            } catch (IOException e)
            {
            }
            httpget.releaseConnection();
            httpClient.getConnectionManager().shutdown();
        }


    }
}
