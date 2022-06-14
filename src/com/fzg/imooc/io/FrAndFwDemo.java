package com.fzg.imooc.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("demo/imooc.txt");
        FileWriter fw = new FileWriter("demo/imooc2.txt",false);//true是追加

        char[] buffer = new char[2056];
        int c;
        while((c = fr.read(buffer,0,buffer.length)) != -1){
            fw.write(buffer,0,c);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
