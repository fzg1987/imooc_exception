package com.fzg.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest1 {
    public static void main(String[] args) throws IOException {
        FileUtils.listDirect(new File("D:\\Work\\nginx-1.21.0"));
    }
}
