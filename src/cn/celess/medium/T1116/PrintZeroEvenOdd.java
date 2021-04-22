package cn.celess.medium.T1116;

import cn.celess.utils.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

    //@lc:start
    class ZeroEvenOdd {
        private int n;
        private int state = -1;
        private int current = 1;
        private Lock lock = new ReentrantLock();

        private Condition zeroCondition = lock.newCondition();
        private Condition condition = lock.newCondition();


        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (current < n) {
                lock.lock();
                try {
                    while (state != -1) {
                        zeroCondition.await();
                    }
                    printNumber.accept(0);
                    state = current % 2;
                    condition.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (current < n) {
                lock.lock();
                try {
                    while (state != 0) {
                        condition.await();
                    }
                    printNumber.accept(current);
                    current++;
                    state = -1;
                    zeroCondition.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (current < n) {
                lock.lock();
                try {
                    while (state != 1) {
                        condition.await();
                    }
                    printNumber.accept(current);
                    current++;
                    state = -1;
                    zeroCondition.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    //@lc:end


    public static void main(String[] args) {
        int s = 5;
        ZeroEvenOdd solution = new PrintZeroEvenOdd().new ZeroEvenOdd(s);
        Assert assertion = Assert.getInstance();
        IntConsumer printInt = System.out::print;
        new Thread(() -> {
            try {
                solution.zero(printInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                solution.even(printInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                solution.odd(printInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}
