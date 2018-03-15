package minghua.threadPool;

import minghua.common.utils.P;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description http://cuisuqiang.iteye.com/blog/2019372
 * @date 17-10-20
 */
public class ThreadPoolTest {
    /**
     *创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     */
    @Test
    public void testCachedThreadPool() {
        P.rintln(Runtime.getRuntime().availableProcessors());
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            final int index = 1;
            try {
                Thread.sleep(index * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    /**
     *创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     */
    @Test
    public void testFixedThreadPool() {
        //TODO 有问题
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i =0; i < 100; i++) {
            final int index = 1;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        P.rintln(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     *创建一个定长线程池，支持定时及周期性任务执行
     */
    @Test
    public void testScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }


    /**
     *创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    @Test
    public void testSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
