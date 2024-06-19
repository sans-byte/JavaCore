import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b' ); // 195 
        System.out.println("a" + "b");

        System.out.println((char)('a' + 3));
        System.out.println("a" + 1); // String will not be converted to ASCII value

        // When a interger is added to a string it is converted to its wrapper class
        // Integer then internally toString() is called

        System.out.println("Sanskar" + new ArrayList<>()); // Internally toString is called

        System.out.println(new Integer(56)); // 56 here also internally toString is called
        // System.out.println(new Integer(56) + new ArrayList<>()); // This will give error
        // in java + works when either the values are primitive or one of the values are string

        System.out.println(new Integer(56) + "" + new ArrayList<>()); //56[]
    }
}
