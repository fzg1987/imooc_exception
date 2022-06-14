package com.fzg.imooc.io;

import java.io.*;

public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException {
        float[] f [] = new float[4][];
        //对文件进行读写操作
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("demo/imooc.txt")
                ));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("demo/imooc3.txt")));
        PrintWriter pw = new PrintWriter("demo/imooc4.txt");
        FileOutputStream ou = new FileOutputStream("demo/imooc5.txt");
        PrintWriter pw1 = new PrintWriter(ou,true);
        String line;
        while((line = br.readLine())!= null){
            System.out.println(line);//一次读一行，并不能识别换行
            //单独写出换行
            bw.write(line);
            bw.newLine();
            bw.flush();
            pw.println(line);
            pw.flush();
            pw1.println(line);
        }
        br.close();
        bw.close();
        pw.close();
        pw1.close();
    }
}
