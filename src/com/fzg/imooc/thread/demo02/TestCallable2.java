package com.fzg.imooc.thread.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable2 implements Callable<Boolean> {
    private String url;
    private String name;
    TestCallable2(String url, String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownloader2 webDownloader2 = new WebDownloader2();
        webDownloader2.download(url,name);
        System.out.println("正在下载文件"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String iName1 = "https://alifei04.cfp.cn/creative/vcg/800/version23/VCG41175510742.jpg";
        String iName2 = "https://tenfei03.cfp.cn/creative/vcg/800/version23/VCG211be3c9c31.jpg";
        String iName3 = "https://tenfei03.cfp.cn/creative/vcg/800/version23/VCG21154786fd8.jpg";

        String lName1 = "file/1.jpg";
        String lName2 = "file/2.jpg";
        String lName3 = "file/3.jpg";

        TestCallable2 t1 = new TestCallable2(iName1,lName1);
        TestCallable2 t2 = new TestCallable2(iName2,lName2);
        TestCallable2 t3 = new TestCallable2(iName3,lName3);

        // 创建
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交
        Future<Boolean> f1 = ser.submit(t1);
        Future<Boolean> f2 = ser.submit(t2);
        Future<Boolean> f3 = ser.submit(t3);

        // 获取结果
        System.out.println("f1的结果" + f1.get());
        System.out.println("f2的结果" + f2.get());
        System.out.println("f3的结果" + f3.get());
        //关闭
        ser.shutdown();
    }
}
class WebDownloader2 {
    public void download(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
