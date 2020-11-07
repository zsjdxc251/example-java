package org.example.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhengshijun
 * @version created on 2020/11/7.
 */
public class CallableSample {

	public static void main(String[] args) {

		FutureTask<String> futureTask = new FutureTask<>(() -> {
			return "12345";
		});

		Thread thread = new Thread(futureTask);
		thread.start();

		String result = null;
		try {
			result = futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}

}
