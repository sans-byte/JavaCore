package Recursion;

public class Pow {
    public static void main(String[] args) {
        int n = -2147483648;
        int x = 2;

        System.out.println(pow(n, x));

        int factor = 1;
        int nn = Math.abs(n);
        double res = powWithRec(x, nn, factor);
        if (n < 0) {
            System.out.println((double) 1 / res);
        } else {
            System.out.println(res);
        }
    }

    static double pow(int n, int x) {
        int res = 1;
        int nn = Math.abs(n);

        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn /= 2;
            } else {
                res = res * x;
                nn -= 1;
            }
        }
        if (n < 0) {
            return (double) 1 / res;
        }
        return res;
    }

    static double powWithRec(int x, int n, double res) {
        if (n <= 0)
            return res;
        if (n % 2 == 0) {
            return powWithRec(x * x, n / 2, res);
        }
        return powWithRec(x, n - 1, res * x);
    }
}