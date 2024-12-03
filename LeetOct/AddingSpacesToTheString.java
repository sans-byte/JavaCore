package LeetOct;

public class AddingSpacesToTheString {
    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int spaces[] = { 8, 13, 15 };
        System.out.println(addSpaces(s, spaces));
    }

    private static String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx < spaces.length && i == spaces[idx]) {
                res.append(" ");
                idx++;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
