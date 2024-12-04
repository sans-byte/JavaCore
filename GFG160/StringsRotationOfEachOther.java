package GFG160;

public class StringsRotationOfEachOther {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        System.out.println(areRotations(s1, s2));
    }

    public static boolean areRotations(String s1, String s2) {
        return (s1 + s1).contains(s2);
    }
}
