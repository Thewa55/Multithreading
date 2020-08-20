package CountdownLatch;

import java.util.concurrent.CountDownLatch;

public class CLApp1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

    }
}

class Processor implements Runnable{

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
    }
}