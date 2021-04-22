package cn.celess.medium;

import cn.celess.utils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 禾几海
 * @date : 2021年04月23日 12:05
 * @difficulty : medium
 * @info submissions: 338490       accepted: 244750      acceptance: 72.31%
 * @desc : 练习回溯算法
 * @see <a href="https://leetcode-cn.com/problems/combination-sum">39.组合总和</a>
 */
public class CombinationSum {

    //@lc:start
    class Solution {
        // todo: 优化
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<>();
            backTrack(candidates, list, target, new ArrayList<>(), 0);
            return list;
        }

        private void backTrack(int[] candidates, List<List<Integer>> list, int target, List<Integer> item, int index) {
            if (target < 0) return;
            //            if (item.size() > 0 && sum == target && list.stream().filter(l -> l.size() == item.size()).noneMatch(integers -> integers.containsAll(item))) {
            if (0 == target) {
                list.add(List.copyOf(item));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                item.add(candidates[i]);
                backTrack(candidates, list, target - candidates[i], item, i);
                item.remove(item.size() - 1);
            }
        }

    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.expect(List.of(List.of(2, 2, 3), List.of(7))).actual(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        assertion.expect(List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))).actual(solution.combinationSum(new int[]{2, 3, 5}, 8));
        assertion.printRecordInfo();
    }
}
