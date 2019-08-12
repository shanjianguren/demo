package com.zhao.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeArray {
    public static final int arraySize  = 30000000;

    public static  List<Integer> makeArray(){
       List<Integer> result=new ArrayList<>();
        Random r=new Random();
        System.out.println("----------"+System.currentTimeMillis());
        for (Integer i=0;i<arraySize;i++){
            result.add(r.nextInt()+10000000);
        }
        System.out.println("----------"+System.currentTimeMillis());
        return result;
    }

    public static void main(String[] args) {
       System.out.println( makeArray().size());
       List<Integer> list=makeArray();
       int sum=0;
       Long start=System.currentTimeMillis();
       System.out.println(start);
       for (int i=0;i< list.size() ;i++){
            sum=sum+list.get(i);
       }
        System.out.println((System.currentTimeMillis()-start)+"MS");
       System.out.println(sum);
    }



}
