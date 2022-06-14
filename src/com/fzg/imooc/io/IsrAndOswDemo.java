package com.fzg.imooc.io;

import java.io.*;

public class IsrAndOswDemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("demo/imooc.txt");
        InputStreamReader isr = new InputStreamReader(in,"utf-8");//默认按项目的编码

        FileOutputStream out = new FileOutputStream("demo/imooc_gbk.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
        int c;
//        while((c = isr.read()) != -1){
//            System.out.print((char)c);
//        }
        char[] buffer = new char[8*1024];
        //批量读取，放入buffer字符数组，从第0个位置开始，最多放置buffer.length
        while((c = isr.read(buffer,0,buffer.length))!= -1){
            String s = new String(buffer,0,c);
            System.out.println(s);
            osw.write(buffer,0,c);
        }
        isr.close();
        osw.close();
        in.close();
        out.close();
    }
}
