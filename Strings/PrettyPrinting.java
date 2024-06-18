package Strings;

public class PrettyPrinting {
    public static void main(String[] args) {
        float f = 123.5678f;
        System.out.printf("This is a pretty string with %.2f value",f);
        System.out.println();
        String s = "Hello";
        System.out.printf("%s world %s",s,"Goodmorning");
    }
}
