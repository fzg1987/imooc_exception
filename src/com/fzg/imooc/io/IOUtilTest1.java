package com.fzg.imooc.io;

import java.io.IOException;

public class IOUtilTest1 {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\Users\\fangz\\IdeaProjects\\imooc_exception\\src\\com\\fzg\\imooc\\io\\IOUtilTest.java";
            System.out.println("----------printHex-----------");
            IOUtil.printHex(fileName);
            System.out.println("------printHexByByteArray----");
            IOUtil.printHexByByteArray(fileName);
            System.out.println("-----printHexByByteArray2----");
            IOUtil.printHexByByteArray2(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
