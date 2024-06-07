package Inheritance;


class Retriever{
    public void bark(){
        System.out.println("BHAO BHAO");
    }
}

class Labra extends Retriever{
    public void bark(){     //here the overrifing is happening where child class is overriding parent
                            //class
        System.out.println("I'm Lazy won't bark");
    }
}

public class MethodOverriding {

    public static void main(String[] args) {
        Labra coco = new Labra();
        coco.bark(); 
    }
    
}
