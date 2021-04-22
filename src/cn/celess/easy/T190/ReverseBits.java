package cn.celess.easy.T190;

import cn.celess.utils.*;

public class ReverseBits {

    //@lc:start
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res += (n & 1);
                n >>= 1;
            }
            return res;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
        Assert assertion = Assert.getInstance();
        //        输入: 00000010100101000001111010011100
        //        输入: 00000010100101000001111010011100

        //        输出: 00111001011110000010100101000000

        assertion.expect(964176192).actual(solution.reverseBits(Integer.parseInt("00000010100101000001111010011100", 2)));
    }
}
