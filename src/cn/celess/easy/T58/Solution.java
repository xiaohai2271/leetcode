package cn.celess.easy.T58;
/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

import cn.celess.utils.Assert;

// @lc code=start
class Solution {
    public int lengthOfLastWord_1(String s) {
        String[] strArr = s.split(" ");
        if (strArr.length == 0) {
            return 0;
        }
        return strArr[strArr.length - 1].length();
    }

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int len = -1;
        while (end >= 0) {
            if (s.charAt(end) == ' ' && len == -1){
                end--;
                continue;
            }
            if (s.charAt(end) == ' ' && len != -1){
                return len+1;
            }
            len++;
            end--;
        }
        return len+1;
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert as = Assert.getInstance();
        as.setPrintTip(new String[] { "words: " });
        as.print("\"Hello World\"").assertEqual(5, s.lengthOfLastWord("Hello World"));
        as.print("\" \"").assertEqual(0, s.lengthOfLastWord(" "));
        as.print("\"a \"").assertEqual(1, s.lengthOfLastWord("a "));
        as.print("\"a    \"").assertEqual(1, s.lengthOfLastWord("a    "));

        as.printRecordInfo();
    }
}
