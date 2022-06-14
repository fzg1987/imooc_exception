package com.fzg.imooc.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisDemo {
    public static void main(String[] args) throws IOException {
        String fileName = "demo/dos.dat";
        IOUtil.printHex(fileName);
        DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readLong());
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());
        dis.close();
    }
}
