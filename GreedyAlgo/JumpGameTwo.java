package GreedyAlgo;
// https://leetcode.com/problems/jump-game-ii/
public class JumpGameTwo {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    static int jump(int[] nums) {
        int maxJump = 0;
        int count = 0;
        int maxInRange = 0;
        for(int i=0;i<nums.length;i++){
            if(maxJump >= nums.length-1) return count;
            maxInRange = Math.max(nums[i]+i,maxInRange);
            if(i >= maxJump){
                maxJump = Math.max(maxJump,maxInRange);
                count++;
            }
        }
        return count;
    }
}
