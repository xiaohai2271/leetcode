package cn.celess.medium;

import cn.celess.utils.*;

import java.util.Arrays;

/**
 * @author : 禾几海
 * @date : 2021年04月16 18:48
 * @desc : 31.下一个排列
 * @difficulty : medium
 * @link : https://leetcode-cn.com/problems/next-permutation
 */
public class NextPermutation {

    //@lc:start
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            for (int i = len - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    int index = i;
                    flip(nums, i + 1, len - 1);
                    for (int j = i + 1; j < len; j++) {
                        if (nums[j] > nums[i]) {
                            index = j;
                            break;
                        }
                    }
                    int tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    return;
                }
            }
            // 处理降序序列
            flip(nums, 0, len - 1);
        }

        private void flip(int[] nums, int start, int end) {
            int tmp;
            for (; start < end; start++, end--) {
                tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        Assert assertion = Assert.getInstance();
        int[] ints = new int[]{1, 2, 1, 3, 1};
        System.out.println(Arrays.toString(ints));
        solution.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));


        System.out.println();
        ints = new int[]{3, 2, 1};
        System.out.println(Arrays.toString(ints));
        solution.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));


        System.out.println();
        ints = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(ints));
        solution.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println();
        ints = new int[]{1, 1, 5};
        System.out.println(Arrays.toString(ints));
        solution.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println();
        ints = new int[]{1};
        System.out.println(Arrays.toString(ints));
        solution.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));


        System.out.println();
        ints = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        System.out.println(Arrays.toString(ints));
        solution.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println();
        ints = new int[]{1, 5, 8, 4, 7, 6, 6, 4, 1};
        System.out.println(Arrays.toString(ints));
        solution.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
