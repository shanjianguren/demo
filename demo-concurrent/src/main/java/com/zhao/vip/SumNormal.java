package com.zhao.vip;


/**
 * 单线程执行累加
 */
public class SumNormal {
	
	public static void main(String[] args) throws InterruptedException {
	    int count = 0;
	    int[] src = MakeArray.makeArray();

	    long start = System.currentTimeMillis();
	    for(int i= 0;i<src.length;i++){
		Thread.sleep(1);
	    	count = count + src[i];
	    }
	    System.out.println("The count is "+count
	            +" spend time:"+(System.currentTimeMillis()-start)+"ms");		
	}

}
