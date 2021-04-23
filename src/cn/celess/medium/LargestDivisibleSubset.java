package cn.celess.medium;

import cn.celess.utils.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : 禾几海
 * @date : 2021年04月23日 07:03
 * @difficulty : medium
 * @info submissions: 64787       accepted: 28320      acceptance: 43.71%
 * @desc : 每日一题
 * @see <a href="https://leetcode-cn.com/problems/largest-divisible-subset">368.最大整除子集</a>
 */
public class LargestDivisibleSubset {

    //@lc:start
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.sort(nums);
            dp[0] = 1;
            int maxDpIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                    if (dp[i] == 0) dp[i] = 1;
                }
                if (dp[maxDpIndex] < dp[i]) maxDpIndex = i;
            }
            List<Integer> list = new ArrayList<>(dp[maxDpIndex]);
            int num = nums[maxDpIndex];
            int maxSize = dp[maxDpIndex];
            for (int i = maxDpIndex; i >= 0; i--) {
                if (dp[i] == maxSize && num % nums[i] == 0) {
                    list.add(nums[i]);
                    num = nums[i];
                    maxSize--;
                }
            }
            return list;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new LargestDivisibleSubset().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.largestDivisibleSubset(new int[]{2, 4, 7, 8, 9, 12, 16, 20}));
        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(solution.largestDivisibleSubset(new int[]{4, 8, 10, 240}));
    }
}
