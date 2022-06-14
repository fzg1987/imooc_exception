package com.fzg.imooc.lambda;

public class testLambda2 {
    static class PrintInner implements LambdaPrint{
        @Override
        public void print(int a) {
            System.out.println(a + ". 我是静态内部类");
        }
    }
    private static int a = 1;

    public static void main(String[] args) {
        class PrintMember implements LambdaPrint{
            @Override
            public void print(int a) {
                class PrintPart implements LambdaPrint{
                    @Override
                    public void print(int a) {
                        System.out.println(a + "我是局部内部类");
                    }
                }
                System.out.println(a + ". 我是成员内部类");
            }
        }
        LambdaPrint print = new PrintOuter();
        print.print(a++);
        print = new PrintInner();
        print.print(a++);
        print = new PrintMember();
        print.print(a++);
        print = new LambdaPrint() {
            @Override
            public void print(int a) {
                System.out.println(a + ". 我是匿名内部类");
            }
        };
        print.print(a++);
        print = a -> System.out.println(a + ". 我是Lambda表达式");
        print.print(a++);
    }
}
interface LambdaPrint{
    void print(int a);
}

class PrintOuter implements LambdaPrint{
    @Override
    public void print(int a) {
        System.out.println(a + ". 我是外部实现类");
    }
}