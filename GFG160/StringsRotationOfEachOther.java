package GFG160;

public class StringsRotationOfEachOther {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        System.out.println(areRotations(s1, s2));
    }

    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        StringBuilder s = new StringBuilder(s1);
        for (int i = 0; i < s1.length(); i++) {
            s.append(s.charAt(i));
            if (s.substring(i+1).toString().equals(s2))
                return true;
        }
        return false;
    }
}
