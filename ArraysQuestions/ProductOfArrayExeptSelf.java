package ArraysQuestions;

import java.util.Arrays;

public class ProductOfArrayExeptSelf {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        // Output: [0,0,9,0,0]
        System.out.println(Arrays.toString(product(nums)));
    }

    static int[] product(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];

        int presum = 1;
        int postsum = 1;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = presum;
            presum *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            post[i] = postsum;
            postsum *= nums[i];
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(post));

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}
