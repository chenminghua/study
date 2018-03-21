package minghua.common.imporvejava.uid;

import java.io.*;

public class SerializationUtils {
    private static final String FILE_NAME = "d:/userObj.bin";

    public static void writeObject(Serializable obj) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            outputStream.writeObject(obj);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取object
     * @return
     */
    public static Object readObject(){
        Object object = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
            object = inputStream.readObject();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
