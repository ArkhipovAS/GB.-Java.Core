package lesson5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestCount {
    static final int size = 1000;
    static final int h = size / 2;
    static final int repeat = 3;
    float[] arr = new float[size];
    float[] arr1 = new float[h];
    float[] arr2 = new float[h];

    public void FillArr() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
//        Arrays.fill(arr, 1);
    }

    public void oneThread (TestCount tc){
        System.out.println("Start execution");
        long a = System.currentTimeMillis();
        Thread thrd1 = new Thread(new TestThread(tc.arr, size));
        thrd1.setName("Thread 1");
        thrd1.start();
//        System.out.println(Thread.currentThread().isAlive());
        try {
            thrd1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execution time "+ ": " + (System.currentTimeMillis() - a));
    }

    public void doubleThread (TestCount tc){
        System.out.println("Start execution");
        long a = System.currentTimeMillis();
        Thread thrd1 = new Thread(new TestThread(tc.arr1, h));
        Thread thrd2 = new Thread(new TestThread(tc.arr2, h));
        thrd1.setName("Thread 1");
        thrd2.setName("Thread 2");
        thrd1.start();
        thrd2.start();
        try {
            thrd1.join();
            thrd1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execution time "+ ": " + (System.currentTimeMillis() - a));

    }




    public static void main(String[] args) {
        TestCount tc = new TestCount();
        tc.FillArr();
//        tc.oneThread(tc);
        tc.doubleThread(tc);


    }
}
