package Misc;

public class Semaphore {
   int n;
   int availResources;
   
   public Semaphore(int n) {
      this.n = n;
      this.availResources = n;
   }
   
   public synchronized void acquire() throws InterruptedException {
      availResources--;
      
      if(availResources<0)
         wait();
   }
   
   public synchronized void release() {
      
      if (availResources == n) {
         return;
      }
      
      if (availResources < 0) {
         availResources++;
         notify();
      } else {
         availResources++;
      }
   }
}