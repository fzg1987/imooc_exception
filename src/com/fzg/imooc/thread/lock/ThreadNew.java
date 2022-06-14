package com.fzg.imooc.thread.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 回顾总结线程的创建
 */
public class ThreadNew {
    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();

        FutureTask<String> futureTask = new FutureTask<String>(new MyThread3());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println("Result is "+ result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
//1. 继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println("MyThread1");
    }
}
//2. 实现Runnable接口
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}
//3. 实现CallAble接口
class MyThread3 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("MyThread3");
        return "Bye!";
    }
}

