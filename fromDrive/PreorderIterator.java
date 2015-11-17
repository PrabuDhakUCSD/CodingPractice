package Misc;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

class Node {
   int value;
   Node left;
   Node right;
}

public class PreorderIterator implements Iterator<Node> {

   Node currentNode;
   Deque<Node> stk;
   Node toReturn;
   
   public PreorderIterator(Node root) {
      currentNode = root;
      stk = new ArrayDeque<Node>();
      toReturn = null;
   }
   
   @Override
   public boolean hasNext() {
      if (toReturn != null)
         return true;
      
      if (currentNode == null)
         return false;
      
      toReturn = currentNode;
      
      if (currentNode.left != null) {
         stk.addLast(currentNode);
         currentNode = currentNode.left;
         return true;
      }
      
      while(currentNode.right == null && !stk.isEmpty()) {
         currentNode = stk.removeFirst();
      }
      
      currentNode = currentNode.right;
      
      return true;
   }

   @Override
   public Node next() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void remove() {
      // TODO Auto-generated method stub
      
   }

}
