package com.fzg.imooc.thread.sync;

/**
 * 不安全的取钱
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account("结婚基金",1000);
        Bank boyFriend = new Bank(account,50,"小a");
        Bank girlFriend = new Bank(account,100,"小b");
        boyFriend.start();
        girlFriend.start();
    }
}

//账户
class Account{
    String name;
    int balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}
class Bank extends Thread{
    Account account;
    int money;//取钱金额
    int cash;//现金
    public Bank(Account account,int money, String name){
        super(name);
        this.account = account;
        this.money = money;
    }
    @Override
    public void run(){
        synchronized (account){
            //判断是否有钱
            if(account.balance < money){
                System.out.println("账户" + account.name + "的余额为：" + account.balance);
                System.out.println(Thread.currentThread().getName() + "取" + money + "，余额不足");
                return;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //账户余额减少
            account.balance = account.balance - money;
            //现金余额增加
            cash = cash + money;
            System.out.println(Thread.currentThread().getName() + "取走现金" + cash);
            System.out.println("账户" + account.name + "的余额还剩：" + account.balance);
        }
    }
}

