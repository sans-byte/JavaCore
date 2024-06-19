package Strings;

public class PerformanceOfString {
    public static void main(String[] args) {
        String str = "";
        for (int i = 0; i < 26; i++) {
            str += (char) ('a' + i);
        }
        System.out.println(str);
    }
}

// Here at every iteration a new string is getting created and the refrence is getting attached to 
// the new created string and all the previous string will be have no refrence and will be 
// removed at the time of garbage collection

// But this {a ,ab, abc ,abcd .............abcdef..z} referencing and derefrencing of this will
// take N2 of time complexity

// To address this issue we use something called StringBuilder.
