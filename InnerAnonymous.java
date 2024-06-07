
class SomeClass{
    public void show(){
        System.out.println("The show must go on");
    }
}

public class InnerAnonymous {

    public static void main(String[] args) {
        SomeClass s = new SomeClass(){
            public void show(){
                System.out.println("Need to wait for sometime");
            }
        };
    
        s.show();
    }
}
