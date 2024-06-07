package AccessModifiers;
public class AccessModifiers {
    public static void main(String[] args) {
        A a = new A();
        //a.privateVariable = 10; //this will give error
        a.changePrivateVariable(10);
        B b = new B();

        b.protectedVariable = 10; // As we are in same package now  it can be accessed here
        // but if we take this file out of this package it will start to give errors;
        // b.privateVariable = 20; // This will give error
    }
}
