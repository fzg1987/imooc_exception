package com.fzg.imooc.thread.demo02;

//线程创建方式三：实现callable接口

import com.fzg.imooc.thread.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * callable的好处：
 * 1. 可以定义返回值
 * 2. 可以抛出异常
 * 3. 实现方式复杂，需要创建服务，提交执行，获取结果，关闭服务
 *
 */
public class TestCallable implements Callable {
    private String url;
    private String name;
    public TestCallable(String url, String name){
        this.url = url;
        this.name = name;
    }
    //下载图片线程的执行体

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String iName1 = "https://alifei04.cfp.cn/creative/vcg/800/version23/VCG41175510742.jpg";
        String iName2 = "https://tenfei03.cfp.cn/creative/vcg/800/version23/VCG211be3c9c31.jpg";
        String iName3 = "https://tenfei03.cfp.cn/creative/vcg/800/version23/VCG21154786fd8.jpg";

        String lName1 = "file/1.jpg";
        String lName2 = "file/2.jpg";
        String lName3 = "file/3.jpg";

        TestCallable t1 = new TestCallable(iName1, lName1);
        TestCallable t2 = new TestCallable(iName2, lName2);
        TestCallable t3 = new TestCallable(iName3, lName3);

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        // 获取结果
        System.out.println("r1的结果为：" + r1.get());
        System.out.println("r2的结果为：" + r2.get());
        System.out.println("r3的结果为：" + r3.get());

        // 关闭服务
        ser.shutdown();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}