package Inheritance;


// In every constructor of every class super() method is always present you just can't see it but
// it is always present which calls the constructor of the parent class.

class A extends Object{           //Every root parent class extends Object class you just cant see it
    A() {
        super();
        System.out.println("A default");
    }

    A(int a) {
        super();
        System.out.println("A parameterized");
    }
}

class B extends A{
    B() {
        super();
        System.out.println("B default");
    }

    B(int b) {
        super(b);       //this will call the paremeterized constructor of the parent class
        System.out.println("B parameterized");
    }
}

class C {
    C(){
        System.out.println("Inside C default");
    }

    C(int c){
        this();     //this() calls the constructor of the same class we can also provide 
                    //parameters in it
        System.out.println("Inside C parameterised");
    }
}

public class SuperAndThis {
    public static void main(String[] args) {
        B b = new  B();         //A default
                                //B default

        B b1 = new B(5);       //A parameterized
                                //B parameterized

        C c = new C(5);       //Inside C default
                                //Inside C parameterised
    }
}
