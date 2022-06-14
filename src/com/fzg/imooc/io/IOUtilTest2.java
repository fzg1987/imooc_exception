package com.fzg.imooc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtilTest2 {
    private static String srcFile = "demo/1.jpg";
    private static String destFile2 = "demo/2.jpg";
    private static String destFile3 = "demo/3.jpg";
    private static String destFile4 = "demo/4.jpg";

    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
//            IOUtil.copyFileByBuffer(new File(srcFile),new File(destFile2));//172,263ms
//            IOUtil.copyFileByByte(new File(srcFile),new File(destFile3));//187,574ms
            IOUtil.copyFile(new File(srcFile),new File(destFile4));//54ms
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
