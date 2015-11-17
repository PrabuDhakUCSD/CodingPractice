package Misc;

public class IsSubTree {
   public static boolean isSubTree(Node root, Node subRoot) {
      if (subRoot == null)
         return true;
      
      if (root == null)
         return false;
      
      if (root.val == subRoot.val && isSubTree(root.left, subRoot.left) && isSubTree(root.right, subRoot.right))
         return true;
      
      return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
   }
}
