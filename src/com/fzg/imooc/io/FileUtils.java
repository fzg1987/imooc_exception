package com.fzg.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void listDirect(File dir) throws IOException {
        if(!dir.exists()){
            throw new IllegalArgumentException("目录" + dir + "不存在！");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir + "不是目录！");
        }
//        String[] fileNames = dir.list();//返回字符串数组，直接子的名称，不包含子目录下的内容
//        for (String filename: fileNames) {
//            System.out.println(dir + "\\" + filename);
//        }
        File[] files = dir.listFiles();
        if(files != null && files.length > 0){
            for (File file:files) {
                if(file.isDirectory()){
                    listDirect(file);
                }else {
                    System.out.println(file);
                }
            }
        }
    }
}
