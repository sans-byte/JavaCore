// Inner class is like class inside a class

import Outer.Inner;

class Outer {
    public int a;
    public int b;

    class Inner {
        public int c;
        public int d;
        public void config(){
            System.out.println("inside config");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        Outer obj = new Outer();

        // obj.config();  // config is not defined in outer class
                        // We will have to make an object of inner class to use
                        // config method
                        // to access anything inside a class we use . operator with it's object
        Outer.Inner obj1 = obj.new Inner();

        // If we use static before B class declaration then
        // Outer.Inner obj1 = new Outer.Inner(); 
        obj1.config();
    }
}
