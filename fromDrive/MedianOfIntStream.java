package Misc;
import java.util.*;

public class MedianOfIntStream {
   private static final int heapInitSize = 10;
   private static PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(heapInitSize, 
                                                                                          new Comparator<Integer>() {
                                                                                             @Override
                                                                                             public int compare(Integer a, Integer b) {
                                                                                                return b-a;
                                                                                             }
                                                                                          }
                                                                           );
   
   private static PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(heapInitSize, 
                                                                                          new Comparator<Integer>() {
                                                                                             @Override
                                                                                             public int compare(Integer a, Integer b) {
                                                                                                return a-b;
                                                                                             }
                                                                                          }
                                                                           );
   
   private static boolean isEvenLen() {
      return (maxQ.size() + minQ.size())%2 == 0;
   }
   
   public static double getMedian() {
      if (!isEvenLen())
         return maxQ.peek();
      
      if (maxQ.size() == 0)
         throw new RuntimeException("No items in the stream");
      
      return (maxQ.peek() + minQ.peek())/2.0;
   }
   
   public static double addToStream(int n) {
      if (maxQ.size() == 0)
         maxQ.add(n);
      else if (isEvenLen()) {
         if (n > minQ.peek()) {
            minQ.add(n);
            n = minQ.poll();
         }
         
         maxQ.add(n);
      } else {
         if (n < maxQ.peek()) {
            maxQ.add(n);
            n = maxQ.poll();
         }
         
         minQ.add(n);
      }
      
      return getMedian();
   }
   
   private static void PrintStreamSorted() {
      List<Integer> temp = new ArrayList<Integer>();
      temp.addAll(maxQ);
      temp.addAll(minQ);
      
      Collections.sort(temp);
      System.out.println(temp);
   }
   
   public static void main(String args[]) {
      Random r = new Random();
      double median;
      
      for (int i=1; i<=15; i++) {
         median = addToStream(r.nextInt(15));
         PrintStreamSorted();
         System.out.println("Median: " + median + "\n\n");
      }
   }
}