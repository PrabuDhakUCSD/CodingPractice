package Misc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReadersWriters {
   int readerCount;
   Lock readCountLock = new ReentrantLock();
   Lock readerWriterLock = new ReentrantLock();
   
   public ReadersWriters() {
      readerCount = 0;
   }
   
   public void acquireReadLock() {
      readCountLock.lock();
      
      if (++readerCount == 1) { //1st reader
         readerWriterLock.lock();
      }
      
      readCountLock.unlock();
   }
   
   public void releaseReadLock() {
      readCountLock.lock();
      
      if (--readerCount == 0) { // no more readers
         readerWriterLock.unlock();
      }
      
      readCountLock.unlock();
   }
   
   public void acquireWriteLock() {
      readerWriterLock.lock();
   }
   
   public void releaseWriteLock() {
      readerWriterLock.unlock();
   }
}