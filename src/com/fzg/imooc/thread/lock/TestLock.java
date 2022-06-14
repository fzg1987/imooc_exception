package com.fzg.imooc.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

// 测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements Runnable{
    int tickNums = 10;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        buyTicket();
    }
//    synchronized void buyTicket(){
    void buyTicket(){
        while(true){
            try{
                lock.lock();
                if(tickNums > 0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(tickNums--);
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

