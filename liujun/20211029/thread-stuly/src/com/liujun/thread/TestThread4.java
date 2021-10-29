package com.liujun.thread;

// 多个线程同时操作同一个对象
// 买火车票的例子
public class TestThread4 implements Runnable{
    // 票数
    private int tickleNums=10;
    @Override
    public void run() {

        while(true){
            if(tickleNums<0){
                break;
            }
            // 模拟延时
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+tickleNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4,"小明").start();
        new Thread(testThread4,"老师").start();
        new Thread(testThread4,"黄牛").start();
    }
}
