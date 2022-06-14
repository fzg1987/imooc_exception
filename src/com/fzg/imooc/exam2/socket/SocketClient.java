package com.fzg.imooc.exam2.socket;

import com.fzg.imooc.exam2.entity.File;
import com.fzg.imooc.exam2.entity.User;
import com.fzg.imooc.exam2.util.CommandTransfer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {
    Scanner input = new Scanner(System.in);
    private Socket socket = null;

    //主菜单
    public void showMainMenu() {
        System.out.println("*****欢迎使用imooc文件上传器******");
        System.out.println("1.登陆\n2.注册\n3.退出");
        System.out.println("********************************");
        System.out.println("请选择：");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                showLogin();        //登陆
                break;
            case 2:
                showRegister();     //注册
                break;
            case 3:
                System.out.println("再见，感谢您对本系统的支持！");
                System.exit(0);
            default:
                System.out.println("输入有误！");
                System.exit(0);
        }
    }

    //用户登陆
    private void showLogin() {
        User user = new User();
        CommandTransfer transfer = new CommandTransfer();
        int count = 0;//登陆次数
        while(true){
            count++;
            if(count > 3){
                System.out.println("您已连续三次登陆失败，程序退出！");
                System.exit(0);
            }
            System.out.println("请输入用户名：");
            user.setUsername(input.next());
            System.out.println("请输入密码：");
            user.setPassword(input.next());
            transfer.setCmd("login");
            transfer.setData(user);

            try {
                socket = new Socket("127.0.0.1",8800);
                sendData(transfer);     // 将数据发送到服务器
                transfer = getData();   // 获取服务器返回的数据
                if(!transfer.isFlag()){
                    System.out.println(transfer.getResult());
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeAll();//结束本次socket通信
            }
            showUploadFile();
            System.exit(0);
        }
    }

    private void showRegister() {
        User user = new User();
        CommandTransfer transfer = new CommandTransfer();
        while(true){
            System.out.println("请输入用户名：");
            user.setUsername(input.next());
            System.out.println("请输入密码：");
            user.setPassword(input.next());
            System.out.println("请再次输入密码：");
            String rePassword = input.next();
            if(!user.getPassword().equals(rePassword)){
                System.out.println("两次输入的密码不一致！");
                System.out.println("*******************");
                continue;
            }
            transfer.setCmd("register");
            transfer.setData(user);

            try {
                socket = new Socket("127.0.0.1",8800);
                sendData(transfer);
                transfer = getData();
                System.out.println(transfer.getResult());
                System.out.println("********************");
                if(transfer.isFlag()){
                    break;  //如果注册成功，则不再重复执行注册
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeAll();
            }
            showLogin();    //注册成功后显示登陆
        }
    }
    // 上传文件
    private void showUploadFile() {
        System.out.println("请输入上传文件的绝对路径（如e:/imooc/dog.jpg）：");
        String path = input.next();
        File file = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        String fname = path.substring(path.lastIndexOf("/") + 1);
        try {
            fis = new FileInputStream(path);
            byte[] fcontent = new byte[fis.available()];
            bis = new BufferedInputStream(fis);
            bis.read(fcontent);
            file = new File(fname, fcontent);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        CommandTransfer transfer = new CommandTransfer();
        transfer.setCmd("uploadFile");
        transfer.setData(file);
        try {
            socket = new Socket("127.0.0.1",8800);
            sendData(transfer);
            transfer = getData();
            System.out.println(transfer.getResult());
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private CommandTransfer getData() {
        ObjectInputStream ois = null;
        CommandTransfer transfer = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            transfer = (CommandTransfer) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return transfer;
    }

    private void sendData(CommandTransfer transfer) {
        // 获取输出流，用来向服务端发送信息
        ObjectOutputStream oos = null;      //字节输出流
        ObjectInputStream ois = null;       //字节输入流
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(transfer);
            oos.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void closeAll() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
