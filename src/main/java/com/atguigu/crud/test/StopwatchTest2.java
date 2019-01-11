package com.atguigu.crud.test;

import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import com.alibaba.fastjson.JSON;

//作者:lhh 创建时间:2018年11月26日 上午10:49:05 
public class StopwatchTest2 {
	public static void main(String[] args) {
		StopWatchDemo demo = new StopWatchDemo();
		// 起个名字，在最后面统计信息中会打印出来
		StopWatch stopWatch = new StopWatch("stopwatch test");
		  //记录本地方法的耗时
        stopWatch.start("执行本地方法");
        demo.executeNative();
        stopWatch.stop();

        //记录数据库操作的耗时
        stopWatch.start("执行数据库操作");
        demo.executeDB();
        stopWatch.stop();

        //记录数远程调用耗时
        stopWatch.start("执行远程调用");
        demo.executeRPC();
        stopWatch.stop();

        //打印一份格式化好的汇总统计信息
        System.out.println("A:"+stopWatch.prettyPrint());

 
        //打印统计名称和总的耗时
        System.out.println("B:"+stopWatch.shortSummary());

 
        //一共执行了三段统计，stopWatch.getTaskInfo()返回的数组中就是每段的信息，这里用fastjson转成字符串便于查看
		System.out.println("C:"+JSON.toJSON(stopWatch.getTaskInfo()));
		System.out.println("D:"+stopWatch.getTaskInfo());
 	}
}

class StopWatchDemo {
 
	public static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

 
	public void executeNative() {
		delay(100);
	}

	 
	public void executeDB() {
		delay(200);
	}

	 
	public void executeRPC() {
		delay(300);
	}

}