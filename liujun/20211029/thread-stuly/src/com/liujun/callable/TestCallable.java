package com.liujun.callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

// 实现callable接口
/**
 *calable的好处
 * 1、可以定义返回值
 * 2、可以抛出异常
 */
public class TestCallable implements Callable<Boolean> {
    private String url; // 网络图片地址
    private String name;    // 保存的文件名

    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    // 下载图片执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testCallable1 = new TestCallable("https://p26.toutiaoimg.com/origin/pgc-image/8cdc57ade95245f2bb989d61a6e19a7a?from=pc","1.jpg");
        TestCallable testCallable2 = new TestCallable("https://p26.toutiaoimg.com/origin/pgc-image/8cdc57ade95245f2bb989d61a6e19a7a?from=pc","2.jpg");
        TestCallable testCallable3 = new TestCallable("https://p26.toutiaoimg.com/origin/pgc-image/8cdc57ade95245f2bb989d61a6e19a7a?from=pc","3.jpg");

        // 创建执行服务
        ExecutorService service= Executors.newFixedThreadPool(1);

        // 提交执行
        Future<Boolean> result1= service.submit(testCallable1);
        Future<Boolean> result2= service.submit(testCallable2);
        Future<Boolean> result3= service.submit(testCallable3);

        // 获取结果
        boolean r1=result1.get();
        boolean r2=result2.get();
        boolean r3=result3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        // 关闭服务
        service.shutdown();
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

