package cn.celess.hard;

import cn.celess.utils.*;

import java.util.*;

/**
 * @author : 禾几海
 * @date : 2021年04月16 16:48
 * @desc : 87.扰乱字符串
 * @difficulty : hard
 * @link : https://leetcode-cn.com/problems/scramble-string
 */
public class ScrambleString {

    //@lc:start
    class Solution {
        Map<String, Map<String, Boolean>> collection = new HashMap<>();

        public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2)) return true;
            if (hashCode(s1) != hashCode(s2)) return false;
            int len = s1.length();
            if (len <= 3) return true;
            if (collection.containsKey(s1) && collection.get(s1).get(s2) != null) return collection.get(s1).get(s2);
            for (int i = 1; i < len; i++) {
                boolean flag = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))
                        || isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i));
                Map<String, Boolean> hashMap = collection.getOrDefault(s1, new HashMap<>());
                hashMap.put(s2, flag);
                collection.put(s1, hashMap);
                if (flag) return true;
            }
            return false;
        }

        // 自定义hashcode
        private int hashCode(String s) {
            int hash = 0;
            for (char c : s.toCharArray()) {
                hash += 1 << c - 'a';
            }
            return hash;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new ScrambleString().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.isScramble("great", "rgeat"));
        System.out.println(solution.isScramble("abab", "bbaa"));
        System.out.println(solution.isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));

    }
}
