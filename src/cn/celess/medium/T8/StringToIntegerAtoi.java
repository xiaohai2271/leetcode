package cn.celess.medium.T8;

import cn.celess.utils.*;

public class StringToIntegerAtoi {

    //@lc:start
    class Solution {
        public int myAtoi(String s) {


            int len = s.length();
            char[] chars = s.toCharArray();
            int val = 0;
            int index = 0;
            boolean isPositiveNumber = true;

            if (len > 0) {
                for (int i = 0; i < len; i++) {
                    if (chars[i] == ' ') {
                        index++;
                        continue;
                    }
                    break;
                }
                if (index == len) return 0;
                if (chars[index] == '-') {
                    isPositiveNumber = false;
                    index++;
                } else if (chars[index] == '+') {
                    index++;
                }


                for (int i = index; i < len; i++) {
                    if (chars[i] == '.') break;
                    if (chars[i] > '9' || chars[i] < '0') {
                        break;
                    }
                    int bitVal = chars[i] - '0';
                    if (isPositiveNumber && (Integer.MAX_VALUE - bitVal) / 10 < val) {
                        return Integer.MAX_VALUE;
                    }
                    if (!isPositiveNumber && (Integer.MIN_VALUE + bitVal) / 10 > -val) {
                        return Integer.MIN_VALUE;
                    }
                    val = val * 10 + bitVal;
                }
            }

            return isPositiveNumber ? val : -val;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        Assert assertion = Assert.getInstance();
        solution.myAtoi("-1");
        //2147483647
        //214748364

        //-2147483648
        //-214748364
        //        System.out.println(Integer.MAX_VALUE);
        //        System.out.println(Integer.MIN_VALUE);

        assertion.print(Integer.MAX_VALUE)
                .expect(Integer.MAX_VALUE)
                .actual(() -> solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
        assertion.print(Integer.MIN_VALUE)
                .expect(Integer.MIN_VALUE)
                .actual(() -> solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
        assertion.print("     10")
                .expect(10)
                .actual(() -> solution.myAtoi("     10"));
        assertion.print("     -10")
                .expect(-10)
                .actual(() -> solution.myAtoi("     -10"));
        assertion.print("-10 adasndkasdnmaosld")
                .expect(-10)
                .actual(() -> solution.myAtoi("-10 adasndkasdnmaosld"));
        assertion.print("words and 987")
                .expect(0)
                .actual(() -> solution.myAtoi("words and 987"));
        assertion.print("3.14159")
                .expect(3)
                .actual(() -> solution.myAtoi("3.14159"));

        assertion.print("-3.14159")
                .expect(-3)
                .actual(() -> solution.myAtoi("-3.14159"));
        assertion.print("+1")
                .expect(1)
                .actual(() -> solution.myAtoi("+1"));

        assertion.print(" ")
                .expect(0)
                .actual(() -> solution.myAtoi(" "));


    }
}
