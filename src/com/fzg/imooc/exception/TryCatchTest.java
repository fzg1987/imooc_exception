package com.fzg.imooc.exception;

public class TryCatchTest {
    public static void main(String[] args) {
        TryCatchTest tct = new TryCatchTest();
//        int result = tct.test();
//        System.out.println("test()方法，执行完毕！返回值为："+result );
//        int result2 = tct.test2();
//        System.out.println("test2()方法，执行完毕");
        int result3 = tct.test3();
        System.out.println("rest3()方法执行完了，返回值为"+result3);
    }
    /**
     * divider(除数)
     * result(结果)
     * try-catch捕获异常
     */
    public int test(){
        int divider = 10;
        int result = 100;
        try{
            while (divider > -1){
                divider--;
                result = result + 100 / divider;
            }
            return result;
        } catch(Exception e){
            System.out.println("循环抛出异常了");
            e.printStackTrace();
            return -1;
        }
    }
    public int test2(){
        int divider = 10;
        int result = 100;
        try{
            while (divider > -1){
                divider--;
                result = result + 100 / divider;
            }
            return result;
        } catch(Exception e){
            System.out.println("循环抛出异常了");
            e.printStackTrace();
            return result = 999;
        } finally {
            System.out.println("这是finally！！哈哈哈！！");
            System.out.println("我是result，我的值是" + result);
        }
    }
    public int test3(){
        int divider = 10;
        int result = 100;
        try{
            while (divider > -1){
                divider--;
                result = result + 100 / divider;
            }
        } catch(Exception e){
            System.out.println("循环抛出异常了");
            e.printStackTrace();
        } finally {
            System.out.println("这是finally！！哈哈哈！！");
            System.out.println("我是result，我的值是" + result);
        }
        System.out.println("我是test3()，我运行完了");
        return result;
    }
}
