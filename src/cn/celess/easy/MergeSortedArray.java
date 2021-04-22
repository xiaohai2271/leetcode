package cn.celess.easy;

import cn.celess.utils.*;

import java.util.Arrays;

public class MergeSortedArray {

    //@lc:start
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1, 0, m + n);
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        Assert assertion = Assert.getInstance();
        solution.merge(new int[]{1, 2, 3, 0, 0, 0, 0}, 3, new int[]{2, 6, 5}, 3);
        solution.merge(new int[]{}, 0, new int[]{}, 0);

    }
}
