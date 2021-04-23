package cn.celess.medium;

import cn.celess.utils.*;

import java.util.Arrays;


/**
 * @author : 禾几海
 * @date : 2021年04月23日 05:51
 * @difficulty : medium
 * @info submissions: 537457       accepted: 225810      acceptance: 42.01%
 * @desc : 动态规划
 * @see <a href="https://leetcode-cn.com/problems/jump-game">55.跳跃游戏</a>
 */
public class JumpGame {

    //@lc:start
    class Solution {
        /**
         * 使用数组记录每个下标能到达的最远位置
         */
        public boolean canJump_1(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
                if (dp[i] == 0) return false;
            }
            return dp[dp.length - 1] >= nums.length - 1;
        }

        /**
         * 贪心
         * 使用变量存储当前能到达的最远的位置
         */
        public boolean canJump(int[] nums) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (max < i) return false;
                max = Math.max(nums[i] + i, max);
            }
            return true;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.expect(true).actual(solution.canJump(new int[]{2, 3, 1, 1, 4}));

        assertion.expect(false).actual(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        assertion.expect(true).actual(solution.canJump(new int[]{0}));
        assertion.expect(true).actual(solution.canJump(new int[]{1, 2}));
    }
}
