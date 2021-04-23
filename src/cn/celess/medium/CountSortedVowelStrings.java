package cn.celess.medium;

import cn.celess.utils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 禾几海
 * @date : 2021年04月23日 04:48
 * @difficulty : medium
 * @info submissions: 13177       accepted: 10133      acceptance: 76.90%
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/count-sorted-vowel-strings">1641.统计字典序元音字符串的数目</a>
 */
public class CountSortedVowelStrings {

    //@lc:start
    class Solution {
        /**
         * before
         */
        //        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        //        List<List<Character>> res = new ArrayList<>();
        //
        //        public int countVowelStrings(int n) {
        //            backTrack(n, 0, new ArrayList<>());
        //            return res.size();
        //        }
        //
        //        private void backTrack(int n, int current, List<Character> record) {
        //            if (record.size() == n) {
        //                res.add(List.copyOf(record));
        //                return;
        //            }
        //            for (int i = current; i < 5; i++) {
        //                record.add(chars[i]);
        //                backTrack(n, i, record);
        //                record.remove(record.size() - 1);
        //            }
        //        }

        /**
         * 对空间进行优化 后
         */
        public int countVowelStrings(int n) {
            return backTrack(n, 0, 0);
        }

        private int backTrack(int n, int current, int size) {
            if (size == n) {
                return 1;
            }
            int result = 0;
            for (int i = current; i < 5; i++) result += backTrack(n, i, size + 1);
            return result;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new CountSortedVowelStrings().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.expect(5).actual(solution.countVowelStrings(1));
        assertion.expect(15).actual(solution.countVowelStrings(2));
        assertion.expect(66045).actual(solution.countVowelStrings(33));
    }
}
