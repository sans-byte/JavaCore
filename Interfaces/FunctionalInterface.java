package Interfaces;

//Functional Interfaces are the interfaces which has exactly one method inside them
// @FunctionalInterface not working here due to some error
interface FuncInter {
    void show();
}

public class FunctionalInterface {
    public static void main(String[] args) {
        FuncInter obj = new FuncInter() {
            public void show() {
                System.out.println("Implementation of the method");
            }
        };
    }
}
