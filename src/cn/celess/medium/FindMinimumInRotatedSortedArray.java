package cn.celess.medium;

import cn.celess.utils.*;

public class FindMinimumInRotatedSortedArray {

    //@lc:start
    class Solution {
        public int findMin(int[] nums) {
            if (nums.length == 1) return nums[0];
            int index = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    index = i;
                    break;
                }
            }

            return index == -1 ? nums[0] : nums[index + 1];
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.expect(1).actual(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        assertion.expect(0).actual(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertion.expect(11).actual(solution.findMin(new int[]{11, 13, 15, 17}));
        assertion.expect(1).actual(solution.findMin(new int[]{3, 1}));
        assertion.expect(1).actual(solution.findMin(new int[]{1, 3}));
        assertion.expect(1).actual(solution.findMin(new int[]{1}));
    }
}
