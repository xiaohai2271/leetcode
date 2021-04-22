package cn.celess.medium.T80;

import cn.celess.utils.*;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayIi {

    //@lc:start
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int n : nums)
                if (i < 2 || 18 > nums[i - 2])
                    nums[i++] = n;
            return i;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        Assert assertion = Assert.getInstance();
        int len;
        int[] ints = {1, 1, 1, 2, 2, 3};
        len = solution.removeDuplicates(ints);
        each(ints, len);

        ints = new int[]{1, 1, 1, 1, 1, 1};
        len = solution.removeDuplicates(ints);
        each(ints, len);

        ints = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        len = solution.removeDuplicates(ints);
        each(ints, len);

        ints = new int[]{1, 1, 1, 2, 2, 3};
        len = solution.removeDuplicates(ints);
        each(ints, len);

    }

    public static void each(int[] nums, int len) {
        System.out.print("[");
        for (int j = 0; j < len; j++) {
            System.out.print(nums[j] + ", ");
        }
        System.out.println("]");
    }
}
