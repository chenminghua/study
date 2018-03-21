package minghua.futuretask;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Client {
    @Test
    public void called() throws Exception{
        FutureTask<String> futureTask = new FutureTask<>(new RealData("执行结果数据"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //执行FutureTask，相当于上例中的client.request("name")发送请求
        executorService.submit(futureTask);
        //这里可以用一个sleep代替对其他业务逻辑的处理
        //在处理这些业务逻辑过程中，RealData也正在创建，从而充分了利用等待时间
        Thread.sleep(10000);
        //使用真实数据
        //如果call()没有执行完成依然会等待
        System.out.println("数据=" + futureTask.get());

    }
}
