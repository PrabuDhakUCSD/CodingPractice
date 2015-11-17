package Misc;

public class SortedListToBalancedBST {
   class ListNode {
      int value;
      ListNode next;
   }
   
   class TreeNode {
      int value;
      TreeNode left;
      TreeNode right;
   }
   
   TreeNode listToTree(ListNode head) {
      if (head == null)
         return null;
      
      int numNodes = 0;
      
      ListNode temp = head;
      
      while(temp != null) {
         numNodes++;
         temp = temp.next;
      }
      
      ListNode[] listHead = {head};
      return helper(listHead, 0, numNodes-1);
   }
   
   TreeNode helper(ListNode[] head, int start, int end) {
      if (start > end)
         return null;
      
      int mid = start + (end - start)/2;
      
      TreeNode leftSubTree = helper(head, 0, mid-1);
      TreeNode root = new TreeNode(head[0].value);
      head[0] = head[0].next;
      TreeNode rightSubTRee = helper(head, mid+1, end);
      
      return root;
   }
}
