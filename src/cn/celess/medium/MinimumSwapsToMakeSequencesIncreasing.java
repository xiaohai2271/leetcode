package cn.celess.medium;

import cn.celess.utils.*;

import java.util.Arrays;

public class MinimumSwapsToMakeSequencesIncreasing {

    //@lc:start
    class Solution {
        public int minSwap(int[] A, int[] B) {
            int size = A.length;

            //1,3,10,4
            //1,2,3,12
            int count = 0;
            int tmp;
            boolean needSwap = false;
            for (int i = 0; i < size; i++) {
                if (needSwap) {
                    count++;
                    needSwap = false;
                    tmp = A[i];
                    A[i] = B[i];
                    B[i] = tmp;
                }
                if (i == size - 1) {
                    break;
                }
                if (A[i] >= A[i + 1] || B[i] >= B[i + 1]) {
                    if (A[i] < B[i + 1] && B[i] < A[i + 1]) {
                        count++;
                        tmp = A[i];
                        A[i] = B[i];
                        B[i] = tmp;
                    } else {
                        needSwap = true;
                    }
                }

            }

            return count;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new MinimumSwapsToMakeSequencesIncreasing().new Solution();
        Assert assertion = Assert.getInstance();
        int[] A = new int[]{3,3,8,9,10};
        int[] B = new int[]{1,7,4,6,8};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        System.out.println(solution.minSwap(A, B));

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

    }
}
