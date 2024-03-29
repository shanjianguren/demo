package com.zhao.vip.deadLock.service;

import com.zhao.vip.deadLock.UserAccount;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：银行转账动作接口
 */
public interface ITransfer {
    void transfer(UserAccount from, UserAccount to, int amount)
    		throws InterruptedException;
}
