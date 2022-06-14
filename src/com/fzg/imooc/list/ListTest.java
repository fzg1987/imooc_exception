package com.fzg.imooc.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public List courseToSelect;
    public ListTest(){
        this.courseToSelect = new ArrayList();
    }

    /**
     * 用于向list中增加课程
     */
    public void testAdd(){
        Course cr1 = new Course("1","数据结构");
        courseToSelect.add(0,cr1);
        Course tmp1 = (Course) courseToSelect.get(0);
        System.out.println("增加了课程：" + tmp1.id + ": " + tmp1.name);

        Course cr2 = new Course("2","C语言");
        courseToSelect.add(0,cr2);
        Course tmp2 = (Course) courseToSelect.get(0);
        System.out.println("增加了课程：" + tmp2.id + ": " + tmp2.name);
/*      Course cr3 = new Course("3","test");
        courseToSelect.add(3,cr3);
        Course tmp3 = (Course) courseToSelect.get(0);
        System.out.println("增加了课程：" + tmp2.id + ": " + tmp2.name);*/

        Course[] course = {new Course("3","大学英语"), new Course("4","计算机组成原理")};
        courseToSelect.addAll(2, Arrays.asList(course));
        Course tmp4 = (Course) courseToSelect.get(2);
        Course tmp5 = (Course) courseToSelect.get(3);
        System.out.println("增加了两门课程：" + tmp4.id + ": " + tmp4.name
                + "; " + tmp5.id + ": " + tmp5.name);
        Course cr3 = new Course("1","数据结构");
        courseToSelect.add(0,cr3);
        Course tmp8 = (Course) courseToSelect.get(0);
        System.out.println("增加了课程：" + tmp8.id + ": " + tmp8.name);
        Course[] course2 = {new Course("5","汇编语言"), new Course("6","大学数学")};
        courseToSelect.addAll(2, Arrays.asList(course2));
        Course tmp6 = (Course) courseToSelect.get(2);
        Course tmp7 = (Course) courseToSelect.get(3);
        System.out.println("增加了两门课程：" + tmp6.id + ": " + tmp6.name
                + "; " + tmp7.id + ": " + tmp7.name);
    }

    public void testGet(){
        int size = courseToSelect.size();
        for(int i = 0;i < size;i++){
            Course cr = (Course) courseToSelect.get(i);
            System.out.println("课程："+cr.id + ": " + cr.name);
        }
    }

    /**
     * 通过迭代器来遍历list
     */
    public void testIterator(){
        Iterator it = courseToSelect.iterator();
        System.out.println("有如下课程待选（通过迭代器）");
        while(it.hasNext()){
            Course cr = (Course) it.next();
            System.out.println("课程："+cr.id + ":" +cr.name);
        }
    }

    /**
     * 通过for each 方法访问集合元素
     */
    public void testForEach(){
        System.out.println("有如下课程待选（通过ForEach）");
        for(Object obj:courseToSelect){
            Course cr = (Course) obj;
            System.out.println("课程："+cr.id + ":" +cr.name);
        }
    }

    /**
     * 修改list中的元素
     */
    public void testModify(){
        courseToSelect.set(4,new Course("7","毛概"));
    }

    public void testRemove(){
        Course cr = (Course) courseToSelect.get(4);
        System.out.println("我的课程："+cr.id + ":" + cr.name + "即将被删除");
        courseToSelect.remove(4);
        System.out.println("成功删除课程4");
    }
    public void testRemoveAll(){
        Course[] courses = {(Course) courseToSelect.get(4),(Course) courseToSelect.get(5)};
        courseToSelect.removeAll(Arrays.asList(courses));
        System.out.println("成功删除4和5位置上的课程");
    }
    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
//        lt.testGet();
//        lt.testIterator();
        lt.testModify();
        lt.testForEach();
        lt.testRemove();
        lt.testForEach();
        lt.testRemoveAll();
        lt.testForEach();
    }
}
