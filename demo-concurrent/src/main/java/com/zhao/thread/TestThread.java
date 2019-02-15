package com.zhao.thread;

public class TestThread {

	public static class UseThread extends Thread{
		public UseThread(String name) {
			super(name);
		}
		
		public void run() {
			String threadName=Thread.currentThread().getName();
			int i=0;
			while(!isInterrupted()) {
				
				System.out.println(i++ +threadName);
			}
			System.out.println(threadName  +"--------"+isInterrupted());
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread endThread=new UseThread("aa");
		endThread.setDaemon(true);// ÿª§œﬂ≥Ã
		endThread.start();
		endThread.sleep(20);
		endThread.interrupt();
		
	} 
	
}
