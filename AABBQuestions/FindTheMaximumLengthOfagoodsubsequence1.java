package AABBQuestions;

import java.util.ArrayList;

public class FindTheMaximumLengthOfagoodsubsequence1 {
    public static int res;

    public static void main(String[] args) {
        // int nums[] = { 1, 2, 1, 1, 3 }, k = 2;
        int nums[] = { 1, 2, 3, 4, 5, 1 }, k = 0;
        System.out.println(maximumLength(nums, k));
    }

    public static void helper(int[] arr, int index, int k, ArrayList<Integer> temp, int count) {

        if(count > k){
            return;
        }

        if(arr.length - index < res) return;

        if (index >= arr.length) {
            if (count <= k) {
                res = Math.max(res, temp.size());
                System.out.println(temp);
            }
            return;
        }
        temp.add(arr[index]);
        if (temp.size() > 1) {
            if (temp.get(temp.size() - 1) != temp.get(temp.size() - 2)) {
                helper(arr, index + 1, k, temp, count + 1);
            } else {
                helper(arr, index + 1, k, temp, count);
            }
        } else {
            helper(arr, index + 1, k, temp, count);
        }
        int ele = temp.get(temp.size() - 1);
        temp.remove(temp.size() - 1);
        if (temp.size() >= 1) {
            if (temp.get(temp.size() - 1) != ele) {
                helper(arr, index + 1, k, temp, count--);
            } else {
                helper(arr, index + 1, k, temp, count);
            }
        } else {
            helper(arr, index + 1, k, temp, count);
        }
    }

    public static int maximumLength(int[] nums, int k) {
        helper(nums, 0, k, new ArrayList<>(), 0);
        System.out.println(res);
        return 0;
    }
}
