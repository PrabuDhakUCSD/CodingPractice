package Misc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.Deque;
import java.util.ArrayDeque;

public class BoundedConcurrentFairBuffer {
   
   int capacity;
   int size;
   int[] buffer;
   int readInd;
   int writeInd;
   
   Lock producerConsumerLock;
   Condition notFull;
   Condition notEmpty;
   Deque<Long> prodQ;
   Deque<Long> consQ;
   
   public BoundedConcurrentFairBuffer(int cap) {
      this.capacity = cap;
      size = readInd = writeInd = 0;
      this.buffer = new int[cap];
      producerConsumerLock = new ReentrantLock();
      notFull = producerConsumerLock.newCondition();
      notEmpty = producerConsumerLock.newCondition();
      prodQ = new ArrayDeque<Long>();
      consQ = new ArrayDeque<Long>();
   }
   
   public void produce(int item) throws InterruptedException {
      producerConsumerLock.lock();
      
      long threadId = Thread.currentThread().getId();
      
      prodQ.addLast(threadId);
      while (size == capacity || threadId != prodQ.getFirst() ) { // buffer is full (or) it's not current thread's turn in the wait queue
         notFull.await();
      }
      prodQ.removeFirst();
      
      size++;
      buffer[writeInd] = item;
      writeInd = (writeInd + 1) % capacity;
      
      if (!consQ.isEmpty()) {
         notEmpty.signalAll();
      }
      
      producerConsumerLock.unlock();
   }
   
   public int consume() throws InterruptedException {
      producerConsumerLock.lock();
      long threadId = Thread.currentThread().getId();      
      consQ.addLast(threadId);
      while (size == 0 || threadId != consQ.getFirst()) { // buffer is empty (or) it's not current thread's turn in the wait queue
         notEmpty.await();
      }
      consQ.removeFirst();
      
      int retValue = buffer[readInd];
      readInd = (readInd + 1) % capacity;
      
      if (!prodQ.isEmpty()) {
         notFull.signalAll();
      }
      
      producerConsumerLock.unlock();
      return retValue;
   }
}
