package com.fzg.imooc.thread.demo01;

//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
public class TestThread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码-----" + i);
        }
    }
    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();//新的线程
//        testThread1.run();//原线程立即执行
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}
