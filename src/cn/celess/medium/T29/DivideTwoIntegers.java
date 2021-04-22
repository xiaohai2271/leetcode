package cn.celess.medium.T29;

import cn.celess.utils.*;

public class DivideTwoIntegers {

    //@lc:start
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) return 0;
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                if (dividend > Integer.MIN_VALUE) {
                    return -dividend;
                }
                return Integer.MAX_VALUE;
            }

            boolean isPositiveNumber = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
            int res = div(dividend > 0 ? dividend : -1L * dividend, divisor > 0 ? divisor : -1L * divisor);
            return isPositiveNumber ? res : -res;
        }


        public int div(long dividend, long divisor) {
            if (dividend < divisor) {
                return 0;
            }
            int res = 1;
            long divisor_tmp = divisor;
            while (dividend > divisor_tmp * 2) {
                divisor_tmp *= 2;
                res *= 2;
            }
            if (dividend == divisor_tmp) return res;

            res += div((dividend - divisor_tmp), divisor);

            return res;

        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.setPrintTip(new String[]{"", "/"});

        assertion.print(Integer.MIN_VALUE).print(2)
                .expect(Integer.MIN_VALUE / 2)
                .actual(() -> solution.divide(Integer.MIN_VALUE, 2));
        assertion.print(-2147483646).print(2)
                .expect(-2147483646 / 2)
                .actual(() -> solution.divide(-2147483646, 2));
        assertion.print(-12).print(4)
                .expect(-12 / 4)
                .actual(() -> solution.divide(-12, 4));

        assertion.setEnablePrint(false);
        assertion.setStrict(true);
        int m = 1;
        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i += m, m *= 2) {
            int finalI = (int) i;
            if (m > Integer.MAX_VALUE / 1000000) m = 1;
            assertion.print(finalI).print(1)
                    .expect(finalI)
                    .actual(() -> solution.divide(finalI, 1));

            assertion.print(finalI).print(2)
                    .expect(finalI / 2)
                    .actual(() -> solution.divide(finalI, 2));
            assertion.print(finalI).print(-2)
                    .expect(finalI / -2)
                    .actual(() -> solution.divide(finalI, -2));
            assertion.print(-finalI).print(2)
                    .expect(-finalI / 2)
                    .actual(() -> solution.divide(-finalI, 2));
            assertion.print(-finalI).print(-2)
                    .expect(-finalI / -2)
                    .actual(() -> solution.divide(-finalI, -2));
        }

        assertion.setEnablePrint(true);
        assertion.printRecordInfo();
    }
}
