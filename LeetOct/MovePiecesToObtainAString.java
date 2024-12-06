package LeetOct;

//TODO: Revisit this question

public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        String start = "_L__R__R_", target = "L______RR";
        // String start = "R_L_", target = "__LR";
        System.out.println(((char) (49)));
        System.out.println(canChange(start, target));
    }

    public static boolean canChange(String start, String target) {
        int waitR = 0;
        int waitL = 0;
        for (int i = 0; i < start.length(); i++) {
            char curr = start.charAt(i);
            char goal = target.charAt(i);

            if (curr == 'R') {
                if (waitL > 0) {
                    return false;
                }
                waitR++;
            }

            if (goal == 'R') {
                if (waitR == 0) {
                    return false;
                }
                waitR--;
            }

            if (goal == 'L') {
                if (waitR > 0) {
                    return false;
                }
                waitL++;
            }

            if (curr == 'L') {
                if (waitL == 0) {
                    return false;
                }
                waitL--;
            }
        }

        return waitL == waitR && waitL == 0;
    }
}
