package Strings;

// We are going to use here the concept of power set

public class PrintAllSubstrings {
    public static void main(String[] args) {
        String str = "abc";
        printSubstrings(str);
    }

    static void printSubstrings(String str){
        // Here we know that for n length of string total number of substrings will be 2^n-1
        // so we can use bits here to see if we want to pick a letter or not if the value is set then that letter is to be picked
                // 0	0 0 0   ->  ""
                // 1	0 0 1   ->  "c"
                // 2	0 1 0   ->  "b"
   //0 -> n-1   // 3	0 1 1   ->  "bc"
                // 4	1 0 0   ->  "a"
                // 5	1 0 1   ->  "ac"
                // 6	1 1 0   ->  "ab"
                // 7	1 1 1   ->  "abc"
        // check if i th bit is set or not for example let's i = 2;
        // if k = 3 -> 0 1 1 then 
        // 1 <<(left shift) i => 1 0 0
        // k & ( 1<<i ) = 1 which means the ith bit is set if the answer was 0 then the ith bit is not set

        int val = (int) Math.pow(2, str.length()) - 1;
        for(int x = 0; x < val; x++){
            String s = new String();
            int i = 0;
            while(i < str.length()){
                if( (x & (1 << i)) != 0){
                    s += str.charAt(i);
                }
                i++;
            }
            System.out.println(s);
        }
   }
   // Time complexity -> 2^n * n
}
