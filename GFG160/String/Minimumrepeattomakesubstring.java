package GFG160;

public class Minimumrepeattomakesubstring {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdabcdab";
        System.out.println(minRepeats(s1, s2));
    }

    static void createLPS(String pat, int[] LPS) {
        int pre = 0;
        int suf = 1;

        while (suf < pat.length()) {
            if (pat.charAt(pre) == pat.charAt(suf)) {
                LPS[suf] = pre + 1;
                suf++;
                pre++;
            } else {
                if (pre == 0) {
                    LPS[suf] = 0;
                    suf++;
                } else {
                    pre = LPS[pre - 1];
                }
            }
        }
    }

    static boolean KMPForStringMatching(String s1, String s2, int[] LPS) {
        int i = 0; // for text
        int j = 0; // for patter

        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }

            if (j == s2.length()) {
                return true;
            } else if (i < s1.length() && s1.charAt(i) != s2.charAt(j)) {
                if (j != 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;

    }

    static int minRepeats(String s1, String s2) {
        StringBuilder s = new StringBuilder(s1);
        int count = 1;

        while (s.length() < s2.length()) {
            s.append(s1);
            count++;
        }

        int LPS[] = new int[s2.length()];
        createLPS(s2, LPS);

        if (KMPForStringMatching(s.toString(), s2, LPS))
            return count;
        s.append(s1);
        count++;
        if (KMPForStringMatching(s.toString(), s2, LPS))
            return count;
        return -1;
    }
}
