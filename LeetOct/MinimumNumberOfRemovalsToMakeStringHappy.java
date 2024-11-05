package LeetOct;

public class MinimumNumberOfRemovalsToMakeStringHappy {
    public static void main(String[] args) {
        String s = "000000";
        System.out.println(minChanges(s));
    }

    public static int minChanges(String s) {
        int i = 1;
        boolean flag = false;
        int count = 1;
        int track = s.charAt(0);
        int res = 0;
        while (i < s.length()) {
            if (s.charAt(i) == track) {
                count++;
                if (count % 2 == 0) {
                    flag = true;
                    count = 0;
                } else {
                    flag = false;
                }
            } else {
                if (flag) {
                    count = 1;
                    flag = false;
                    track = s.charAt(i);
                } else {
                    res++;
                    count = 0;
                    flag = true;
                }
            }
            i++;
        }
        return res;
    }
}
