package cn.celess.medium.T1117;

import cn.celess.utils.*;

public class BuildingH2o {

    //@lc:start
    class H2O {
        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        }
    }
    //@lc:end


    public static void main(String[] args) {
        H2O solution = new BuildingH2o().new H2O();
        Assert assertion = Assert.getInstance();
    }
}
