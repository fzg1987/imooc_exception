package com.fzg.imooc.thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

// 模拟倒计时
public class TestSleep2 {
    public void tenDown(){
        int num = 10;
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("倒计时" + num--);
                if(num <= 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        TestSleep2 testSleep2 = new TestSleep2();
//        testSleep2.tenDown();
        // 打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());//获取当前系统时间
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
