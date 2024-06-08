package Interfaces;

// class -> class -> extends
// class -> interface -> implements
// interface -> interface -> extends


interface  X{
    void show();       
    void config();
}

interface Y{
    void run();
}

interface Z extends Y{}

class P implements X,Z {                    // We can have multiple inheritance in interfaces
    public void show(){
        System.out.println("show");
    }

    public void config(){
        System.out.println("config");
    }

    public void run(){
        System.out.println("run");
    }
}

public class InterfaceInheritance {
    public static void main(String[] args) {
        X obj;
        obj = new P();
        obj.config();
        obj.show();

        //obj.run()           //This will give error as refrence of X does not know run

        Y obj1 = new P();
        obj1.run();
    }
}
