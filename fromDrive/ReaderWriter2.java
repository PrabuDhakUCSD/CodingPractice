package Misc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriter2 {
   int readerCount = 0;
   int writerCount = 0;
   
   Lock readCountLock = new ReentrantLock();
   Lock writeCountLock = new ReentrantLock();
   Lock readerLock = new ReentrantLock();
   Lock writerLock = new ReentrantLock();
   Lock limitReaderLock = new ReentrantLock();
   
   public void acquireReadLock() {
      limitReaderLock.lock();
      readerLock.lock();
      readCountLock.lock();
      
      if (++readerCount == 1) { //1st reader
         writerLock.lock();
      }
      
      readCountLock.unlock();
      readerLock.unlock();
      limitReaderLock.unlock();
   }
   
   public void releaseReadLock() {
      readCountLock.lock();
      
      if (--readerCount == 0) { //last reader
         writerLock.unlock();
      }
      
      readCountLock.unlock();
   }
   
   public void acquireWriteLock() {
      writeCountLock.lock();
      
      if (++writerCount == 1) { //1st writer
         readerLock.lock(); // stop readers
      }
      
      writeCountLock.unlock();
      
      writerLock.lock();
   }
   
   public void releaseWriteLock() {
      writerLock.unlock();
      
      writeCountLock.lock();
      
      if (--writerCount == 0) { //last writer
         readerLock.unlock();
      }
      
      writeCountLock.unlock();
   }
}