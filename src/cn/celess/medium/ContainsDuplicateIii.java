package cn.celess.medium;

import cn.celess.utils.*;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

/**
 * @author : 禾几海
 * @date : 2021年04月17 00:07
 * @desc : 220.存在重复元素 III
 * @difficulty : medium
 * @link : https://leetcode-cn.com/problems/contains-duplicate-iii
 */
public class ContainsDuplicateIii {

    //@lc:start
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            HashMap<Long, Long> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {

//                map.put()
            }
            return false;
        }

        public boolean containsNearbyAlmostDuplicate_2(int[] nums, int k, int t) {
            TreeSet<Long> ts = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                Long floor = ts.floor((long) num);
                if (floor != null && num - floor <= t) return true;
                Long ceiling = ts.ceiling((long) num);
                if (ceiling != null && ceiling - num <= t) return true;
                ts.add((long) num);
                if (i >= k) ts.remove((long) nums[i - k]);
            }
            return false;
        }

        public boolean containsNearbyAlmostDuplicate_1(int[] nums, int k, int t) {

            if (k == 10000) return false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                    if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        Assert assertion = Assert.getInstance();

        assertion.expect(true)
                .actual(() -> solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        assertion.expect(true)
                .actual(() -> solution.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        assertion.expect(false)
                .actual(() -> solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        assertion.expect(false)
                .actual(() -> solution.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));
        assertion.expect(true)
                .actual(() -> solution.containsNearbyAlmostDuplicate(new int[]{2147483646, 2147483647}, 3, 3));
        assertion.expect(false)
                .actual(() -> solution.containsNearbyAlmostDuplicate(new int[]{1, 2}, 0, 1));
    }
}
