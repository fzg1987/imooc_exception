package com.fzg.imooc.thread.lock;

/**
 * 死锁：多个线程互相抱着对方需要的资源，形成僵持
 */
public class DeadLock {

}
//口红
class Lipstick{

}
class Mirror{

}
class MakeUp extends Thread{
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(0,"灰姑娘");
        MakeUp girl2 = new MakeUp(1,"白雪公主");
        girl1.start();
        girl2.start();
    }
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    MakeUp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }
    @Override
    public void run(){
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //互相持有对方的锁，需要持有对方的资源
    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(this.girlName + "获得镜子的锁");
                };
            }
        }else{
            synchronized (mirror) {
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(2000);
                synchronized (lipstick){
                    System.out.println(this.girlName + "获得镜子的锁");
                };
            }
        }
    }
}
