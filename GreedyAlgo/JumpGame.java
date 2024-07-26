package GreedyAlgo;
// https://leetcode.com/problems/jump-game/description/
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxjump = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i > maxjump) return false;
            maxjump = Math.max(maxjump,nums[i]+i); 
        }
        return true;
    }
}
