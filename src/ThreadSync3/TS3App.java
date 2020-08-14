package ThreadSync3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TS3App {
    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    public static void main(String[] args) {
        new TS3App().starter();
    }

    public void stageOne(){

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list1.add(random.nextInt(100));
    }

    public void stageTwo(){

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list2.add(random.nextInt(100));
    }

    public void process(){
        for(int i = 0; i<1000; i++){
            stageOne();
            stageTwo();
        }
    }

    public void starter(){
        System.out.println("Starting...");
        long start = System.currentTimeMillis();
        process();
        long end = System.currentTimeMillis();

        System.out.println("Time need to complete: " + (end - start));
        System.out.println("List 1: " + list1.size() + " | List 2: " + list2.size());
    }
}