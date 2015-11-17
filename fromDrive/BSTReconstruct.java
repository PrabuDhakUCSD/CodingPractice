package Misc;

public class BSTReconstruct {
   
   private static class Node {
      int val;
      Node left;
      Node right;
      
      Node(int val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
   
   public static Node reconstruct(int[] preOrder) {
      return helper(preOrder, new int[] {0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }
   
   private static Node helper(int[] preOrder, int[] curInd, int min, int max) {
      int ind = curInd[0];
      if (ind >= preOrder.length || preOrder[ind] < min || preOrder[ind] > max)
         return null;
      
      Node n = new Node(preOrder[ind], null, null);
      curInd[0] = curInd[0] + 1;
      n.left = helper(preOrder, curInd, min, n.val);
      n.right = helper(preOrder, curInd, n.val, max);
      
      return n;
   }
   
   private static void inorder(Node n) {
      if (n == null)
         return;
      
      inorder(n.left);
      System.out.print(n.val + ",");
      inorder(n.right);
   }
   
   private static void preorder(Node n) {
      if (n == null)
         return;

      System.out.print(n.val + ",");
      preorder(n.left);
      preorder(n.right);
   }
   
   public static void main(String args[]) {
      Node n = reconstruct(new int[] {30, 20, 50, 38, 57, 60});
      inorder(n);
      System.out.println();
      preorder(n);
   }
}
