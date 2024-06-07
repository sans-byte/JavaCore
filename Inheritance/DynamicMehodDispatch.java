package Inheritance;

class Computer {
    public void show(){
        System.out.println("Inside computer");
    }
}

class Laptop extends Computer{
    public void show(){
        System.out.println("Inside laptop");
    }
}

class MobilePhone extends Computer{
    public void show(){
        System.out.println("Inside mobile phone");
    }
}


public class DynamicMehodDispatch {
    public static void main(String[] args) {
        Computer obj = new Computer();
        obj.show();
        obj = new Laptop();
        obj.show();
        obj = new MobilePhone();
        obj.show();


        //Inside computer           This is an example of run time polymorphism as well as
        //Inside laptop             Dynamic mehtod Dispatch
        //Inside mobile phone
    }
}
