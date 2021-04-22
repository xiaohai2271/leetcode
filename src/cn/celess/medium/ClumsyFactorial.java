package cn.celess.medium;

import cn.celess.utils.*;

import java.util.Stack;

public class ClumsyFactorial {

    //@lc:start
    class Solution {
        public int clumsy(int N) {
            if (N == 1) {
                return 1;
            } else if (N == 2) {
                return 2;
            } else if (N == 3) {
                return 6;
            } else if (N == 4) {
                return 7;
            }

            if (N % 4 == 0) {
                return N + 1;
            } else if (N % 4 <= 2) {
                return N + 2;
            } else {
                return N - 1;
            }
        }

        public int clumsy_1(int N) {
            int result = 0;
            int state = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(N--);
            while (N > 0) {
                if (state % 4 == 0) {
                    // *
                    stack.push(stack.pop() * N);
                } else if (state % 4 == 1) {
                    // ÷
                    stack.push(stack.pop() / N);
                } else if (state % 4 == 2) {
                    // +
                    stack.push(N);
                } else {
                    // -
                    stack.push(-N);
                }
                state++;
                N--;
            }
            //            System.out.println(stack.stream().mapToInt(Integer::intValue).sum());
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new ClumsyFactorial().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.expect(7).actual(solution.clumsy(4));
        assertion.expect(12).actual(solution.clumsy(10));
        assertion.expect(1).actual(solution.clumsy(1));
        assertion.expect(2).actual(solution.clumsy(2));
        assertion.expect(6).actual(solution.clumsy(3));
    }
}
