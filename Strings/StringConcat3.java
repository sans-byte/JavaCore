package Strings;

public class StringConcat3 {
    public static void main(String[] args) {
        String word = "aaaaaaaaay";
        System.out.println(compressedString(word));
    }

    public static String compressedString(String word) {
        if (word.length() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        int i = 0;
        int count = 0;
        char temp = word.charAt(0);
        while (i < word.length()) {
            if (count == 9) {
                res.append(count + "" + temp);
                count = 0;
            }
            if (word.charAt(i) != temp) {
                if (count > 0) {
                    res.append(count + "" + temp);
                }
                temp = word.charAt(i);
                count = 0;
            }
            count++;
            i++;
        }
        res.append(count + "" + temp);
        return res.toString();
    }
}
