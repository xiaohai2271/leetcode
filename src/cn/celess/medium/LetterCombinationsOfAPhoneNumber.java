package cn.celess.medium;

import cn.celess.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author : 禾几海
 * @date : 2021年04月19 19:10
 * @difficulty : medium
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number">17.电话号码的字母组合</a>
 */
public class LetterCombinationsOfAPhoneNumber {

    //@lc:start
    class Solution {
        final Map<Character, String> map = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );

        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>();
            if (digits.length() == 0) return list;
            StringBuilder stringBuilder = new StringBuilder();
            backTrace(list, 0, digits, stringBuilder);
            return list;
        }

        public void backTrace(List<String> list, int index, String digits, StringBuilder stringBuilder) {
            if (digits.length() == index) {
                list.add(stringBuilder.toString());
                return;
            }
            String s = map.get(digits.charAt(index));
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                backTrace(list, index + 1, digits, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.letterCombinations("23"));
    }
}
