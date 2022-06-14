package com.fzg.imooc.annotation;


import java.lang.annotation.*;

public class Test02 {
    @MyAnnotation
    public void test(){

    }
}


/**
 * 定义一个注解，元注解
 * Target表示注解可以用在哪些地方
 * Retention表示我们的注解在什么地方还有效
 * RUNTIME>CLASS>SOURCES
 * Documented 表示是否将我们的注解生成在JAVAdoc中
 * Inherited子类可以继承父类的注解
 */
@Target(value= ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

}