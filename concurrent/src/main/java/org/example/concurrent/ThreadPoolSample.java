package org.example.concurrent;

import org.omg.Messaging.SyncScopeHelper;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *    观察 线程状态 （线程休眠和线程没有被运行时状态的不同），什么情况下线程池可以被关闭时线程池完结
 *
 * @author zhengshijun
 * @version created on 2020/10/31.
 */
public class ThreadPoolSample {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		ThreadPoolExecutor threadPoolExecutor =
				new CustomThreadPool(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3000),
						new ThreadFactory() {
							private final AtomicInteger atomic = new AtomicInteger(0);

							@Override
							public Thread newThread(Runnable r) {
								return new Thread(r, "custom-" + atomic.incrementAndGet());
							}
						});

		threadPoolExecutor.execute(()->{

			System.out.println("-");
		});
		threadPoolExecutor.execute(()->{
			System.out.println("-");
		});

//		new Thread(()->{
//			while (Thread.currentThread().isAlive()) {
//				System.out.println("threadPoolExecutor.getActiveCount():"+threadPoolExecutor.getActiveCount());
//				System.out.println("Thread.currentThread().isAlive():"+Thread.currentThread().isAlive());
//				try {
//					TimeUnit.MILLISECONDS.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
//		threadPoolExecutor.submit(() -> {
//
//			try {
//				TimeUnit.SECONDS.sleep(3);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("demo:"+Thread.currentThread().getName());
//		});
//
//		threadPoolExecutor.submit(() -> {
//
//			try {
//				TimeUnit.SECONDS.sleep(3);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("demo:"+Thread.currentThread().getName());
//		});
//
//		threadPoolExecutor.shutdown();
//		Future<String> future = threadPoolExecutor.submit(()->{
//			return "";
//		});
//		System.out.println(future.get(1,TimeUnit.SECONDS));
//		System.out.println("执行了关闭");


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
