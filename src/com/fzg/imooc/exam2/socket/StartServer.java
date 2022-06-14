package com.fzg.imooc.exam2.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8800);
            Socket socket = null;
            System.out.println("服务即将启动，等待客户端连接*******");
            while(true){
                // 开始监听，等待客户端连接
                socket = serverSocket.accept();
                // 多线程通信
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
