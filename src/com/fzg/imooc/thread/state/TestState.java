package com.fzg.imooc.thread.state;

import static java.lang.Thread.sleep;

/**
 * 观察测试线程的状态
 */
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Thread=========");
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////////////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println("1==========" + state);

        //观察启动后
        thread.start();
        thread.getState();
        System.out.println("2=========="+state);

        while(state != Thread.State.TERMINATED){ //只要线程不终止，就一直输出状态
            Thread.sleep(100);
            state = thread.getState();
            System.out.println("3=========="+state);
        }
    }
}
