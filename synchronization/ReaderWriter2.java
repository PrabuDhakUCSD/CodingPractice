package synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriter2 {
    private int sharedValue;
    private int readerCount;
    private int writerCount;
    private Lock readerThrottleLock = new ReentrantLock();
    private Lock readerCountLock = new ReentrantLock();
    private Lock writerCountLock = new ReentrantLock();
    private Lock readerLock = new ReentrantLock();
    private Lock writerLock = new ReentrantLock();
    
    private int read() {
        readerThrottleLock.lock(); // Makes sure there is only one reader competing for readerLock in the next step.
            readerLock.lock();
                readerCountLock.lock();
                    readerCount++;
                    if (readerCount == 1)
                        writerLock.lock();
                readerCountLock.unlock();
            readerLock.unlock();
        readerThrottleLock.unlock();
        
        int returnValue = sharedValue;
        
        readerCountLock.lock();
            readerCount--;
            if (readerCount == 0)
                writerLock.unlock();
        readerCountLock.unlock();
        
        return returnValue;
    }
    
    private void write(int value) {
        writerCountLock.lock(); // This locks makes that there is only one writer at a time waiting for readerLock below.
                                // This might lead to one writer competing with 100 reders for readerLock. That's why we need
                                // readerThrottleLock above.
            writerCount++;
            if (writerCount == 1)
                readerLock.lock();
        writerCountLock.unlock();
        
        writerLock.lock();
            sharedValue = value;
        writerLock.unlock();
        
        writerCountLock.lock();
            writerCount--;
            if (writerCount == 0)
                readerLock.unlock();
        writerCountLock.unlock();
    }
}
