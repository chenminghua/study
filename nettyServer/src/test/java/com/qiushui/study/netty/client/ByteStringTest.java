package com.qiushui.study.netty.client;

import org.junit.Test;

/**
 * @author: minghua
 * @date: 2018/11/12 17:53
 * @modified By:
 */
public class ByteStringTest {
    byte[] sendData = {01, 00, 59, 72, (byte) 0xBB, 49, 01, (byte) 0xF3, 00, 01, 0X0D};

    /**
     * 整数转字节数组
     *
     * @param value type of int   要转换的int值
     * @return byte[] 数组
     */
    public static byte[] intToBytes(int value) {
        byte[] bytes = new byte[4];
        bytes[3] = (byte) ((value >> 24) & 0xFF);
        bytes[2] = (byte) ((value >> 16) & 0xFF);
        bytes[1] = (byte) ((value >> 8) & 0xFF);
        bytes[0] = (byte) (value & 0xFF);
        return bytes;
    }

    public static byte[] intTo2Bytes(int value) {
        byte[] bytes = new byte[2];
        bytes[1] = (byte) ((value >> 8) & 0xFF);
        bytes[0] = (byte) (value & 0xFF);
        return bytes;
    }

    @Test
    public void testPort() {
        byte a = 1;
        byte b = -69;
        int port = (a & 0xff) << 8 | (b & 0xff);
        System.out.println(port);

        int iPort = 8888;
        byte[] bPort = intTo2Bytes(iPort);
        for (byte b1 : bPort) {
            System.out.println(b1);
        }
    }


    @Test
    public void testHexString() {
//        int i=0x12;
//        byte[] bytes = hexStringToBytes(hexString);
//        for (byte b : bytes) {
//            System.out.println(b);
//        }

        //将字节数组转换为16进制字符串

        byte[] buf = {01, 00, 59, 72, (byte) 0xBB, 49, 01, (byte) 0xF3, 00, 01, 0X0D};
        String hexString = BinaryToHexString(buf);//含有空格，如：2A 30 30 30 30 37 56 45 52 53 49 4F 4E 5C 6E 31 24
        System.out.println(hexString);
        hexString = hexString.replace(" ", "");//去除空格
        System.out.println(hexString);
        //String asc = convertHexToString( hexString );//转为ASCII,如：*00007VERSION\n1$
    }

    //将字节数组转换为16进制字符串
    public static String BinaryToHexString(byte[] bytes) {
        String hexStr = "0123456789ABCDEF";
        String result = "";
        String hex = "";
        for (byte b : bytes) {
            hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
            hex += String.valueOf(hexStr.charAt(b & 0x0F));
            result += hex + " ";
        }
        return result;
    }


    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        // toUpperCase将字符串中的所有字符转换为大写
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        // toCharArray将此字符串转换为一个新的字符数组。
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    //返回匹配字符
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }


}
