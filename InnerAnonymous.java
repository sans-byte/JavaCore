
class SomeClass{
    public void show(){
        System.out.println("The show must go on");
    }
}

abstract class SomeOtherClass{
    abstract public void someMethod();
    abstract public void someOtherMethod();
}

public class InnerAnonymous {

    public static void main(String[] args) {
        SomeClass s = new SomeClass(){
            public void show(){
                System.out.println("Need to wait for sometime");
            }
        };
    
        s.show();


        SomeOtherClass s1 = new SomeOtherClass() {

            public void someMethod() {
                System.out.println("Some Abstract Method");
            }

            public void someOtherMethod() {
                System.out.println("Some Other Abstract Method");
            }
        };
    }
}
