package cn.celess.easy;

import cn.celess.utils.*;

/**
 * @author : 禾几海
 * @date : 2021年04月20 00:23
 * @difficulty : easy
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr">28.实现 strStr()</a>
 */
public class ImplementStrstr {

    //@lc:start
    class Solution {
        // TODO: 优化

        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0;
            int index = 0;
            for (int i = 0; i < haystack.length(); i++) {
                if (index != 0 && haystack.charAt(i) != needle.charAt(index)) {
                    i -= (index - 1);
                    index = 0;
                }
                if (haystack.charAt(i) == needle.charAt(index)) {
                    index++;
                }
                if (index == needle.length())
                    return i - index + 1;
            }
            return -1;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        Assert assertion = Assert.getInstance();

        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("", ""));
        System.out.println(solution.strStr("hello", "llo"));
        System.out.println(solution.strStr("hello", "lla"));
        System.out.println(solution.strStr("", "a"));
        System.out.println(solution.strStr("mississippi", "issip"));
    }
}
