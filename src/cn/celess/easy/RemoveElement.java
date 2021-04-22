package cn.celess.easy;

import cn.celess.utils.*;

/**
 * @author : 禾几海
 * @date : 2021年04月19 12:19
 * @difficulty : easy
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/remove-element">27.移除元素</a>
 */
public class RemoveElement {

    //@lc:start
    class Solution {
        public int removeElement(int[] nums, int val) {
            int len = 0;
            for (int num : nums) {
                if (num != val) nums[len++] = num;
            }
            return len;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        Assert assertion = Assert.getInstance();
        int len;
        int[] ints = {3, 2, 2, 3};
        len = solution.removeElement(ints, 3);
        assertion.expect(2).actual(len);
        each(ints, len);

        ints = new int[]{1, 1, 1, 1, 1, 1};
        len = solution.removeElement(ints, 1);
        assertion.expect(0).actual(len);
        each(ints, len);

        ints = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        len = solution.removeElement(ints, 2);
        assertion.expect(5).actual(len);
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
