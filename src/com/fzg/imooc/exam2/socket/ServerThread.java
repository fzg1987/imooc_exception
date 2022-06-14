package com.fzg.imooc.exam2.socket;

import com.fzg.imooc.exam2.entity.File;
import com.fzg.imooc.exam2.entity.User;
import com.fzg.imooc.exam2.service.FileService;
import com.fzg.imooc.exam2.service.UserService;
import com.fzg.imooc.exam2.util.CommandTransfer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * 服务器端线程处理类
 */
public class ServerThread extends Thread {
    private Socket socket = null;
    ObjectInputStream ois = null;               //对象输入流
    ObjectOutputStream oos = null;              //对象输出流
    private UserService us = new UserService(); //用户业务对象
    private FileService fs = new FileService(); //文件业务对象

    // 构造方法初始化socket
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            CommandTransfer transfer = (CommandTransfer) ois.readObject();  //读取
            transfer = execute(transfer);       // 执行客户端发送到服务器的指令操作
            oos.writeObject(transfer);          // 响应客户端
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /*
     * 执行客户端发送到服务器的指令操作
     */
    public CommandTransfer execute(CommandTransfer transfer){
        String cmd = transfer.getCmd(); //获取当前操作的指令
        if(cmd.equals("login")){        //用户登录
            User user = (User) transfer.getData();
            boolean flag = us.login(user);
            transfer.setFlag(flag);
            if(flag){                   //登录成功
                transfer.setResult("登陆成功！");
            } else{
                transfer.setResult("用户名或密码不正确，请重新登录！");
            }
        } else if(cmd.equals("register")){//用户注册
            User user = (User)transfer.getData();
            us.register(user);           // 注册用户
            transfer.setResult("注册成功，请登陆！");
        } else if (cmd.equals("uploadFile")) {//上传文件
            File file = (File) transfer.getData();
            fs.save(file);
            transfer.setResult("文件上传成功，再见！");
        } else {
            transfer.setResult("命令有误，退出！");
        }
        return transfer;
    }
}
