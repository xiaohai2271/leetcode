package cn.celess.medium;

import cn.celess.utils.*;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 禾几海
 * @date : 2021年06月03日 11:50
 * @difficulty : medium
 * @info submissions: 65516       accepted: 36601      acceptance: 55.87%
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/print-foobar-alternately">1115.交替打印FooBar</a>
 */
public class PrintFoobarAlternately {

    //@lc:start
    // Lock + Condition
    class FooBar1 {
        private int n;
        private Lock lock = new ReentrantLock();
        private Condition fooCondition = lock.newCondition();
        private Condition barCondition = lock.newCondition();
        private int status = 1;

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            lock.lock();
            try {
                for (int i = 0; i < n; i++) {
                    while (status % 2 != 1) fooCondition.await();
                    printFoo.run();
                    status++;
                    barCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            lock.lock();
            try {
                for (int i = 0; i < n; i++) {
                    while (status % 2 != 0) barCondition.await();
                    printBar.run();
                    status++;
                    fooCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // 信号量
    class FooBar2 {
        private int n;
        private Semaphore fooSemaphore = new Semaphore(1);
        private Semaphore barSemaphore = new Semaphore(0);

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                printFoo.run();
                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                printBar.run();
                fooSemaphore.release();
            }
        }
    }

    // Synchronized
    class FooBar3 {
        private int n;
        Object obj = new Object();
        int status = 1;

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            synchronized (obj) {
                for (int i = 0; i < n; i++) {
                    while (status % 2 != 1) {
                        obj.notifyAll();
                        obj.wait();
                    }
                    printFoo.run();
                    status++;
                    obj.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized (obj) {
                for (int i = 0; i < n; i++) {
                    while (status % 2 != 0) {
                        obj.notifyAll();
                        obj.wait();
                    }
                    printBar.run();
                    status++;
                    obj.notifyAll();
                }
            }
        }
    }

    //cyclicBarrier
    class FooBar {
        private int n;
        private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        private volatile int status = 0;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (status == 1) ;
                printFoo.run();
                status++;
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                printBar.run();
                status--;
            }
        }
    }
    //@lc:end


    public static void main(String[] args) {
        FooBar solution = new PrintFoobarAlternately().new FooBar(10);
        Runnable foo = () -> System.out.print("foo");
        Runnable bar = () -> System.out.print("bar\n");
        new Thread(() -> {
            try {
                solution.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                solution.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
