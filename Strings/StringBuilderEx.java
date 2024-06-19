package Strings;

public class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            str.append((char)('a' + i));
        }
        System.out.println(str);

        // Here the string made by string builder is mutable and is getting changed into
        // previous string so time here linear
        
        // we have all the different methods with strign builder

        str.deleteCharAt(3);
        System.out.println(str);
    }
}
