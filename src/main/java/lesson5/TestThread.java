package lesson5;

public class TestThread  extends Thread {
    int size;
    int percent;
    float[] arr;
    int offset;

    public TestThread(float[] arr, int size, int offset) {
        this.arr = arr;
        this.size = size;
        this.offset = offset;
        percent = Math.round (size / 100);
        System.out.println("init arr");
    }

        @Override
        public void run() {
            System.out.println("run " + Thread.currentThread().getName());
                for (int i = 0; i < size; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + (i+offset) / 5) * Math.cos(0.2f + (i+offset) / 5) * Math.cos(0.4f + (i+offset) / 2));
//                    if((i%percent) == 0){
//                        if(Thread.currentThread().getName() == "Thread 1"){
//                            System.out.print("\rProgress Thread 1: " + (Math.round(i/percent)) + "%");
//                        }
//                        else{
//                            System.out.print("\rProgress Thread 2: " + (Math.round(i/percent)) + "%");
//                        }
//                    }
                }
            System.out.println("\n Выполнен поток " + Thread.currentThread().getName());
        }
}