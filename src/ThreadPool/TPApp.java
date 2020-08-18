package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{

    private int id;
    public Processor(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Starting: "+ id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: "+ id);
    }
}


public class TPApp {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

    }
}
