package Misc;

public class FindCommonAncestor {
   Node findCommonAncestor(Node root, Node a, Node b) { // Both a and b are guaranteed to be in the tree.
      if (root == null || root == a || root == b)
         return root;
      
      Node left = findCommonAncestor(root.left, a, b);
      Node right = findCommonAncestor(root.right, a, b);
      
      if (left!= null && right!=null)
         return root;
      
      if (left!=null)
         return left;
      
      return right;
   }
}
