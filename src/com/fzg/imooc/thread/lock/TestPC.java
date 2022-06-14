package com.fzg.imooc.thread.lock;

//测试生产者消费者模型--> 利用缓冲区解决：管程法
//生产者，消费者，产品，缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Customer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
    }
    // 生产
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("生产者生产了"+ i +"件产品");
            container.push(new Product(i));
        }
    }
}
//消费者
class Customer extends Thread{
    SynContainer container;
    public Customer(SynContainer container){
        this.container = container;
    }
    // 消费
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第"+ container.pop().id +"件产品");
        }
    }
}
//产品
class Product{
    int id;

    public Product(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{
    // 需要一个容器大小
    Product[] products = new Product[10];
    //容器计数器
    int count = 0;
    // 生产者放入产品
    public synchronized void push(Product product){
        // 如果容器满了，则需要等待消费
        if(count == products.length){
            //通知消费者消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果容器没满，就需要丢入产品
        products[count] = product;
        count++;
        notifyAll();
    }
    //消费者消费产品
    public synchronized Product pop(){
        // 如果容器空了，则需要等待生产
        if(count == 0){
            //通知生产者生产，消费者等待
            try {
                wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
        // 如果容器非空，就可以消费产品
        count--;
        Product product = products[count];
        notifyAll();
        // 吃完了，通知生产者生产
        return product;
    }
}