package com.fzg.imooc.map;

import com.fzg.imooc.list.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
    public Map<String, Student> students;
    public MapTest(){
        this.students = new HashMap<String, Student>();
    }

    /**
     * 测试添加：输入学生ID，判断是否占用
     * 若未被占用，则输入姓名，创建新学生对象，并且添加到students中
     */
    public void testPut(){
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入学生ID");
            String ID = scanner.next();
            Student stu = students.get(ID);
            if(stu == null){
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                Student student = new Student(ID,name);
                students.put(ID,student);
                System.out.println("成功添加学生: " + students.get(ID).name);
            }else {
                System.out.println("该学生ID已被占用！");
                continue;
            }
        }
    }
    public void testKeySet(){
        Set<String> keySet = students.keySet();
        System.out.println("共有" + keySet.size() + "个学生");
        for ( String stuID : keySet ) {
            Student stu = students.get(stuID);
            if(stu != null){
                System.out.println("学生：" + stu.name);
            }
        }
    }
    public void testRemove(){
        System.out.println("请输入要删除的学生ID！");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String ID = scanner.next();
            Student st = students.get(ID);
            if (st == null) {
                System.out.println("该ID不存在");
                continue;
            }
            students.remove(ID);
            System.out.println("成功删除学生：" + st.name);
            break;
        }
    }
    public void testEntrySet(){
        //通过entrySet方法，返回Map中的所有键值对
        Set<Map.Entry<String,Student>> entrySet = students.entrySet();
        for (Map.Entry<String,Student> entry: entrySet) {
            System.out.println("取得键：" + entry.getKey());
            System.out.println("对应的值为：" + entry.getValue().name);
        }
    }
    public void testModify(){
        //提示输入要修改的学生ID
        System.out.println("请输入要修改的学生ID");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String stuID = scanner.next();
            Student stu = students.get(stuID);
            if(stu == null){
                System.out.println("该ID不存在，请重新输入!");
                continue;
            }
            System.out.println("请输入学生的姓名");
            String name = scanner.next();
            students.put(stuID,new Student(stuID,name));
            System.out.println("修改成功！");
            break;
        }
    }

    public void testContainsKeyOrValue(){
        //提示输入学生id
        System.out.println("请输入要查询的学生ID：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        //在Map中，用containsKey()方法，判断是否存在某个key值
        System.out.println("您输入的学生ID为：" + id
                + "，在学生映射表中是否存在：" + students.containsKey(id));
        if(students.containsKey(id)){
            System.out.println("对应的学生姓名为：" + students.get(id).name);
        }
        //用containsValue()方法，判断是否存在某个value值
        System.out.println("请输入要查询的学生姓名：");
        String name = scanner.next();
        if(students.containsValue(new Student(null,name))){
            System.out.println("对应的学生存在！");
        }else {
            System.out.println("对应的学生不存在！");
        }
    }
    public static void main(String[] args) {
        MapTest mp = new MapTest();
        mp.testPut();
        mp.testKeySet();
//        mp.testRemove();
//        mp.testEntrySet();
//        mp.testModify();
//        mp.testEntrySet();
        mp.testContainsKeyOrValue();
    }
}
