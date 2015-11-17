package Misc;
import java.util.*;

public class SortStack {
   public static void sort(Deque<Integer> stk) {
      Deque<Integer> helper = new ArrayDeque<Integer>();
      
      while(!stk.isEmpty()) {
         int curElem = stk.removeLast();
         
         if (helper.isEmpty()) {
            helper.addLast(curElem);
            continue;
         }
         
         while (!helper.isEmpty() && helper.getLast() > curElem) {
            stk.addLast(helper.removeLast());
         }
         
         helper.addLast(curElem);
      }
      
      while (!helper.isEmpty()) {
         stk.addLast(helper.removeLast());
      }
   }
   
   public static void main(String args[]) {
      Deque<Integer> stk = new ArrayDeque<Integer>();
      Random r = new Random();
      
      for (int i=0; i<=20; i++) {
         stk.addLast(r.nextInt(100));
      }
      
      sort(stk);
      
      while(!stk.isEmpty()) {
         System.out.print(stk.removeLast() + ",");
      }
   }
}
