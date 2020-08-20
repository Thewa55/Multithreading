package CountdownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CLApp1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 0; i<10; i++){
            executor.submit(new Processor(latch));
        }

        System.out.println("Before latch await");
        try {
            latch.await();
            //waits until countdown latch counts down to 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }
}

class Processor implements Runnable{

    //thread safe class, so you don't need to sync
    private CountDownLatch latch;

    public Processor(CountDownLatch latch){
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();
    }
}