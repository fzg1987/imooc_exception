package com.fzg.imooc.thread.demo03;

public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("我爱你")).start();

        new WeddingCompany(new You()).HappyMarry();
    }

}
interface Marry{

    void HappyMarry();

}
// 真实角色，
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("小光要结婚了，超开心！");
    }
}

class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("婚庆公司-婚后整理工作");
    }

    private void before() {
        System.out.println("婚庆公司-婚前准备工作");
    }
}
