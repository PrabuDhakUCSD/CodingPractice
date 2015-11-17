package Misc;

import java.util.*;

public class LargestSumSubArray {
   public static List<Integer> lssa(int[] input) {
      return helper(input, 0, input.length-1);
   }
   
   private static List<Integer> helper(int[] input, int s, int e) {
      if (s > e)
         return null;
      
      List<Integer> output = new ArrayList<Integer>();
      
      if (s == e) {
         output.add(s);
         output.add(e);
         output.add(input[s]);
      } else {
         int mid = (s+e)/2;
         List<Integer> left = helper(input,s, mid);
         List<Integer> right = helper(input, mid+1, e);
         List<Integer> mixed = getMixed(input, s, e);
         
         if (left.get(2) >= right.get(2) && left.get(2) >= mixed.get(2))
            output = left;
         
         else if (right.get(2) >= left.get(2) && right.get(2) >= mixed.get(2))
            output = right;
         
         else
            output = mixed;
      }
      
      return output;
   }
   
   private static List<Integer> getMixed(int[] ip, int s, int e) {
      int mid = (s+e)/2;
      
      int leftMaxSum = ip[mid];
      int leftInd = mid;
      int tsum = ip[mid];
      
      for (int i=mid-1; i>=s; i--) {
         tsum += ip[i];
         if (tsum > leftMaxSum) {
            leftMaxSum = tsum;
            leftInd = i;
         }
      }
      
      int rightMaxSum = ip[mid+1];
      int rightInd = mid+1;
      tsum = ip[mid+1];
      
      for (int i=mid+2; i<=e; i++) {
         tsum += ip[i];
         if (tsum > rightMaxSum) {
            rightMaxSum = tsum;
            rightInd = i;
         }
      }
      
      List<Integer> output = new ArrayList<Integer>();
      output.add(leftInd);
      output.add(rightInd);
      output.add(leftMaxSum + rightMaxSum);
      
      return output;
   }
   
   public static void main(String args[]) {
      int[] ip = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
      System.out.println(lssa(ip));
   }
}
