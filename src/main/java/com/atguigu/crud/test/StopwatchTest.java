package com.atguigu.crud.test;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

//作者:lhh 创建时间:2018年11月26日 上午10:01:48 
public class StopwatchTest {
	public static void main(String[] args) throws InterruptedException {
		Stopwatch stopWatch = Stopwatch.createStarted();//创建
		System.out.println(stopWatch.isRunning());
		if (stopWatch.isRunning()) {
			stopWatch.stop();//这里，如果不加，总是报已经运行的异常
		}
		System.out.println(stopWatch.isRunning());
		stopWatch.start();
		Thread.sleep(1400);
		stopWatch.stop();
		System.out.println(stopWatch.isRunning());
		long elapsed = stopWatch.elapsed(TimeUnit.MILLISECONDS);
		System.out.println(elapsed);
	}
}
