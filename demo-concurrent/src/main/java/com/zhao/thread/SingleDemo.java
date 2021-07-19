package com.zhao.thread;

import com.zhao.thread.deadLock.User;

public class SingleDemo {

    private static User user;

    public SingleDemo() {

    }


    public static User getInstance() {
        if (user == null) {
            synchronized (user) {
                if (user == null) {
                    user = new User();
                }
            }
        }
        return user;
    }
}
