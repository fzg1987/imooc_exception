package com.fzg.imooc.lambda;

/**
 * 推导lambda表达式
 */
public class testLambda1 {
    // 3. 静态内部类
    static class Like2 implements Ilike{
        @Override
        public void lambda() {
            System.out.println("2. 我是静态内部类！");
        }
    }
    public static void main(String[] args) {
        //4. 局部内部类
        class Like3 implements Ilike{
            @Override
            public void lambda() {
                System.out.println("3. 我是局部内部类");
            }
        }
        Ilike like = new Like();
        like.lambda();
        like = new Like2();
        like.lambda();
        like = new Like3();
        like.lambda();
        //5. 匿名内部类
        like = new Ilike() {
            @Override
            public void lambda() {
                System.out.println("4. 我是匿名内部类");
            }
        };
        like.lambda();
        //6. lambda表达式
        like = ()->System.out.println("5. 我是Lambda表达式");
        like.lambda();
    }
}
// 1. 定义一个函数式接口
interface Ilike {
    void lambda();
}

// 2. 实现类
class Like implements Ilike{
    @Override
    public void lambda() {
        System.out.println("1. 我是正常的外部实现类");
    }
}