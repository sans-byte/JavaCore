package Enums;


enum Status {
    Running, Stopped, Pending, Failed;
}

// enums are basically constants that we can use

public class Enums {

    public static void main(String[] args) {
        
        Status s = Status.Pending;
        System.out.println(s);

        System.out.println(s.ordinal());

        Status[] ss = Status.values();

        for(Status i : ss){
            System.out.println(i);
        }

    }
    
}
