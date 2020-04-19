package lesson5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestCount {
    static final int size = 10_000_000;
    static final int h = size / 2;
    static final int offset = h;
    float[] arr = new float[size];
    float[] arr1 = new float[h];
    float[] arr2 = new float[h];
    float [] arrOne = new float[size];
    float [] arrDouble = new float[size];

    public void FillArr() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
    }

    public float[] oneThread (TestCount tc){
        System.out.println("Start execution");
        long a = System.currentTimeMillis();
        Thread thrd1 = new Thread(new TestThread(tc.arr, size,0));
        thrd1.setName("Thread 1");
        thrd1.start();
        try {
            thrd1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execution time "+ ": " + (System.currentTimeMillis() - a));
        return tc.arr;
    }

    public float[] doubleThread (TestCount tc){
        System.out.println("Start execution");
        long a = System.currentTimeMillis();
        Thread thrd1 = new Thread(new TestThread(tc.arr1, h, 0));
        Thread thrd2 = new Thread(new TestThread(tc.arr2, h, h));
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
        System.arraycopy(arr1, 0, arrDouble, 0, h);
        System.arraycopy(arr2, 0, arrDouble, h, h);
        System.out.println("Execution time "+ ": " + (System.currentTimeMillis() - a));
        return arrDouble;
    }

    public static void main(String[] args) {
        TestCount tc = new TestCount();
        tc.FillArr();
        System.out.println(Arrays.equals(tc.oneThread(tc), tc.doubleThread(tc)));
    }
}
