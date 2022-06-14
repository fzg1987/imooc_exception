package com.fzg.imooc.thread.sync;

/**
 * 1. 线程不安全，有负数
 * 2. 线程不安全，有
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"苦逼的我").start();
        new Thread(buyTicket,"牛逼的你").start();
        new Thread(buyTicket,"可恶的黄牛").start();
    }
}
class BuyTicket implements Runnable{
    private int tickets = 10;
    boolean flag = true;
    @Override
    public void run() {
        //买票
        while (flag){
            try {
                Thread.sleep(1000);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronize同步方法，锁的是this
    private synchronized void buy() {
        //判断是否有票
        if(tickets <= 0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "拿到了" + tickets--);
    }
}
