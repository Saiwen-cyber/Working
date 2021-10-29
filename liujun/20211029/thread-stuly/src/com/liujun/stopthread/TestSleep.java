package com.liujun.stopthread;

// 模仿网络延时
public class TestSleep implements Runnable {
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
        TestSleep testSleep = new TestSleep();

        new Thread(testSleep,"小明").start();
        new Thread(testSleep,"老师").start();
        new Thread(testSleep,"黄牛").start();
    }
}
