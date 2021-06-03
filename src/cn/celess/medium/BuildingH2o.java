package cn.celess.medium;

import cn.celess.utils.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 禾几海
 * @date : 2021年06月03日 10:00
 * @difficulty : medium
 * @info submissions: 28850       accepted: 14973      acceptance: 51.90%
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/building-h2o">1117.H2O 生成</a>
 */
public class BuildingH2o {

    //@lc:start
    // 锁
    class H2O1 {
        private Lock lock = new ReentrantLock();
        private Condition oCondition = lock.newCondition();
        private Condition HCondition = lock.newCondition();
        private volatile int hCount = 0;


        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            lock.lock();
            while (hCount == 2) {
                oCondition.signal();
                HCondition.await();
            }
            try {
                releaseHydrogen.run();
                hCount++;
                oCondition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            lock.lock();

            while (hCount != 2) {
                HCondition.signal();
                oCondition.await();
            }
            try {
                releaseOxygen.run();
                hCount = 0;
                HCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // 信号量
    class H2O2 {
        Semaphore o = new Semaphore(0);
        Semaphore h = new Semaphore(2);

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            releaseHydrogen.run();
            o.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire(2);
            releaseOxygen.run();
            h.release(2);
        }
    }

    // 超时 锁
    class H2O {
        Object object = new Object();
        private int hCount = 0;

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            synchronized (object) {
                while (hCount == 2) {
                    object.notifyAll();
                    object.wait();
                }
                releaseHydrogen.run();
                hCount++;
                object.notifyAll();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            synchronized (object) {
                while (hCount != 2) {
                    object.notifyAll();
                    object.wait();
                }
                releaseOxygen.run();
                hCount = 0;
                object.notifyAll();
            }
        }
    }

    //@lc:end


    public static void main(String[] args) {
        H2O solution = new BuildingH2o().new H2O();

        Runnable releaseOxygen = () -> System.out.print("O");
        Runnable releaseHydrogen = () -> System.out.print("H");


        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    solution.oxygen(releaseOxygen);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "O").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    solution.hydrogen(releaseHydrogen);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "H").start();
    }
}
