package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;

public class RuntimePool {

    public static Test mTest;
    public static void main(String[] args) {

/*    String str1 = new StringBuilder("计算").append("机器").toString();
    System.out.println(str1.intern() == str1);

    String str2 = new StringBuilder("ja").append("va").toString();
    System.out.println(str2.intern() == str2);*/

        mTest = new RuntimePool.Test();
        mTest = null;
        System.gc();
        try {
            Thread.sleep(1000);
            if (mTest != null) {
                mTest.isAlive();
            } else {
                System.out.println("No ,it's already dead."+ mTest.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mTest = null;
        System.gc();
        try {
            Thread.sleep(1000);
            if (mTest != null) {
                mTest.isAlive();
            } else {
                System.out.println("No ,it's already dead.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Test {

        public void isAlive() {
            System.out.println("I'm still alive.:" + this.toString());
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Test execute finialize()....");
            RuntimePool.mTest = this;
        }
    }

}