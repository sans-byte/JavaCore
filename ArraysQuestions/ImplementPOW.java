package ArraysQuestions;

// https://leetcode.com/problems/powx-n/

public class ImplementPOW {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        // Output: 1024.00000

        System.out.println(myPow(x, n));
    }

    static double myPow(double x, int n) {
        double res = 1;

        // Here we need to see if n is negative and if it is negative then we need to
        // convert it to positive and then
        // send response as 1/res;
        // When converting int negative to positive we need to keep it mind that
        // negative range is slight larger than
        // the positive so we have to take long
        long nn = n;
        if (nn < 0) {
            nn = -1 * nn;
        }

        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn = nn / 2;
            } else {
                res = x * res;
                nn = nn - 1;
            }
        }

        if (n < 0)
            return (double) 1 / (double) res;
        return res;
    }
}

// its time complexity will be O(logn) coz n is getting divided by 2;
