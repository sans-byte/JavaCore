package LeetOct;

public class SaperateBlackAndWhiteBalls {
    public static void main(String[] args) {
        String s = "001";
        System.out.println(minimumSteps(s));
    }

    static public long minimumSteps(String s) {
        if (s.length() == 0 || s.length() == 1)
            return 0;
        long sum = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '0')
            i--;
        if (i <= 0)
            return 0;
        int j = i;
        while (j >= 0 && s.charAt(j) != '1')
            j--;
        if (j < 0)
            return 0;

        while (i >= 0 && j >= 0) {
            if (s.charAt(j) == '1') {
                sum += i - j;
                i--;
                j--;
            } else {
                j--;
            }
        }
        return sum;
    }
}
