package com.fzg.imooc.io;

import java.io.*;

public class FileOutDemo {
    static final String fileName = "demo/out.dat";
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        FileOutputStream out = new FileOutputStream(fileName,true);
        out.write('A');//写出了'A'的低八位
        out.write('B');//写出了'B'的低八位
        int a = 10;//write只能写八位，写一个int需要写4次每次8位
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);
        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IOUtil.printHex(fileName);
    }
}
