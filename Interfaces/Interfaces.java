package Interfaces;

interface Computer{             //Same like abstract class Computer{                          
    public void code();         //                abstract public void code();
}                               //           }

class Laptop implements Computer{           //while using interface we use implements
    public void code() {
        System.out.println("Code in Laptop");
    }    
}

class Desktop implements Computer{
    public void code(){
        System.out.println("Code in desktop");
    }
}

class Developer{
    public void develop(Computer computer){
        System.out.println("I have computer now I can write code");
    }
}

public class Interfaces {
    
    public static void main(String[] args) {
        Computer desk = new Desktop();
        Computer lap = new Laptop();
    
        Developer d = new Developer();
        d.develop(lap);
        d.develop(desk);
    }

}
