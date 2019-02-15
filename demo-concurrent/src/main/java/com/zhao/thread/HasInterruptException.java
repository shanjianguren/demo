package com.zhao.thread;

public class HasInterruptException {

	
	public static class UseThread extends Thread{
		public UseThread(String name) {
			super(name);
		}
		
		public void run() {
			String threadName=Thread.currentThread().getName();
//			while(!isInterrupted()) {
			while(!interrupted()) {
				try {
					System.out.println(threadName);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(threadName +" interrupt is "+ isInterrupted());
					interrupt();
				}
			}
			System.out.println(threadName +" interrupt is "+ isInterrupted());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		UseThread test=new UseThread("test");
		test.start();
		Thread.sleep(300);
		test.interrupt();
	}
}
