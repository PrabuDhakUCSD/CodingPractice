package synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriter1 {
    private int sharedValue;
    private int readerCount;
    Lock readerCountLock = new ReentrantLock();
    Lock writerLock = new ReentrantLock();
    
    public int read() {
        readerCountLock.lock();
        readerCount++;
        
        if (readerCount == 1) {
            writerLock.lock();
        }
        
        readerCountLock.unlock();
        
        int returnValue = sharedValue;
        
        readerCountLock.lock();
        readerCount--;
        
        if (readerCount == 0) {
            writerLock.unlock();
        }
        
        readerCountLock.unlock();
        
        return returnValue;
    }
    
    public void write(int val) {
        writerLock.lock();
        sharedValue = val;
        writerLock.unlock();
    }
}