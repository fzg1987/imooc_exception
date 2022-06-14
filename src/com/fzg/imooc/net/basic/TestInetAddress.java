package com.fzg.imooc.net.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("计算机名："+address.getHostName());
            System.out.println("IP地址："+address.getHostAddress());
            byte[] bytes = address.getAddress();//获取字节数组形式的IP地址
            System.out.println("字节数组形式的IP地址为：" + Arrays.toString(bytes));
            System.out.println(address);

            // 根据机器名，获取InetAddress实例
//            InetAddress address2 = InetAddress.getByName("fangzongguang");
            InetAddress address2 = InetAddress.getByName("192.168.3.36");

            System.out.println("计算机名："+address2.getHostName());
            System.out.println("IP地址："+address2.getHostAddress());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
