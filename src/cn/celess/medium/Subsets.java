package cn.celess.medium;

import cn.celess.utils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 禾几海
 * @date : 2021年04月21 05:33
 * @difficulty : medium
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/subsets">78.子集</a>
 */
public class Subsets {

    //@lc:start
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backTrack(result, new ArrayList<>(), nums, 0);
            return result;
        }

        //        @Deprecated
        //        private void backTrace(List<List<Integer>> result, List<Integer> item, int[] nums, boolean[] visited) {
        //            if (!result.stream().filter(l -> l.size() == item.size()).anyMatch(integers -> integers.containsAll(item)))
        //                result.add(List.copyOf(item));
        //            for (int i = 0; i < nums.length; i++) {
        //                if (visited[i]) continue;
        //                item.add(nums[i]);
        //                visited[i] = true;
        //                backTrace(result, item, nums, visited);
        //                item.remove((Object) nums[i]);
        //                visited[i] = false;
        //            }
        //        }

        private void backTrack(List<List<Integer>> result, List<Integer> item, int[] nums, int index) {
            result.add(List.copyOf(item));
            for (int i = index; i < nums.length; i++) {
                item.add(nums[i]);
                backTrack(result, item, nums, i + 1);
                item.remove(item.size() - 1);
            }
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
        //        System.out.println(solution.subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 0}));
    }
}
