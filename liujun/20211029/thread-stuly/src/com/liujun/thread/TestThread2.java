package com.liujun.thread;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url; // 网络图片地址
    private String name;    // 保存的文件名

    public TestThread2(String url,String name){
        this.url=url;
        this.name=name;
    }

    // 下载图片执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2("https://p26.toutiaoimg.com/origin/pgc-image/8cdc57ade95245f2bb989d61a6e19a7a?from=pc","1.jpg");
//        TestThread2 testThread2 = new TestThread2("https://p26.toutiaoimg.com/origin/pgc-image/8cdc57ade95245f2bb989d61a6e19a7a?from=pc","2.jpg");
//        TestThread2 testThread3 = new TestThread2("https://p26.toutiaoimg.com/origin/pgc-image/8cdc57ade95245f2bb989d61a6e19a7a?from=pc","2.jpg");
        testThread1.start();
    }
}

// 下载器
class WebDownloader{
    // 下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloder方法出现问题");
        }
    }
}
