package cn.celess.medium.T456;
/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132模式
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        int minIndex = 0;
        // 找最小

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        // 2 4 3 5 6 7 8 1
        if (minIndex > nums.length - 3) {
            minIndex = 0;
            for (int i = 0; i < minIndex; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
        }

        for (int i = minIndex + 2; i < nums.length; i++) {
            
        }

        // for (int i = 1; i < nums.length - 1; i++) {
        // if (nums[i] > nums[maxIndex]) {
        // maxIndex = i;
        // }
        // }
        // // 处理最大值在最左侧和最右侧的清空
        // if (maxIndex == 0 || maxIndex == nums.length - 1) {

        // }
        // // 最大值左侧找最小

        // // 在最大值右侧找符合的值
        // for (int i = maxIndex; i < nums.length; i++) {
        // if (nums[i] > nums[minIndex] && nums[i] < nums[maxIndex]) {
        // return true;
        // }
        // }
        return false;
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        assert s.find132pattern(new int[] { 1, 3, 2, 4, 5, 6, 7, 8, 9, 10 });
    }
}
