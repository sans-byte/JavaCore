package Practice;

import java.util.*;

public class RemoveLetterToQualizeFreq {
    public static void main(String[] args) {
        String s = "abccc";
        System.out.println(equalFrequency(s));
    }

    public static boolean erase(StringBuffer s, int i) {
        s.deleteCharAt(i);
        Map<Character, Integer> m = new HashMap<>();
        for (int x = 0; x < s.length(); x++) {
            m.put(s.charAt(x), m.getOrDefault(s.charAt(x), 0) + 1);
        }
        System.out.println(m);
        for (int p = 0; p < s.length() - 1; p++) {
            if (m.get(s.charAt(p)) != m.get(s.charAt(p + 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalFrequency(String word) {
        StringBuffer s = new StringBuffer(word);
        for (int i = 0; i < s.length(); i++) {
            StringBuffer x = new StringBuffer(s);
            if (erase(x, i))
                return true;
        }
        return false;
    }
}
