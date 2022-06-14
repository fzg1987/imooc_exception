package com.fzg.imooc.collections;

import com.fzg.imooc.list.Student;
import com.fzg.imooc.list.StudentComparator;

import java.util.*;

/**
 * 1. 通过Collections.sort()方法，对Integer泛型的List进行排序；
 * 2. 对String泛型的List进行排序；
 * 3. 对其他类型泛型的List进行排序，以Student为例
 */
public class collectionsTest {
    //1. 通过Collections.sort()方法，对Integer泛型的List进行排序；
    public void testSort1(){
        List<Integer> integerList = new ArrayList<Integer>();
        // 插入十个100以内的不重复随机整数
        Random random = new Random();
        Integer k;
        for (int i = 0; i < 10; i++) {
            do {
                k = random.nextInt(100);
            } while(integerList.contains(k));
            integerList.add(k);
            System.out.println("成功添加整数：" + k);
        }
        System.out.println("---------排序前------------");
        for (Integer integer : integerList) {
            System.out.println("元素：" + integer);
        }
        Collections.sort(integerList);
        System.out.println("---------排序后------------");
        for (Integer integer : integerList) {
            System.out.println("元素：" + integer);
        }
    }
    //2. 对String泛型的List进行排序；
    public void testSort2(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("microsoft");
        stringList.add("google");
        stringList.add("lenovo");
        stringList.add("baidu");
        System.out.println("---------------排序前----------------");
        for (String str: stringList) {
            System.out.println("元素：" + str);
        }
        Collections.sort(stringList);
        System.out.println("---------------排序后----------------");
        for (String str: stringList) {
            System.out.println("元素：" + str);
        }
    }
    //3. 对其他类型泛型的List进行排序，以Student为例
    public void testSort3(){
        List<Student> studentList = new ArrayList<Student>();
        Random random = new Random();
        studentList.add(new Student(random.nextInt(1000) +"","小红"));
        studentList.add(new Student(random.nextInt(1000)+"","小黄"));
        studentList.add(new Student(random.nextInt(1000)+"","小蓝"));
        studentList.add(new Student(random.nextInt(1000)+"","小绿"));
        System.out.println("---------------排序前----------------");
        for (Student student: studentList) {
            System.out.println("元素：" + student.id + ":" + student.name);
        }
        Collections.sort(studentList);
        System.out.println("---------------排序后----------------");
        for (Student student: studentList) {
            System.out.println("元素：" + student.id + ":" + student.name);
        }
        Collections.sort(studentList,new StudentComparator());
        System.out.println("---------------按照姓名排序后----------------");
        for (Student student: studentList) {
            System.out.println("元素：" + student.id + ":" + student.name);
        }
    }
    public static void main(String[] args) {
        collectionsTest ct = new collectionsTest();
//        ct.testSort1();
//        ct.testSort2();
        ct.testSort3();
    }
}
