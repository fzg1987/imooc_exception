package com.fzg.imooc.list;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 学生类
 */
public class Student implements Comparable<Student>{
    public String id;
    public String name;
    public Set<Course> courses;

    /**
     * @param id 学生id
     * @param name 学生姓名
     */
    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.courses = new HashSet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Student student) {
        return this.id.compareTo(student.id);
    }
}
