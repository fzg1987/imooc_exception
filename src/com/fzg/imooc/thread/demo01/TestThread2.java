package com.fzg.imooc.thread.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 implements Runnable {
    private String url;
    private String name;
    public TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }
    //下载图片线程的执行体
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        String iName1 = "https://alifei04.cfp.cn/creative/vcg/800/version23/VCG41175510742.jpg";
        String iName2 = "https://tenfei03.cfp.cn/creative/vcg/800/version23/VCG211be3c9c31.jpg";
        String iName3 = "https://tenfei03.cfp.cn/creative/vcg/800/version23/VCG21154786fd8.jpg";

        String lName1 = "file/1.jpg";
        String lName2 = "file/2.jpg";
        String lName3 = "file/3.jpg";

        TestThread2 t1 = new TestThread2(iName1, lName1);
        TestThread2 t2 = new TestThread2(iName2, lName2);
        TestThread2 t3 = new TestThread2(iName3, lName3);

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
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
