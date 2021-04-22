package cn.celess.easy.T414;
/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

import cn.celess.utils.Assert;

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long xxl, xl, l;
        xxl = xl = l = Long.MIN_VALUE;
        for (int val : nums) {

            if (val > xxl) {
                xxl = val;
            }
        }
        for (int val : nums) {
            if ((val > xl && val < xxl)) {
                xl = val;
            }
        }
        for (int val : nums) {
            if (val < xl && val > l) {
                l = val;
            }
        }
        // System.out.printf("xxl:%d xl:%d l:%d", xxl, xl, l);
        return l != Long.MIN_VALUE ? (int) l : (int) xxl;
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        Assert as = Assert.getInstance();
        Solution solution = new Solution();
        as.setPrintTip(new String[]{"数组:"});

        as.print(3, 2, 1).expect(() -> solution.thirdMax(new int[]{3, 2, 1})).actual(1);
        as.print(1, 2).expect(() -> solution.thirdMax(new int[]{1, 2})).actual(2);
        as.print(2, 2, 3, 1).expect(() -> solution.thirdMax(new int[]{2, 2, 3, 1})).actual(1);
        as.print(1, 2, -2147483648).expect(() -> solution.thirdMax(new int[]{1, 2, -2147483648}))
                .actual(-2147483648);
        as.print(3, 2, -1).actual(1).expect(() -> solution.thirdMax(new int[]{3, 2, 1}));
        as.printRecordInfo();
    }
}
