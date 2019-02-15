package com.zhao.thread;

public class TestRunnable {
	
	public static class UseRunnable implements Runnable{

//		public UseRunnable(String name) {
//			super();
//		}
		
		public void run() {
			String threadName=Thread.currentThread().getName();
			int i=0;
			while(!Thread.currentThread().isInterrupted()) {
				System.out.println(threadName +"--is run" + i++);
			}
			System.out.println(threadName +"interrupt is "+Thread.currentThread().isInterrupted());
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		UseRunnable use=new UseRunnable();
		Thread test=new Thread(use, "test");
		test.start();
		Thread.sleep(20);
		test.interrupt();
	}

}
