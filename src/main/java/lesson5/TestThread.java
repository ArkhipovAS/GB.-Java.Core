package lesson5;

public class TestThread  extends Thread {
    int size;
    int percent;
    float[] arr;

    public TestThread(float[] arr, int size) {
        this.arr = arr;
        this.size = size;
        percent = Math.round (size / 100);
        System.out.println("init arr");
    }


//        public void count1 (int repeat){
//            System.out.println("Start execution");
//            for (int k = 0; k < repeat; k++) {
//                long a = System.currentTimeMillis();
//                for (int i = 0; i < size; i++) {
//                    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                }
//                System.out.println("Execution time "+ k + ": " + (System.currentTimeMillis() - a));
//            }
//        }

        @Override
        public void run() {
            System.out.println("run " + Thread.currentThread().getName());
                for (int i = 0; i < size; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                    System.out.print(arr[i]);
                    if((i%percent) == 0){
                        if(Thread.currentThread().getName() == "Thread 1"){
                            System.out.print("\rProgress Thread 1: " + (Math.round(i/percent)) + "%");
                        }
                        else{
                            System.out.print("\rProgress Thread 2: " + (Math.round(i/percent)) + "%");
                        }
                    }
                }
            System.out.println("\n Выполнен поток " + Thread.currentThread().getName());
        }

//        public void count2 (int repeat){
//            for (int k = 0; k < repeat; k++) {
//                System.out.println("Start execution");
//                long a = System.currentTimeMillis();
//                float[] a1 = new float[size];
//                float[] a2 = new float[size];
//                System.arraycopy(arr, 0, a1, 0, h);
//                System.arraycopy(arr, h, a2, 0, h);
//                for (int i = 0; i < h; i++) {
//                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                }
//                for (int j = 0; j < h; j++) {
//                    a2[j] = (float)(a2[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
//                }
//                System.arraycopy(a1, 0, arr, 0, h);
//                System.arraycopy(a2, 0, arr, h, h);
//                System.out.println("Execution time "+ k + ": " + (System.currentTimeMillis() - a));
//
//            }
//
//        }
//    }
}
