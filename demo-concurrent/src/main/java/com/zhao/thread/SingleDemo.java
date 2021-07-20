package com.zhao.thread;

public class SingleDemo {


    private SingleDemo() {

    }

    private static class SingleHolder  {
        public static SingleDemo demo   = new SingleDemo();
    }

    private static SingleDemo getInstance(){
        return SingleHolder.demo;
    }
}
