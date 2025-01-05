package LeetcodeJan;

public class ShiftingLettersII {
    public static void main(String[] args) {
        String s = "abc";
        int shifts[][] = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int diff[] = new int[s.length() + 1];

        for (int i = 0; i < shifts.length; i++) {
            if (shifts[i][2] == 1) {
                diff[shifts[i][0]]++;
                diff[shifts[i][1] + 1]--;
            } else {
                diff[shifts[i][0]]--;
                diff[shifts[i][1] + 1]++;
            }
        }
        StringBuilder res = new StringBuilder(s);
        int shiftsum = 0;
        for (int i = 0; i < s.length(); i++) {
            shiftsum = (shiftsum + diff[i]) % 26; // taking the prefix sum
            if (shiftsum < 0)
                shiftsum += 26;
            char val = (char) ('a' + (s.charAt(i) - 'a' + shiftsum) % 26);
            res.setCharAt(i, val);
        }
        return res.toString();
    }
}
