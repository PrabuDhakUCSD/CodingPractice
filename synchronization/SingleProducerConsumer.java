package synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.Random;

public class SingleProducerConsumer {
    private int[] buffer;
    private int readPos;
    private int writePos;
    private final int capacity;
    private int size;
    private Lock exclusiveLock;
    private Condition canProduce;
    private Condition canConsume;
    private Random ran;
    
    public SingleProducerConsumer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        readPos = writePos = size = 0;
        exclusiveLock = new ReentrantLock();
        canProduce = exclusiveLock.newCondition();
        canConsume = exclusiveLock.newCondition();
        ran = new Random();
    }
    
    public int Produce() throws Exception {
        exclusiveLock.lock();
        
        while (size == capacity) {
            canProduce.await();
            exclusiveLock.lock();
        }
        
        int item = ran.nextInt(20)+1;
        buffer[writePos] = item;
        size++;
        canConsume.signal();
        exclusiveLock.unlock();
        writePos = (writePos + 1) % capacity;
        return item;
    }
    
    public int Consume() throws Exception {
        exclusiveLock.lock();
        
        while (size == 0) {
            canConsume.await();
            exclusiveLock.lock();
        }
        
        int itemConsumed = buffer[readPos];
        size--;
        canProduce.signal();
        exclusiveLock.unlock();
        readPos = (readPos + 1) % capacity;
        return itemConsumed;
    }
}
