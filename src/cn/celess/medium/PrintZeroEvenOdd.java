package cn.celess.medium;

import cn.celess.utils.*;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author : 禾几海
 * @date : 2021年06月03日 06:59
 * @difficulty : medium
 * @info submissions: 37365       accepted: 18973      acceptance: 50.78%
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/print-zero-even-odd">1116.打印零与奇偶数</a>
 */
public class PrintZeroEvenOdd {

    //@lc:start
    class ZeroEvenOdd {
        private int n;
        private Semaphore zeroSemaphore = new Semaphore(1);
        private Semaphore evenSemaphore = new Semaphore(0);
        private Semaphore oddSemaphore = new Semaphore(0);
        private volatile int current = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (current < n) {
                zeroSemaphore.acquire();
                printNumber.accept(0);
                //current++;
                if (current % 2 == 0) evenSemaphore.release();
                if (current % 2 == 1) oddSemaphore.release();
            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (current < n) {
                evenSemaphore.acquire();
                printNumber.accept(current);
                current++;
                zeroSemaphore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (current < n) {
                oddSemaphore.acquire();
                printNumber.accept(current);
                current++;
                zeroSemaphore.release();
            }
        }

    }
    //@lc:end


    public static void main(String[] args) {
        ZeroEvenOdd solution = new PrintZeroEvenOdd().new ZeroEvenOdd(5);
        IntConsumer printNumber = System.out::print;
        new Thread(() -> {
            try {
                solution.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                solution.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                solution.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}
