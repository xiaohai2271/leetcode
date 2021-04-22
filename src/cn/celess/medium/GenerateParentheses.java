package cn.celess.medium;

import cn.celess.utils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : 禾几海
 * @date : 2021年04月20 11:19
 * @difficulty : medium
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses">22.括号生成</a>
 */
public class GenerateParentheses {

    //@lc:start
    class Solution {

        public List<String> generateParenthesis(int n) {
            if (n == 0) return Collections.emptyList();
            List<String> list = new ArrayList<>();
            backTrace(list, 0, 0, new StringBuilder(), n);
            return list;
        }

        public void backTrace(List<String> list, int open, int close, StringBuilder sb, final int n) {
            if (sb.length() == n * 2) {
                list.add(sb.toString());
                return;
            }

            if (open < n) {
                sb.append("(");
                backTrace(list, open + 1, close, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (open > close) {
                sb.append(")");
                backTrace(list, open, close + 1, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.generateParenthesis(3));
    }
}
