package com.fzg.imooc.io;

/**
 * Java-IO
 */
public class EncodeDemo {
    public static void main (String[] args) throws Exception {
        String s = "慕课ABC";
        byte[] byte1 = s.getBytes();//转换成字节序列用的是项目默认的编码GBK
        System.out.println("项目默认编码");
        for(byte b : byte1){
            //把字节（转换成了int）以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        System.out.println("GBK编码");
        // GBK中文占用2个字节，英文占用一个字节
        byte[] byte2 = s.getBytes("gbk");
        for (byte b : byte2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        System.out.println("UTF-8编码");
        // UTF-8中文占用3个字节，英文占用1个字节
        byte[] byte3 = s.getBytes("utf-8");
        for (byte b : byte3) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        System.out.println("utf-16be编码");
        // JAVA是双字节编码 utf-16be
        byte[] byte4 = s.getBytes("utf-16be");
        for (byte b : byte4) {
            // utf-16be中文占用2个字节, 英文占用2个字节
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        /*
         * 当你的字节序列是某种编码时，这个时候想把字节序列标称
         * 字符串，也需要用这种编码方式，否则就会乱码。
         */
        System.out.println();
        System.out.println("默认复原:");
        System.out.println(new String(byte1));
        System.out.println("GBK复原:");
        System.out.println(new String(byte2,"GBK"));
        System.out.println("UTF8复原:");
        System.out.println(new String(byte3,"UTF-8"));
        System.out.println("UTF16BE复原:");
        System.out.println(new String(byte4,"UTF-16BE"));
        /*
         * 文本文件，就是字节序列
         * 可以是任意编码的字节序列
         * 如果我们在中文机器上直接创建文本文件，那么该文本只认识ansci编码
         */
    }
}
