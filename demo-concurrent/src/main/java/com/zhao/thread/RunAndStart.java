package com.zhao.thread;


/**
 * 
 * @author Administrator
 *了解run 和start的区别
 */
public class RunAndStart {

	public static class UseThreadRun extends Thread{
		public void run() {
			int i=90;
			while(i>0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程名："+Thread.currentThread().getName()+"----"+i--);
			}
		}
	}
	public static void main(String[] args) {
		UseThreadRun test=new UseThreadRun();
		test.setName("test");
		test.setPriority(5);//线程优先级
		test.run();
		test.start();
	}
}
