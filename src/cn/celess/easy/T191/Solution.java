package cn.celess.easy.T191;
/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */


// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(-1));
        System.out.println(s.hammingWeight(3));

    }
}
