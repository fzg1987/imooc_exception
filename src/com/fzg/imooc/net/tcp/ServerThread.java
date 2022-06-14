package com.fzg.imooc.net.tcp;

import java.awt.print.PrinterGraphics;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        // 获取客户端提交的登录信息
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+ info);
            }
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush();

            socket.shutdownInput();//关闭输入流
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (is != null)
                    is.close();
                if(isr != null)
                    isr.close();
                if(br != null)
                    br.close();
                if(os != null)
                    os.close();
                if(pw != null)
                    pw.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
