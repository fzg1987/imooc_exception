package com.fzg.imooc.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 服务器端，实现基于UDP的用户登录
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        /**
         * 接收客户端发送的数据
         */
        DatagramSocket socket = null;
        // 1. 创建服务器端DatagramSocket,指定端口
        try {
            socket = new DatagramSocket(8800);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        // 2. 创建数据报，用于接收客户端发送的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        // 3. 接收客户端发送的数据
        System.out.println("***服务器端已经启动，等待客户端连接***");
        try {
            socket.receive(packet); //此方法在接收到数据报之前会一直阻塞
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 4. 读取数据
        String info = new String(data,0,packet.getLength());
        System.out.println("我是服务器，客户端说："+info);
        /*
         * 向客户端响应数据
         */
        // 1. 定义客户端的地址、端口号、数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] byte2 = "欢迎您！".getBytes();
        // 2. 创建数据报，包含响应的信息
        DatagramPacket packet2 = new DatagramPacket(byte2,byte2.length,address,port);
        // 3. 响应客户端
        try {
            socket.send(packet2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 4. 关闭资源
        socket.close();
    }
}
