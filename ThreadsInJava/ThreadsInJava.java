package ThreadsInJava;

class A extends Thread {
    public void show() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
            Thread.sleep(10); //Thread sleep will stop and with for 10 millisec to execute again
        }
    }
}

class B extends Thread {
    public void show() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}

public class ThreadsInJava {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        // We can also get and get and set priority of any thread
        // a.setPriority(Thread.MAX_PRIORITY);
        // a.setPriority(Thread.MIN_PRIORITY);
        // a.setPriority(Thread.NORM_PRIORITY);
        // a.getPriority();
        // By default the priority is set to NORM which is 5

        a.start(); //Here as A and B are extending thread class this class gives us a method
        b.start(); // Named start which will SIMULTANIOUSLY call the run method in the class
        // Basically it let's us run multiple threads at the same time
    }

}
