package com.fzg.imooc.set;

import com.fzg.imooc.list.Course;
import com.fzg.imooc.list.Student;

import java.util.*;

public class SetTest {
    public List<Course> courseToSelect;
    private final Scanner scanner;
    public Student student;
    public SetTest(){
        this.courseToSelect = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void testAdd(){
        Course cr1 = new Course("1","数据结构");
        courseToSelect.add(cr1);

        Course cr2 = new Course("2","C语言");
        courseToSelect.add(cr2);

        Course[] course = {new Course("3","大学英语"), new Course("4","计算机组成原理")};
        courseToSelect.addAll(Arrays.asList(course));

        Course[] course2 = {new Course("5","汇编语言"), new Course("6","大学数学")};
        courseToSelect.addAll(Arrays.asList(course2));
    }
    public void testForEach(){
        System.out.println("有如下课程待选（通过ForEach）");
        for(Course cr:courseToSelect){
            System.out.println("课程："+cr.id + ":" +cr.name);
        }
    }
    public void createStudentAndSelectCourse(){
        student = new Student("1","小方");

        for (Course cr : student.courses) {
            System.out.println("选择了课程：" + cr.id + ":" + cr.name);
        }
        System.out.println("欢迎学生："+ student.id + ":" + student.name);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入课程ID");
            String courseID = scanner.next();
            for (Course cr : courseToSelect) {
                if(cr.id.equals(courseID)){
                    student.courses.add(cr);
                }
            }
        }
    }
    public void testListContains(){
        Course course = courseToSelect.get(0);
        System.out.println("取得课程:" + course.name);
        System.out.println("备选课程中是否包含课程："
                + course.name + "," + courseToSelect.contains(course));
        System.out.println("请输入课程名称：");
        String name = scanner.next();
        Course course2 = new Course();
        course2.name = name;
        System.out.println("新创建课程" + course2.name);
        System.out.println("备选课程中是否包含课程："
                + course2.name + "," + courseToSelect.contains(course2));
        if(courseToSelect.contains(course2)){
            System.out.println("课程：" + course2.name + "的索引位置为：" +
                    courseToSelect.indexOf(course2));
        }
    }

    public void testSetContains(){
        //提示输入课程名称
        System.out.println("请输入学生已选的课程名称：");
        String name = scanner.next();
        Course course = new Course();
        course.name = name;
        System.out.println("新创建的课程："+ course.name);
        System.out.println("备选课程中是否包含课程："
                + course.name + "," + student.courses.contains(course));
    }
    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testListContains();
        st.testForEach();
//        st.createStudentAndSelectCourse();
//        st.testSetContains();
    }
}
