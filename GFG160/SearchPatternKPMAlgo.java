package GFG160;

import java.util.*;

//TODO:revisit LPS

public class SearchPatternKPMAlgo {
    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba", pat = "aaba";
        System.out.println(search(pat, txt));
    }

    public static void createLPS(String pat, int[] lps) {
        int pre = 0;
        int suf = 1;
        while (suf < pat.length()) {
            if (pat.charAt(suf) == pat.charAt(pre)) {
                lps[suf] = pre + 1;
                suf++;
                pre++;
            } else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }
        System.out.println(Arrays.toString(lps));
    }

    public static ArrayList<Integer> search(String pat, String txt) {
        int lps[] = new int[pat.length()];
        List<Integer> res = new ArrayList<>();
        createLPS(pat, lps);

        int i = 0;// pointer to text
        int j = 0;// pointer to pattern
        while (i < txt.length()) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == pat.length()) {
                res.add(i - j);
                j = lps[j - 1];
            } else if (i < txt.length() && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }

        }
        return new ArrayList<>(res);
    }
}
