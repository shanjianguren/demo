package com.zhao.thread;

/**
 * 单例模式
 */
public class SingleEHan {

    private static final SingleEHan single = new SingleEHan();

    private SingleEHan() {
    }

    public static final SingleEHan getInstance() {
        return single;
    }
}
