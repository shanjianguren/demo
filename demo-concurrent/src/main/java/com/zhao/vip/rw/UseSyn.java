package com.zhao.vip.rw;

/**
 *类说明：用内置锁来实现商品服务接口
 */
public class UseSyn implements GoodsService {
	
	private GoodsInfo goodsInfo;
	
	public UseSyn(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	@Override
	public synchronized GoodsInfo getNum() throws InterruptedException {
		Thread.sleep(5);
		return this.goodsInfo;
	}

	@Override
	public synchronized void setNum(int number) throws InterruptedException {
		Thread.sleep(5);
		goodsInfo.changeNumber(number);

	}

}
