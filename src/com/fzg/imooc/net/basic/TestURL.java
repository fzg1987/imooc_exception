package com.fzg.imooc.net.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) {
//        getURL();
        getContent();
    }

    private static void getURL(){
        try {
            URL imooc = new URL("http://www.imooc.com");
            URL url = new URL(imooc,"/index.html?username=tom#test");
            System.out.println("协议："+url.getProtocol());
            System.out.println("主机："+url.getHost());
            // 若未指定端口号，则使用默认端口号，此时getPort()方法返回值为-1
            System.out.println("端口："+url.getPort());
            System.out.println("文件路径："+url.getPath());
            System.out.println("文件名："+url.getFile());
            System.out.println("相对路径："+url.getRef());
            System.out.println("获取查询字符串："+url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private static void getContent() {
        try {
            URL url = new URL("https://www.baidu.com");
            // 通过URL的openStream()方法获取URL对象锁表示的资源的字节输入流
            InputStream is = url.openStream();
            // 将字节输入流转换为字符输入流
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            // 为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine(); //读取数据
            while(data != null){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
