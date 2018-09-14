package minghua.synchronization;

import org.junit.Test;

import java.util.Scanner;

public class SyncTest {
    @Test
    public void testSync(){
        System.out.println("start");
        for (int i = 0; i < 50; i++){
            Thread thread = new Thread(new Client(1), i + "");
            thread.start();
        }

        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
