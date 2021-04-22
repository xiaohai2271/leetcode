package cn.celess.easy.T434;

import cn.celess.utils.Assert;

/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        String[] strArr = s.split(" ");
        int len = strArr.length;
        for (String str : strArr) {
            if (str.length() == 0)
                len--;
        }
        return len;
    }
}
// @lc code=end

class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assert assertion = Assert.getInstance();
        assertion.expect(() -> solution.countSegments(",,,, my name is John")).actual(5);
        assertion.printRecordInfo();
    }
}
