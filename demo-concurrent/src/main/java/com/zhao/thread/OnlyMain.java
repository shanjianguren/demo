package com.zhao.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * �ػ��߳�
 * @author Administrator
 *
 */
public class OnlyMain {

	public static void main(String[] args) {
		//������̹߳���ӿ�
		ThreadMXBean bean=ManagementFactory.getThreadMXBean();
		ThreadInfo[] infos=bean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : infos) {
			System.out.println("�߳�id:"+threadInfo.getThreadId()+",�߳�����"+threadInfo.getThreadName());
		}
		
		//endThread.setDaemon(true);//�ػ��߳�
	}
}
