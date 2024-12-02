package LeetOct;

import java.util.Arrays;

public class CheckIfAWordOccurAsAPrefixIfAnyWordInASentence {
    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
