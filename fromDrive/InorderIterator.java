package Misc;
import java.util.Iterator;
import java.util.Deque;
import java.util.ArrayDeque;

class Node {
   int value;
   Node left;
   Node right;
}

public class InorderIterator implements Iterator<Node> {
   Node root;
   Node currentNode;
   Node toReturn;
   boolean exploredLeft;
   Deque<Node> stk;
   
   public InorderIterator(Node root) {
      this.root = root;
      currentNode = root;
      toReturn = null;
      exploredLeft = false;
      stk = new ArrayDeque<Node>();
   }
   
   @Override
   public boolean hasNext() {
      if (toReturn != null)
         return true;
      
      if (currentNode == null)
         return false;
      
      if (!exploredLeft) {
         while (currentNode != null) {
            stk.addLast(currentNode);
            currentNode = currentNode.left;
         }
      }
      
      toReturn = stk.removeFirst();
      
      if (toReturn.right == null && !stk.isEmpty()) {
         currentNode = stk.getFirst();
         exploredLeft = true;
      } else {
         currentNode = toReturn.right;
         exploredLeft = false;
      }
      
      return true;
   }

   @Override
   public Node next() {
      Node ret;
      if (hasNext()) {
         ret = toReturn;
         toReturn = null;
         return ret;
      }
      
      return null;
   }

   @Override
   public void remove() {
      throw new UnsupportedOperationException();
   }
}
