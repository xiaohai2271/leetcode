package cn.celess.medium;

import cn.celess.utils.*;

public class HouseRobber {

    //@lc:start
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            if (len == 2) {
                return Math.max(nums[0], nums[1]);
            }
            // 当前的前一个  当前的前两个
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            int tmp;
            for (int i = 2; i < len; i++) {
                tmp = second;
                second = Math.max(first + nums[i], second);
                first = tmp;
            }

            return second;
        }

        public int rob_1(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            if (len == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[len - 1];
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }
}
