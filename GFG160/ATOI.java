package GFG160;

public class ATOI {
    public static void main(String[] args) {
        String s = "   -0012gfg4";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        int i = 0;
        long sum = 0;
        int sign = 1;
        boolean flag = false;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            } else if (s.charAt(i) == '-' && flag == false) {
                sign = -1;
                flag = true;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                flag = true;
                sum = sum * 10 + ((int) s.charAt(i) - 48);
                if (sum > Integer.MAX_VALUE) {
                    if (sign > 0)
                        return Integer.MAX_VALUE;
                    return Integer.MIN_VALUE;
                }
            } else {
                if (flag == false) {
                    return 0;
                } else {
                    return (int) sum*sign;
                }
            }
            i++;
        }
        return (int) sum*sign;
    }
}
