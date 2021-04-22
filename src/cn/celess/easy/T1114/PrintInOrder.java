package cn.celess.easy.T1114;

import cn.celess.utils.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {

    //@lc:start
    class Foo {


        AtomicInteger stat = new AtomicInteger(1);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {

            while (stat.get() != 1) ;
            stat.getAndIncrement();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (stat.get() != 2) ;
            stat.getAndIncrement();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (stat.get() != 3) ;
            stat.getAndIncrement();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Foo solution = new PrintInOrder().new Foo();
        Assert assertion = Assert.getInstance();
    }
}
