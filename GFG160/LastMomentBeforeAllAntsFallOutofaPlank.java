package GFG160;

public class LastMomentBeforeAllAntsFallOutofaPlank {
    public static void main(String[] args) {
        int n = 4, left[] = { 2, 4 }, right[] = { 0, 1, 3 };
        System.out.println(getLastMoment(n, left, right));
    }

    public static int getLastMoment(int n, int left[], int right[]) {
        int i = right.length - 1;
        int j = left.length - 1;

        while (i >= 0 && j >= 0) {
            if (right[i] < left[j]) {
                int temp = right[i];
                right[i] = left[j];
                left[j] = temp;

            }
        }
        return 0;
    }
}
