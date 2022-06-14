package com.fzg.imooc.io;

import java.io.*;

public class ObjectSerialDemo2 {
    public static void main(String[] args) throws Exception {
        /*
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("demo/obj1.dat"));
        Foo2 foo2 = new Foo2();
        oos.writeObject(foo2);
        oos.flush();
        oos.close();
        */
        /*
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("demo/obj1.dat"));
        Foo2 foo2 = (Foo2)ois.readObject();
        ois.close();
        System.out.println(foo2);
        */
        /*
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("demo/obj1.dat"));
        Bar2 bar2 = new Bar2();
        oos.writeObject(bar2);
        oos.flush();
        oos.close();
        */
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("demo/obj1.dat"));
        Bar2 bar2 = (Bar2)ois.readObject();
        ois.close();
        System.out.println(bar2);
    }
}
class Foo implements Serializable{
    public Foo(){
        System.out.println("foo...");
    }
}
class Foo1 extends Foo{
    public Foo1(){
        System.out.println("foo1...");
    }
}
class Foo2 extends Foo1{
    public Foo2(){
        System.out.println("foo2...");
    }
}

class Bar{
    public Bar(){
        System.out.println("bar...");
    }
}
class Bar1 extends Bar{
    public Bar1(){
        System.out.println("bar1...");
    }
}
class Bar2 extends Bar1 implements Serializable{
    public Bar2(){
        System.out.println("bar2...");
    }
}
