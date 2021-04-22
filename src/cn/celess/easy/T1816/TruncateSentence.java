package cn.celess.easy.T1816;

import cn.celess.utils.*;

public class TruncateSentence {

    //@lc:start
    class Solution {
        public String truncateSentence(String s, int k) {

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (s.charAt(i) == ' ') {
                    if (--k == 0) {
                        return new String(chars, 0, i);
                    }
                }
            }
            return s;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new TruncateSentence().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.truncateSentence("Hello how are you Contestant", 4));
    }
}
