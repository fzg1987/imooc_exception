package com.fzg.imooc.annotation;

import java.util.ArrayList;
import java.util.List;

//什么是注解
public class Test01 extends Object{

    // @Override
    @Override
    public String toString(){
        return super.toString();
    }
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }
    @SuppressWarnings("all")
    public void test2(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
