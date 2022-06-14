package com.fzg.imooc.annotation;

import java.lang.annotation.ElementType;

public class Test04 {
    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = Integer.class;
        Class c6 = void.class;
        Class c7 = Override.class;
        Class c8 = Class.class;
        Class c9 = ElementType.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        int a[] = new int[10];
        int b[] = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }


}
