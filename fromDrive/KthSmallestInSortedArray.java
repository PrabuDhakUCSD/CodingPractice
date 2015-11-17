package Misc;

public class KthSmallestInSortedArray {
   
   public static int kthsmallest(int[] a, int[] b, int k) {
      if (k <= 0 || a.length+b.length < k)
         throw new IllegalArgumentException();
      
      if (b.length == 0)
         return a[k-1];
      
      if (a.length == 0)
         return b[k-1];
      
      return kthsmallestHelper(a, 0, a.length-1, b, k);
   }
   
   public static int kthsmallestHelper(int[] a, int ali, int ari, int[] b, int k) {
      
      if (ali > ari) {
         int endInd = Math.min(b.length-1, k-1);
         int startInd = Math.max(0, k-1-a.length);
         return kthsmallestHelper(b, startInd, endInd, a, k);
      }
      
      int aMidInd = (ali+ari)/2;
      int bLarIndSmallerthanAMid = k-1-aMidInd-1;
      
      if (aMidInd > k-1) {
         return kthsmallestHelper(a, ali, aMidInd-1, b, k);
      }
      
      if (bLarIndSmallerthanAMid >= b.length) {
         return kthsmallestHelper(a, aMidInd+1, ari, b, k);
      }
      
      if (bLarIndSmallerthanAMid >= 0 && a[aMidInd] < b[bLarIndSmallerthanAMid]) {
         return kthsmallestHelper(a, aMidInd+1, ari, b, k);
      }
      
      if (bLarIndSmallerthanAMid+1 < b.length && a[aMidInd] > b[bLarIndSmallerthanAMid+1]) {
         return kthsmallestHelper(a, ali, aMidInd-1, b, k);
      }
      
      return a[aMidInd];
   }
   
   public static void main(String args[]) {
      int[] b = {1,2,3,4,5,6,500,600};
      int[] a = {7,8,9,10,100,200,300};
      
      for (int i=0; i<(a.length+b.length); i++) {
         System.out.println(kthsmallest(a, b, i+1));
      }
   }
}