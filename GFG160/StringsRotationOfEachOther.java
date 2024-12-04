package GFG160;

public class StringsRotationOfEachOther {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        System.out.println(areRotations(s1, s2));
    }

    public static void createLPS(String str, int[] lps) {
        int pre = 0;
        int suf = 1;
        while (suf < str.length()) {
            if (str.charAt(pre) == str.charAt(suf)) {
                lps[suf] = pre + 1;
                pre++;
                suf++;
            } else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }

    }

    public static boolean areRotations(String s1, String s2) {
        // return (s1 + s1).contains(s2);

        // With the help of KMP algo
        String str = s1 + s1;
        int lps[] = new int[str.length()];
        createLPS(s2, lps);
        int j = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }

            if (j == s2.length()) {
                return true;
            } else if (i < str.length() && str.charAt(i) != s2.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return false;
    }
}
