package Misc;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MultiStackFromArray {
   
   private int numStacks;
   private int totalSize;
   private Node[] buffer;
   private int[] top;
   private int[] freeList;
   private int freeListTop;
   
   public MultiStackFromArray(int numStacks, int totalSize) {
      this.totalSize = totalSize;
      this.numStacks = numStacks;
      buffer = new Node[totalSize];
      top = new int[numStacks];
      Arrays.fill(top, -1);
      
      freeList = new int[totalSize];
      for (int i=0; i<totalSize; i++) {
         freeList[i] = i;
      }
      
      freeListTop = 0;
   }
   
   public int getNextFreeSlot() {
      if (freeListTop >= totalSize)
         return -1;
      
      return freeList[freeListTop++];
   }
   
   public void addToFreeSlot(int slotId) {
      if (freeListTop == 0)
         throw new IllegalArgumentException("Something went wrong. Trying to free a slot when all slots are already free.");
      
      freeList[--freeListTop] = slotId;
   }
   
   public void push(int stackId, int value) {
      if (stackId < 0 || stackId >= numStacks)
         throw new IllegalArgumentException("Given stack id out of bound");
      
      int newSlot = getNextFreeSlot();
      
      if (newSlot == -1) {
         System.out.println("There is no free slot at this moment. Please try again later.");
         return;
      }
      
      int currentTop = top[stackId];
      
      Node newNode = new Node(value, currentTop);
      buffer[newSlot] = newNode;
      top[stackId] = newSlot;
   }
   
   public int pop(int stackId) {
      if (stackId < 0 || stackId >= numStacks)
         throw new IllegalArgumentException("Pop: given stackid out of bound.");
      
      int currentTop = top[stackId];
      if (currentTop == -1)
         throw new NoSuchElementException("Pop: no element in the stack.");
      
      Node currentNode = buffer[currentTop];
      top[stackId] = currentNode.prevNodeIndex;
      addToFreeSlot(currentTop);
      return currentNode.value;
   }
   
   public void printStack(int stackId) {
      int stkTop = top[stackId];
      Node nodeTop;
      while(stkTop != -1) {
         nodeTop = buffer[stkTop];
         System.out.print(nodeTop.value + ", ");
         stkTop = nodeTop.prevNodeIndex;
      }
      
      System.out.println();
   }
   
   public void printAllStack(int max) {
      for (int i=0; i<max; i++)
         printStack(i);
   }
   
   private class Node {
      int value;
      int prevNodeIndex;
      
      Node(int value, int ind) {
         this.value = value;
         this.prevNodeIndex = ind;
      }
   }
   
   public static void main(String args[]) {
      MultiStackFromArray ms = new MultiStackFromArray(3, 8);
      ms.push(1, 150);
      ms.push(0, 23);
      ms.push(0, 24);
      ms.push(1, 175);
      ms.push(0, 25);
      ms.push(0, 26);
      ms.push(2, 1250);
      ms.push(0, 27);

      ms.printAllStack(3);
      
      System.out.println(ms.pop(1));
      System.out.println(ms.pop(0));
      System.out.println(ms.pop(2));
      System.out.println(ms.pop(0));
      
      ms.printAllStack(3);
      
      
   }
}