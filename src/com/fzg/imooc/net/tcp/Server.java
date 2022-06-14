package com.fzg.imooc.net.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 创建服务端Socket，及ServerSocket，指定绑定的端口，并监听此端口。
            serverSocket = new ServerSocket(8888);
            Socket socket = null;
            int count = 0;
            System.out.println("***服务端即将启动，等待客户端连接***");
            // 循环监听等待客户端的连接
            while(true) {
                // 调用accept()方法开始监听，等待客户端的连接
                socket = serverSocket.accept();
                // 创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                // 启动线程
                serverThread.start();
                count ++;
                System.out.println("客户端的数量为：" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP："+ address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
