package com.fzg.imooc.io;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String stuno;
    private String stuname;
    ArrayList arrayList = new ArrayList();
    private transient int stuage;
    //该元素不会进行jvm默认的序列化,也可以自己完成这个元素的序列化
    public Student(){
    }

    public Student(String stuno, String stuname, int stuage){
        super();
        this.stuage = stuage;
        this.stuname = stuname;
        this.stuno = stuno;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }
    @Override
    public String toString(){
        return "Student[stuno=" + stuno + ",stuname=" + stuname+",stuage="+stuage+"]";
    }
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
        s.writeInt(stuage);//自己完成stuage的序列化
    }
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();//把jvm能默认序列化的元素进行反序列化
        stuage = s.readInt();//自己完成stuage的反序列化
    }
}
