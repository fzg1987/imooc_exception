package com.fzg.imooc.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectSerialDemo1 {
    public static void main(String[] args) throws Exception{
        ArrayList al = new ArrayList();
        String file = "demo/obj.dat";
        // 1. 对象序列化
/*
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student stu = new Student("100001","张三",24);
        oos.writeObject(stu);
        oos.flush();
        oos.close();
 */
        // 2. 对象反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student stu = (Student)ois.readObject();
        System.out.println(stu);
        ois.close();
    }
}
