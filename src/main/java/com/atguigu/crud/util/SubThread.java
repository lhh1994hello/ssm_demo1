package com.atguigu.crud.util;

import java.util.concurrent.CountDownLatch;

//作者:lhh 创建时间:2018年11月12日 下午12:26:00 
public class SubThread implements Runnable {
	private int status = 99;
	private CountDownLatch threadsSignal;

	@Override
	public void run() {
		System.out.println("开始执行...," + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		status = 0;
		System.out.println("执行完毕...," + Thread.currentThread().getName());
		threadsSignal.countDown();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public CountDownLatch getThreadsSignal() {
		return threadsSignal;
	}

	public void setThreadsSignal(CountDownLatch threadsSignal) {
		this.threadsSignal = threadsSignal;
	}

}
