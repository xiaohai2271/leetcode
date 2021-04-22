package cn.celess.medium;

import cn.celess.utils.*;

import java.util.Arrays;

public class HouseRobberIi {

    //@lc:start
    class Solution {
        /***
         * 动态规划
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            } else if (len == 2) {
                return Math.max(nums[0], nums[1]);
            } else {
                return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
            }
        }

        public int robRange(int[] nums, int start, int end) {
            int len = end - start + 1;
            if (len == 1) return nums[start];
            if (len == 2) return Math.max(nums[start], nums[start + 1]);
            int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
            int tmp;
            for (int i = start + 2; i <= end; i++) {
                tmp = second;
                second = Math.max(first + nums[i], second);
                first = tmp;
            }
            return second;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.expect(3).actual(solution.rob(new int[]{2, 3, 2}));
        assertion.expect(4).actual(solution.rob(new int[]{1, 2, 3, 1}));
        assertion.expect(0).actual(solution.rob(new int[]{0}));
        assertion.expect(3).actual(solution.rob(new int[]{1, 2, 1, 1}));
    }
}
