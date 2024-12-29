package Hard;

import java.util.*;
// DP question

public class NumberofWaystoFormaTargetStringGivenaDictionary {
    public static void main(String[] args) {
        String words[] = { "acca", "bbbb", "caca" }, target = "aba";
        System.out.println(numWays(words, target));
    }

    public static void createPowerSet(String words[], List<List<String>> powerSet, List<String> temp, int index) {

        powerSet.add(new ArrayList<>(temp));

        // temp.add(words[index]);
        // createPowerSet(words, powerSet, temp, index + 1);
        // temp.remove(words[index]);
        // createPowerSet(words, powerSet, temp, index + 1);
        for (int i = index; i < words.length; i++) {
            temp.add(words[i]);
            createPowerSet(words, powerSet, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
        return;
    }

    public static int numWays(String[] words, String target) {
        List<List<String>> powerSet = new ArrayList<>();
        createPowerSet(words, powerSet, new ArrayList<>(), 0);
        for (int i = 0; i < powerSet.size(); i++) {
            for (int j = 0; j < powerSet.get(i).size(); j++) {
                int x = 0;
                int targetIndex = 0;
                for (int k = x; k < powerSet.get(i).get(j).length(); k++) {
                    char val = powerSet.get(i).get(j).charAt(k);
                    if (val == target.charAt(targetIndex)) {

                    }
                }
            }
        }
        return 0;
    }
}
