package Misc;
import java.util.*;

public class StackOfStack {
   int capacity;
   Deque<Integer> currentStack = null;
   List<Deque<Integer>> stackOfStacks = new ArrayList<Deque<Integer>>();
   
   public StackOfStack(int cap) {
      this.capacity = cap;
      currentStack = null;
   }
   
   public void push(int n) {
      if (currentStack == null || currentStack.size() == capacity) {
         System.out.println("New substack created: " + stackOfStacks.size()+1);
         currentStack = new ArrayDeque<Integer>();
         stackOfStacks.add(currentStack);
      }
      
      currentStack.addLast(n);
   }
   
   public int pop() {
      if (currentStack == null) {
         throw new NoSuchElementException();
      }
      
      int toReturn = currentStack.removeLast();
      removeEmptyLastStack();
      return toReturn;
   }
   
   private void removeEmptyLastStack() {
      if (currentStack.isEmpty()) {
         System.out.println("Removing stack: " + stackOfStacks.size());
         stackOfStacks.remove(currentStack);
         if (stackOfStacks.isEmpty()) {
            currentStack = null;
         } else {
            currentStack = stackOfStacks.get(stackOfStacks.size()-1);
         }
      }
   }
   
   public int pop(int id) {
      if (id > stackOfStacks.size())
         throw new IllegalArgumentException("Given stack id is not in scope");
      
      int toReturn = stackOfStacks.get(id-1).removeLast();
      
      for (int i=id-1; i<=stackOfStacks.size()-2; i++) {
         moveFromFirstToLast(stackOfStacks.get(i), stackOfStacks.get(i+1));
      }
      
      removeEmptyLastStack();
      
      return toReturn;
   }
   
   private void moveFromFirstToLast(Deque<Integer> to, Deque<Integer> from) {
      if (from.isEmpty())
         throw new IllegalArgumentException("From stack does not have elements");
      
      Deque<Integer> helper = new ArrayDeque<Integer>();
      
      while(!from.isEmpty()) {
         helper.addLast(from.removeLast());
      }
      
      to.addLast(helper.removeLast());
      
      while(!helper.isEmpty()) {
         from.addLast(helper.removeLast());
      }
   }
}
