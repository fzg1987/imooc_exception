package com.fzg.imooc.thread.lock;

/**
 * 测试生产者消费者问题2，信号灯法，标志位解决
 */
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}
// 生产者-演员
class Player extends Thread{
    TV tv = new TV();
    public Player(TV tv){
        this.tv = tv;
    }
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            if(1 % 2 == 0){
                this.tv.play("快乐大本营播放中");
            }else{
                this.tv.play("抖音：记录美好生活");
            }
        }
    }
}
// 消费者-观众
class Watcher extends Thread{
    TV tv = new TV();
    public Watcher(TV tv){
        this.tv = tv;
    }
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
// 产品-节目
class TV{
    //演员表演，观众等待 T
    //观众观看，演员等待 F
    String voice; //表演的节目
    boolean flag = true;
    // 表演
    public synchronized void play(String voice){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("演员表演了："+voice);
        notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }
    // 观看
    public synchronized void watch(){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("观看了:"+voice);
        // 通知演员表演
        notifyAll();
        flag = !flag;
    }
}