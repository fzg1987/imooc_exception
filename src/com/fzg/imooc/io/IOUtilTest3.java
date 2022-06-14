package com.fzg.imooc.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {
    private static String srcFile = "demo/in.dat";
    private static String destFile = "demo/out.dat";
    public static void main(String[] args) {
        try {
            IOUtil.copyFile(new File(srcFile), new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
