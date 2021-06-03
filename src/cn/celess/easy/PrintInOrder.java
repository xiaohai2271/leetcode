package cn.celess.easy;

import cn.celess.utils.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 禾几海
 * @date : 2021年06月03日 07:16
 * @difficulty : easy
 * @info submissions: 102494       accepted: 66566      acceptance: 64.95%
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/print-in-order">1114.按序打印</a>
 */
public class PrintInOrder {

    //@lc:start
    // 信号量
    class Foo1 {
        private Semaphore firstSemaphore = new Semaphore(1);
        private Semaphore secondSemaphore = new Semaphore(0);
        private Semaphore thirdSemaphore = new Semaphore(0);

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            firstSemaphore.acquire();
            printFirst.run();
            secondSemaphore.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            secondSemaphore.acquire();
            printSecond.run();
            thirdSemaphore.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            thirdSemaphore.acquire();
            printThird.run();
        }
    }

    // 锁
    class Foo2 {
        private Lock lock = new ReentrantLock();
        private Condition firstCondition = lock.newCondition();
        private Condition secondCondition = lock.newCondition();
        private Condition thirdCondition = lock.newCondition();
        private volatile int state = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (state != 1)
                    firstCondition.await();
                printFirst.run();
                state++;
                secondCondition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (state != 2)
                    secondCondition.await();
                printSecond.run();
                state++;
                thirdCondition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (state != 3)
                    thirdCondition.await();
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }

    // 标识符 锁让步
    class Foo3 {
        private volatile int state = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            while (state != 1 && Thread.activeCount() > 2)
                Thread.yield();
            printFirst.run();
            state++;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (state != 2 && Thread.activeCount() > 2)
                Thread.yield();
            printSecond.run();
            state++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (state != 3 && Thread.activeCount() > 2)
                Thread.yield();
            printThird.run();
        }
    }

    // CountDownLatch
    class Foo {
        private CountDownLatch sec = new CountDownLatch(1);
        private CountDownLatch thr = new CountDownLatch(1);
        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            sec.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sec.await();
            printSecond.run();
            thr.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            thr.await();
            printThird.run();
        }
    }

    //@lc:end


    public static void main(String[] args) {
        Foo solution = new PrintInOrder().new Foo();
        Runnable first = () -> System.out.println("first");
        Runnable second = () -> System.out.println("second");
        Runnable third = () -> System.out.println("third");

        new Thread(() -> {
            try {
                solution.third(third);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "third").start();

        new Thread(() -> {
            try {
                solution.second(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "second").start();
        new Thread(() -> {
            try {
                solution.first(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "first").start();
    }
}
