package cn.celess.medium.T179;

import cn.celess.utils.*;

import java.util.Arrays;

public class LargestNumber {

    //@lc:start
    public class Solution {
        public String largestNumber(int[] nums) {
            Integer[] numsI = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numsI[i] = nums[i];
            }

            Arrays.sort(numsI, (o1, o2) -> ("" + o2 + o1).compareTo("" + o1 + o2));

            StringBuilder stringBuilder = new StringBuilder();
            if (numsI[0] == 0) {
                return "0";
            }

            for (Integer num : numsI) {
                stringBuilder.append(num);
            }
            return stringBuilder.toString();
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        Assert assertion = Assert.getInstance();

        //        assertion.expect("210").actual(() -> solution.largestNumber(new int[]{10, 2}));
        //        assertion.expect("9534330").actual(() -> solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
        //        assertion.expect("1").actual(() -> solution.largestNumber(new int[]{1}));
        //        assertion.expect("10").actual(() -> solution.largestNumber(new int[]{10}));
        //        assertion.expect("1113111311").actual(() -> solution.largestNumber(new int[]{111311, 1113}));


        cn.celess.utils.v2.Assert as = new cn.celess.utils.v2.Assert();
        as.setSolutionClassInstance(solution);
        as.setMethod("largestNumber");
        as.args(new Object[]{new int[]{3, 30, 34, 5, 9}}).printArgs().expect("9534330").execute();
    }
}
