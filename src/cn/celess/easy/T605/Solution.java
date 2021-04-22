package cn.celess.easy.T605;


import cn.celess.utils.Assert;

/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers_1(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 1) {
            return flowerbed[0] == 0;
        }

        int countOf0 = 0;
        Integer startIndex = null;

        for (int i = 0; i < flowerbed.length; i++) {
            if (n <= 0) { // 如果已经种够花了，可以提前返回true
                return true;
            }
            if (startIndex == null && flowerbed[i] == 0) {
                startIndex = i;
                countOf0 = 1;
            }

            if ((startIndex != null && flowerbed[i] == 1) || i == flowerbed.length - 1) {
                countOf0 = i - startIndex;
                if (flowerbed[i] == 0 && i == flowerbed.length - 1) {
                    countOf0++;
                }
                if (countOf0 != 1 && (startIndex == 0 || startIndex + countOf0 == flowerbed.length)) {
                    n--;
                }
                n -= Math.ceil((countOf0 - 2) / 2.0);
                startIndex = null;
            }

        }
        return n <= 0;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n <= 0)
                return true;

            if (flowerbed[i] == 1)
                continue;

            if (i > 0 && flowerbed[i - 1] == 1)
                continue;

            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1)
                continue;
            flowerbed[i] = 1;
            n--;
        }
        return n <= 0;
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert assertion = Assert.getInstance();
        // assertion.setStrict(true);
        assertion.setPrintTip(new String[] { "n:", "\tarrays:" });
        assertion.setAutoRecord(true);
        assertion.print(2).print(0, 0).assertEqual(s.canPlaceFlowers(new int[] { 0, 0 }, 2), false);
        assertion.print(1).print(1, 0, 0, 0, 1).assertEqual(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1), true);
        assertion.print(2).print(1, 0, 0, 0, 1).assertEqual(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2), false);
        assertion.print(1).print(1, 0, 1, 0, 1, 0, 1)
                .assertEqual(s.canPlaceFlowers(new int[] { 1, 0, 1, 0, 1, 0, 1 }, 1), false);
        assertion.print(1).print(0, 0, 1, 0, 1).assertEqual(s.canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1), true);
        assertion.print(1).print(1, 0, 1, 0, 0).assertEqual(s.canPlaceFlowers(new int[] { 1, 0, 1, 0, 0 }, 1), true);
        assertion.print(2).print(0, 0, 1, 0, 0).assertEqual(s.canPlaceFlowers(new int[] { 0, 0, 1, 0, 0 }, 2), true);
        assertion.print(2).print(0, 0, 1, 0).assertEqual(s.canPlaceFlowers(new int[] { 0, 0, 1, 0 }, 2), false);
        assertion.print(2).print(1, 0, 0, 0, 0).assertEqual(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 0 }, 2), true);
        assertion.printRecordInfo();
    }
}
