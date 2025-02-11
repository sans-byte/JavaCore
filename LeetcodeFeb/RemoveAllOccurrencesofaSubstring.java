package LeetcodeFeb;

public class RemoveAllOccurrencesofaSubstring {
    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder(s);
        while (true) {
            int index = res.indexOf(part);
            if (index == -1)
                return res.toString();
            res.delete(index, index + part.length());
        }
    }
}
