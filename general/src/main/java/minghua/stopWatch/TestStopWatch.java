package minghua.stopWatch;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

public class TestStopWatch {
    @Test
    public void test() {
        StopWatch stopWatch = new StopWatch();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopWatch.prettyPrint();
    }
}
