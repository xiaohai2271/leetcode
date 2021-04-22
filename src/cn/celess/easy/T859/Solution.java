package cn.celess.easy.T859;

import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length())
            return false;

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff.add(i);
            }
        }
        if (diff.size() == 0) {
            int[] count = new int[26];
            for (char c : a.toCharArray()) {
                count[c - 'a']++;
            }

            for (Integer e : count) {
                if (e >= 2) {
                    return true;
                }
            }
            return false;

        }
        return !(diff.size() != 2
                || (a.charAt(diff.get(0)) != b.charAt(diff.get(1)) || a.charAt(diff.get(1)) != b.charAt(diff.get(0))));

    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buddyStrings("aa", "aa"));
    }
}
