package com.fzg.imooc.thread.sync;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 线程不安全的集合
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new  Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                    System.out.println(list.size());
                }
            }).start();
        }
    }
}
