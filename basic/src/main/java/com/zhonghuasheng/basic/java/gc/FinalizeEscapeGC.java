package com.zhonghuasheng.basic.java.gc;

/**
 * 对象可以在GC时自我拯救，对象复写了finalize方法会在GC前被执行，finalize只能执行一次
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Executed Finalize");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        // finalize方法只会被系统自动调用一次
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("Dead");
        }

        // 第二次执行
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK = null;
        } else {
            System.out.println("Dead");
        }
    }
}
