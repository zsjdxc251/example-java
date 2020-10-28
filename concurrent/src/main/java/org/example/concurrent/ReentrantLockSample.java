package org.example.concurrent;

import org.omg.Messaging.SyncScopeHelper;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengshijun
 * @version created on 2020/10/28.
 */
public class ReentrantLockSample {
	static ReentrantLock reentrantLock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {


		Thread thread1 = new Thread(()->{
			try {
				reentrantLock.lockInterruptibly();

				System.out.println("thread1 获取到锁");
			} catch (InterruptedException e) {
				System.out.println("thread1 异常");
				e.printStackTrace();
			}

		});




		Thread thread2 = new Thread(()->{


			try {
				reentrantLock.lockInterruptibly();

				System.out.println("thread2 获取到锁");

			} catch (InterruptedException e) {
				System.out.println("thread2 异常");
				e.printStackTrace();
			}
		});

		thread1.start();

		thread2.start();


		TimeUnit.SECONDS.sleep(1);

		thread1.interrupt();

		thread2.interrupt();





	}
}
