package cn.celess.lccup;

import cn.celess.utils.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : xiaohai
 * @date : 2021/04/10 14:52
 * @desc :
 */
public class T1 {

    class Solution {
        public int storeWater(int[] bucket, int[] vat) {
            int result = 0;

            int size = bucket.length;

            // 存储倒的次数
            int[] reckon = new int[size];
            for (int i = 0; i < size; i++) {
                reckon[i] = (int) Math.ceil(vat[i] / bucket[i]);
            }
            int maxIndex = 0;
            for (int i = 0; i < size; i++) {
                List<Integer> updateTime = new ArrayList<>();
                for (int j = 0; j < bucket.length; j++) {
                    if (reckon[j] > reckon[maxIndex]) {
                        maxIndex = j;
                    }
                }
//                updateTime.add();



            }
            //            int[] updateTime = new int[size];
            //            Arrays.fill(reckon, 0);


            return result;
        }
    }

    public static void main(String[] args) {
        Assert assertion = Assert.getInstance();
        Solution s = new T1().new Solution();

        assertion.setPrintTip(new String[]{});

        assertion.print().expect(4).actual(() -> s.storeWater(new int[]{1, 3}, new int[]{6, 8}));
        assertion.print().expect(3).actual(() -> s.storeWater(new int[]{9, 0, 1}, new int[]{0, 2, 2}));


    }
}
