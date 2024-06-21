package Recursion;

// Space complexity is not constant in recursion as every function call takes its own extra space
// in the stack memory

public class Recursion {
    public static void main(String[] args) {
        // Here we are using such small number that's why we are getting output
        // but if we use like 50 also the program will stuck coz for lots for same numbers again and again
        // same recursion call is happening 
        // This issue is addressed under DP ( where we do memoizaion of these things)
        System.out.println(fibbonaci(7));
        printSomething(5);
    }

    static int fibbonaci(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibbonaci((n - 1)) + fibbonaci(n - 2);
    }

    static int printSomething(int n) {
        if (n == 0)
            return n;
        System.out.println(n);
        // This is called tail recursion as the recursive call is the last statement
        // Above one is not tail recursion as two funcition call is being make first the firstone will
        // finish then the next one.
        return printSomething(n - 1);

        // System.out.println(n);
    }
}
