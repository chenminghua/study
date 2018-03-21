package minghua.futuretask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Callable;

@AllArgsConstructor
@Getter
@Setter
public class RealData implements Callable<String> {
    protected String data;

    @Override
    public String call() throws Exception {
        //业务真的非常慢呀
        Thread.sleep(10000);
        return data;
    }
}
