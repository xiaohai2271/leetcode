package cn.celess.medium;

import cn.celess.utils.*;

public class SearchInRotatedSortedArrayIi {

    //@lc:start
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums.length == 1) return target == nums[0];
            int index = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    index = i;
                    break;
                }
            }

            int beginIndex = 0, endIndex = nums.length - 1;

            if (index != -1) {
                if (target > nums[index] || target < nums[index + 1] || (target > nums[endIndex] && target < nums[0])) {
                    return false;
                }
                if (target == nums[index] || target == nums[beginIndex] || target == nums[endIndex]) {
                    return true;
                }
                if (target < nums[endIndex]) {
                    beginIndex = index + 1;
                }
                if (target > nums[0]) {
                    endIndex = index;
                }
            }
            //            System.out.printf("b: %d, e: %d ", beginIndex, endIndex);
            // 二分
            int middle;
            while (beginIndex <= endIndex) {
                middle = beginIndex + (endIndex - beginIndex) / 2;
                if (target == nums[middle]) return true;
                if (target > nums[middle]) beginIndex = middle + 1;
                if (target < nums[middle]) endIndex = middle - 1;
            }
            return false;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        Assert assertion = Assert.getInstance();

        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println(solution.search(new int[]{1, 3}, 1));
        System.out.println(solution.search(new int[]{1, 3}, 3));
        System.out.println(solution.search(new int[]{3, 1}, 1));
        System.out.println(solution.search(new int[]{3, 1}, 3));
        System.out.println(solution.search(new int[]{1, 2, 1}, 1));
    }
}
