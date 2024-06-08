package Interfaces;

interface  A{
    String name = "Sanskar";            //By default every variable in interface is static final
    int age = 23;

    void show();            //By default every method in an interface is public abstract
    void config();
}

class B implements A {             // implements only give you the methods of the interface to define
    public void show(){
        System.out.println("show");
    }

    public void config(){
        System.out.println("config");
    }
}

public class MoreOnInterfaces {
    public static void main(String[] args) {
        System.out.println(A.age);
        System.out.println(A.name);
        A obj;
        obj = new B();
        obj.show();
        obj.config();
    }
    
}
