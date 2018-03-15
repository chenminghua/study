package minghua.common.nio;

import minghua.common.utils.P;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    /** logger */
    private static final Logger LOGGER = LogManager.getLogger(FileReaderTest.class);
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
        P.rintln(stringBuffer.toString());
    }

    @Test
    public void testLength() {
        String a = "你好,中国！";
        LOGGER.info(a);
        Assert.assertTrue(6 ==  a.length());
    }
}
