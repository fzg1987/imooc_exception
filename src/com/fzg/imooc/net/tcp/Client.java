package com.fzg.imooc.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */

public class Client {
    public static void main(String[] args) {
        try {
            // 1. 创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("127.0.0.1",8888);
            // 2. 获取输出流，用来想服务端发送信息
            OutputStream os = socket.getOutputStream();     //字节输出流
            PrintWriter pw = new PrintWriter(os);           //将输出流包装为打印流
            pw.write("用户名：admin;密码：123");
            pw.flush();
            socket.shutdownOutput();                        //关闭输出流

            //3. 获取输入流，用来读取服务端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine())!= null){
                System.out.println("我是客户端，服务端说："+ info);
            }

            //4. 关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
