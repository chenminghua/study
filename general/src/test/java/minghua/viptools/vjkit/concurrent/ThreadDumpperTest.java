package minghua.viptools.vjkit.concurrent;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.vip.vjtools.vjkit.concurrent.Concurrents;
import com.vip.vjtools.vjkit.concurrent.ThreadDumpper;
import com.vip.vjtools.vjkit.concurrent.ThreadUtil;
import minghua.viptools.test.log.LogbackListAppender;
import org.junit.Test;

import com.vip.vjtools.vjkit.concurrent.threadpool.ThreadPoolBuilder;

public class ThreadDumpperTest {

	public static class LongRunTask implements Runnable {

		private CountDownLatch countDownLatch;

		public LongRunTask(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			countDownLatch.countDown();
			ThreadUtil.sleep(5, TimeUnit.SECONDS);
		}
	}

	@Test
	public void test() throws InterruptedException {
		ExecutorService executor = ThreadPoolBuilder.fixedPool().setPoolSize(10).build();
		CountDownLatch countDownLatch = Concurrents.countDownLatch(10);
		for (int i = 0; i < 10; i++) {
			executor.execute(new LongRunTask(countDownLatch));
		}
		countDownLatch.await();

		ThreadDumpper dumpper = new ThreadDumpper();
		dumpper.threadDumpIfNeed();

		LogbackListAppender appender = new LogbackListAppender();
		appender.addToLogger(ThreadDumpper.class);

		// disable,不输出
		dumpper.setEnable(false);
		dumpper.threadDumpIfNeed();
		assertThat(appender.getAllLogs()).hasSize(0);

		// 设置最少间隔,不输出
		dumpper.setEnable(true);
		dumpper.setLeastInterval(1800);

		dumpper.threadDumpIfNeed(); // 重置间隔会重置上一次写日志的时间,因此要调一次把新增的次数用完

		dumpper.threadDumpIfNeed();
		assertThat(appender.getAllLogs()).hasSize(3);

		executor.shutdownNow();

	}

}
