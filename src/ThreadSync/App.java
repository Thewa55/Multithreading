package ThreadSync;

import java.util.Scanner;

public class
App {

    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press enter to stop");
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();

        proc1.shutdown();
    }
}

class Processor extends Thread{

    private volatile boolean running = true;
    //prevents threads caching variables when they are not changed within the thread

    public void run(){
        while (running) {
            System.out.println("Hello");

            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}