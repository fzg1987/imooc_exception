package com.fzg.imooc.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String file = "demo/dos.dat";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        //utf-8
        dos.writeUTF("中国");
        //utf-16be
        dos.writeChars("中国");
        dos.close();
        IOUtil.printHex(file);
    }
}
