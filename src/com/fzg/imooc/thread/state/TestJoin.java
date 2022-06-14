package com.fzg.imooc.thread.state;

/**
 * 测试Join方法，想象为插队
 */
public class TestJoin {
    public static void main(String[] args) {
        TestQueue testQueue = new TestQueue();
        Thread thread = new Thread(testQueue);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            System.out.println("main" + i);
            if(i == 200){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class TestQueue implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了" + i);
        }
    }
}
