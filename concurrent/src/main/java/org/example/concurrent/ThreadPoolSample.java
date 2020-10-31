package org.example.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengshijun
 * @version created on 2020/10/31.
 */
public class ThreadPoolSample {
	public static void main(String[] args) {

		ThreadPoolExecutor threadPoolExecutor =
				new CustomThreadPool(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3000),
						new ThreadFactory() {
							private final AtomicInteger atomic = new AtomicInteger(0);

							@Override
							public Thread newThread(Runnable r) {
								return new Thread(r, "custom-" + atomic.incrementAndGet());
							}
						});


		threadPoolExecutor.submit(() -> {

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("demo:"+Thread.currentThread().getName());
		});

		threadPoolExecutor.submit(() -> {

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("demo:"+Thread.currentThread().getName());
		});

		threadPoolExecutor.shutdown();
		System.out.println("执行了关闭");
	}

	static class CustomThreadPool extends ThreadPoolExecutor {

		public CustomThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
		}


		@Override
		public void execute(Runnable command) {
			super.execute(command);
		}
	}

	static class Executor implements Runnable {
		@Override
		public void run() {

		}
	}


}
