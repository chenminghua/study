package minghua.nio;

import minghua.utils.P;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-7
 */
public class FileReaderTest {
    @Test
    public void testFileReader() {
        StringBuffer stringBuffer = new StringBuffer();
        char[] buf = new char[1024];
        try {
            java.io.FileReader fileReader = new java.io.FileReader("E:\\logs\\integralapi\\111.txt");


            FileInputStream fileInputStream = new FileInputStream("E:\\logs\\integralapi\\111.txt");


            while(fileReader.read(buf) > 0) {
                stringBuffer.append(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        P.rintln(stringBuffer);
    }

    @Test
    public void testLength() {
        String a = "你好,中国！";
        Assert.assertTrue(6 ==  a.length());
    }
}
