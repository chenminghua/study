package com.qiushui.study.netty.client;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * @author: minghua
 * @date: 2018/11/12 10:32
 * @modified By:
 */
public class Client {
    public static final String HOST = "localhost";//服务器地址
    public static final int PORT = 8888;//服务器端口号

    @Test
    public void byteString(){
        String ip = "40.215.223.122";
        int port = 81811;
        byte[] ipArr = new byte[4];
        ipArr = ip.getBytes();
        byte[] portArr = new byte[2];
        portArr = (port + "").getBytes();
        for (byte b : ipArr) {
            System.out.println(b);
        }


        System.out.println("---------------------");
        for (byte b : portArr) {
            System.out.println(b);
        }

        System.out.println("---------------------");

        System.out.println(new Integer(40).byteValue());
        System.out.println(new Integer(192).byteValue()&0xff);
        System.out.println(new Integer(88).byteValue());
        System.out.println(new Integer(11).byteValue());
        //8889;
        //{40,192,88,11,11,11}
    }

    @Test
    public void sendMsg() {
        byte[] msg = "abc".getBytes();
        for (byte b : msg) {
            System.out.println(b);
        }
        byte[] abc = {97, 98, 99};
        System.out.println(new String(abc));
        sendMsgBySocket(msg);
    }

    public static void sendMsgBySocket(byte[] msg) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(HOST, PORT));
            socket.setKeepAlive(true);
            OutputStream out = socket.getOutputStream();
            ByteBuffer header = ByteBuffer.allocate(4);
            header.putInt(msg.length);
            out.write(header.array());
            out.write(msg);
            out.flush();
            InputStream in = socket.getInputStream();
            byte[] buff = new byte[4096];
            int readed = in.read(buff);
            if (readed > 0) {
                String str = new String(buff, 4, readed);
                System.out.println("client received msg from server:" + str);
            }
            out.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client() {
        try {
            Socket s = new Socket(HOST, PORT);
            //构建IO
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            //向服务器端发送一条消息
            bw.write("Hello World!\n");
            bw.flush();
            //读取服务器返回的消息
            //创建读取数据的Reader,里面指定了需要的编码类型。
            BufferedReader rd = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
            // 读取每一行的数据.注意大部分端口操作都需要交互数据。
            String str;
            System.out.println("服务器端响应的消息:");
            while ((str = rd.readLine()) != null) {
                System.out.println(str);
            }
            rd.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}