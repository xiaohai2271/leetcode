package cn.celess.easy;

import cn.celess.utils.*;

import java.util.Arrays;

/**
 * @author : 禾几海
 * @date : 2021年04月18 22:20
 * @difficulty : easy
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array">26.删除有序数组中的重复项</a>
 */
public class RemoveDuplicatesFromSortedArray {

    //@lc:start
    class Solution {
        public int removeDuplicates(int[] nums) {
            int length = nums.length;
            if (length <= 1) return length;
            int len = 0, preVal = nums[0];
            for (int num : nums) {
                if (num != nums[len] && num != preVal) {
                    nums[++len] = num;
                    preVal = num;
                }
            }
            return len + 1;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        Assert assertion = Assert.getInstance();
        int[] ints = {1, 1, 2};
        assertion.expect(2).actual(solution.removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
        ints = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertion.expect(5).actual(solution.removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
        ints = new int[]{1, 2};
        assertion.expect(2).actual(solution.removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));

    }
}
