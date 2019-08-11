package com.zhao.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * forkjoin 计算100000000的和
 */
class ForkJoinSumTask extends RecursiveTask<Integer> {
    private int length=MakeArray.arraySize/10;

    private int startIndex;
    private int endIndex;
    private List<Integer> src;
    public ForkJoinSumTask() {
    }

    public ForkJoinSumTask(int startIndex, int endIndex, List<Integer> src) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.src = src;
    }

    @Override
    protected Integer compute() {

        if(endIndex-startIndex<length){
            int sum=0;
            for (int i=0;i<endIndex-startIndex;i++){
                sum=sum+src.get(startIndex+i);
            }
            return  sum;
        }else{
            int mid=(endIndex+startIndex)/2;
            ForkJoinSumTask left=new ForkJoinSumTask(startIndex,mid,src);
            ForkJoinSumTask right=new ForkJoinSumTask(mid+1,endIndex,src);
            invokeAll(left,right);
            return left.join()+right.join();
        }
    }

    public static void main(String[] args) {
        List<Integer> list= MakeArray.makeArray();
        Long start=System.currentTimeMillis();
        System.out.println(start);
        ForkJoinSumTask tast=new ForkJoinSumTask(0,list.size()-1,list);
        ForkJoinPool pool=new ForkJoinPool();
        pool.invoke(tast);
        System.out.println((System.currentTimeMillis()-start)+"MS");
        System.out.println(tast.join());


    }
}
