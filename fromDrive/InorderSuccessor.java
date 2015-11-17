package Misc;

public class InorderSuccessor {
   public static Node getSuccessor(Node n) {
      if (n == null)
         return null;
      
      if (n.right != null)
         return getSmallest(n.right);

      while (n.parent != null && n.parent.right ==n)
         n = n.parent;
      
      return n.parent;
   }
   
   private static Node getSmallest(Node n) {
      while (n.left != null)
         n = n.left;
      
      return n;
   }
}
