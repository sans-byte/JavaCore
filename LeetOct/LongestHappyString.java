package LeetOct;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 7;
        System.out.println(longestDiverseString(a, b, c));
    }

    public static String longestDiverseString(int a, int b, int c) {
        // PriorityQueue<int[]> p = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        // if (a > 0)
        //     p.add(new int[] { a, 'a' });
        // if (b > 0)
        //     p.add(new int[] { b, 'b' });
        // if (c > 0)
        //     p.add(new int[] { c, 'c' });

        // String s = "";
        // while (p.size() > 0) {
        //     int temp[] = p.poll();
        //     if (s.length() >= 2 && s.charAt(s.length() - 1) == (char) temp[1]
        //             && s.charAt(s.length() - 2) == (char) temp[1]) {
        //         if (p.isEmpty())
        //             break;
        //         int temp2[] = p.poll();
        //         s += (char) temp2[1];
        //         temp2[0]--;
        //         if (temp2[0] > 0) {
        //             p.add(temp2);
        //         }
        //         p.add(temp);
        //     } else {
        //         s += (char) temp[1];
        //         temp[0]--;
        //         if (temp[0] > 0) {
        //             p.add(temp);
        //         }
        //     }
        // }
        // return s;
        int maxLen = a + b + c;
        int charA = 0;int charB = 0;int charC = 0;
        StringBuilder s = new StringBuilder();
        int i=0;
        while(i < maxLen){
            if(charA != 2 && a >= b && a >= c || a>0 && (charB == 2 || charC ==2)){
                s.append('a');
                charA++;
                charB=0;
                charC=0;
                a--;
            }
            else if(charB != 2 && b >= a && b >= c || b>0 && (charA == 2 || charC ==2)){
                s.append('b');
                charB++;
                charA=0;
                charC=0;
                b--;
            }
            else if(charC != 2 && c >= b && c >= a || c > 0 && (charA == 2 || charB ==2)){
                s.append('c');
                charC++;
                charA=0;
                charB=0;
                c--;
            }
            i++;
        }
        return s.toString();
    }
}
