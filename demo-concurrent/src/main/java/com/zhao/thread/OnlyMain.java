package com.zhao.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 守护线程
 * @author Administrator
 *
 */
public class OnlyMain {

	public static void main(String[] args) {
		//虚拟机线程管理接口
		ThreadMXBean bean=ManagementFactory.getThreadMXBean();
		ThreadInfo[] infos=bean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : infos) {
			System.out.println("线程id:"+threadInfo.getThreadId()+",线程名："+threadInfo.getThreadName());
		}
		
		//endThread.setDaemon(true);//守护线程
	}
}
