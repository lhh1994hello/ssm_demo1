package com.atguigu.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Service;

import com.atguigu.crud.util.SubThread;

//作者:lhh 创建时间:2018年11月12日 下午12:24:27 
@Service
public class ThreadService {
	public List<SubThread> subThreadList = new ArrayList<SubThread>();

	public void threadFun1() throws Exception {
		createSubThread();
		createSubThread();
		createSubThread();
		createSubThread();
		int result = start();
		System.out.println("执行结果:" + result);
	}

	public SubThread createSubThread() {
		SubThread subThread = new SubThread();
		subThreadList.add(subThread);
		return subThread;
	}

	public int start() throws Exception {
		CountDownLatch threadSignal = new CountDownLatch(subThreadList.size());
		for (SubThread subThread : subThreadList) {
			subThread.setThreadsSignal(threadSignal);
			Thread thread = new Thread(subThread);
			thread.start();
		}
		threadSignal.await();
		System.out.println("所有子线程执行完毕...");
		for (SubThread subThread : subThreadList) {
			if (subThread.getStatus() != 0) {
				return 1;
			}
		}
		return 0;
	}

}
