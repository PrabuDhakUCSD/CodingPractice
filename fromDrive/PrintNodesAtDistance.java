package Misc;



public class PrintNodesAtDistance {
   
   static class Node {
      int val;
      Node left;
      Node right;
      
      Node(int val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
   
   public static void printNodes(Node root, Node n, int k) {
      getDistance(root, n, k);
   }
   
   public static int getDistance(Node root, Node n, int k) {
      if (root == null) 
         return -1;
      
      if (root == n) {
         printNodesAtDistance(n, k);
         return 0;
      }
      
      int ld = getDistance(root.left, n, k);
      if (ld != -1) {
         ld ++;
         int remDis = k-ld;
         
         if (remDis < 0)
            return ld;
         
         if (remDis == 0) {
            System.out.print(root.val + ",");
            return ld;
         }
         
         printNodesAtDistance(root.right, remDis-1);
         return ld;
      }
      
      int rd = getDistance(root.right, n, k);
      if (rd != -1) {
         rd++;
         int remDis = k-rd;
         
         if (remDis < 0)
            return rd;
         
         if (remDis == 0) {
            System.out.print(root.val + ",");
            return rd;
         }
         
         printNodesAtDistance(root.left, remDis-1);
         return rd;
      }
      
      return -1;
   }
   
   public static void printNodesAtDistance(Node root, int k) {
      if (root == null)
         return;
      
      if (k==0) {
         System.out.print(root.val + ",");
         return;
      }
      
      printNodesAtDistance(root.left, k-1);
      printNodesAtDistance(root.right, k-1);
   }
   
   public static void main(String args[]) {
      
      Node four = new Node(4, null, null);
      Node ten = new Node(10, null, null);
      Node fourteen = new Node(14, null, null);
      Node twelve = new Node(12, ten, fourteen);
      Node eight = new Node(8, four, twelve);
      Node tt = new Node(22, null, null);
      
      Node twenty = new Node(20, eight, tt);
      
      printNodes(twenty, eight, 2);
      System.out.println();
      printNodes(twenty, fourteen, 3);
      System.out.println();
      printNodes(twenty, fourteen, 4);
      System.out.println();
      printNodes(twenty, twenty, 1);
      System.out.println();
      printNodes(twenty, twenty, 0);
   }
}