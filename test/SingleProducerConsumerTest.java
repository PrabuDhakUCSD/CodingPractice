package test;

import synchronization.SingleProducerConsumer;
import java.util.*;

import java.util.Random;

public class SingleProducerConsumerTest {

    public static void main(String[] args) throws Exception {
        SingleProducerConsumer prodCons = new SingleProducerConsumer(20);
        List<Integer> produced = new ArrayList<Integer>();
        List<Integer> consumed = new ArrayList<Integer>();
        Thread producer = new Thread(new ThreadWorker(prodCons, 0, produced));
        Thread consumer = new Thread(new ThreadWorker(prodCons, 1, consumed));
               
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
        
        for(int i : produced) {
            System.out.println(i + ",");
        }
        
        System.out.println("-------");
        
        for(int i : consumed) {
            System.out.println(i + ",");
        }
        // producer.interrupt();
        // consumer.interrupt();
    }

}

class ThreadWorker implements Runnable { 

    private int mode;
    private SingleProducerConsumer prodCons;
    private List<Integer> output;
    
    ThreadWorker(SingleProducerConsumer prodCons, int mode, List<Integer> output) {
        this.prodCons = prodCons;
        this.mode = mode;
        this.output = output;
    }
    
    @Override
    public void run() {
        Random ran = new Random();
        int  times = 10;
        int item;
        while (times-- > 0) {
            try {
                if (mode == 0) { // producer
                    item = prodCons.Produce();
                    System.out.println("Produced: " + item);
                    Thread.sleep(ran.nextInt(1000));
                } else {
                    item = prodCons.Consume();
                    System.out.println("Got: " + item);
                    Thread.sleep(ran.nextInt(500));
                }
                output.add(item);
            } catch (Exception ex) {
                System.out.println(String.format("Exception in mode (%d), exception: %s", mode, ex.toString()));
                return;
            }
        }
        
        
    }
}
