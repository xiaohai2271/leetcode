package cn.celess.medium;

import cn.celess.utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : 禾几海
 * @date : 2021年04月20 11:57
 * @difficulty : medium
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/permutations">46.全排列</a>
 */
public class Permutations {

    //@lc:start
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            backTrace(list, nums, new ArrayList<>(), new boolean[nums.length]);
            return list;
        }

        public void backTrace(List<List<Integer>> list, int[] nums, List<Integer> item, boolean[] visited) {
            if (item.size() == nums.length) {
                list.add(List.copyOf(item));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                item.add(nums[i]);
                visited[i] = true;
                backTrace(list, nums, item, visited);
                item.remove(item.size() - 1);
                visited[i] = false;
            }
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.permute(new int[]{1}));
    }
}
