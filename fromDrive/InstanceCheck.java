package Misc;

public class InstanceCheck {
   private static class Node<T> {
      T x;
      public Node(T x) {
         this.x = x;
      }
   }
   
   public static void main(String args[]) {
      Node<Integer> i = new Node<Integer>(10);
      Node<String> d = new Node<String>("foo");
      
      if (i.getClass() == d.getClass()) {
         System.out.println("Yes, though T is different, two objects point to the same class object.");
      } else {
         System.out.println("Nope, T is different and hence two objects point at different class object.");
      }
      
      if (i instanceof Node) {
         System.out.println("i is an instance of Node.");
      }
      
      Object obj = d;
      
      Node<Integer> dd = (Node<Integer>) obj;
      
      if (i.x != dd.x) {
         System.out.println("Compared Int and Double by means of object comparison");
      }
      
   }
}
