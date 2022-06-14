package com.fzg.imooc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {
    @MyAnnotation2(name="小光",schools = "哈工大")
    public void test(){
    };

    @MyAnnotation3("小方")
    public void test2(){

    }
    public static void main(String[] args) {
        Test03 test03 = new Test03();
        test03.test();
    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String name() default "";
    int age() default 0;
    int id() default -1;    //如果默认值为-1，代表不存在

    String[] schools() default {"哈工大","哈工程"};
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}
