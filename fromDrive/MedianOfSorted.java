package Misc;

public class MedianOfSorted {
   
   public static double getMedian(int[] a, int[] b) {
      if (a.length < b.length) {
         return getMedianHelper(a, 0, a.length-1, b);
      }
      
      return getMedianHelper(b, 0, b.length-1, a);
   }
   
   public static double getMedianHelper(int[] a /*shorter array first*/, int ali, int ari, int[] b) {
      int la = a.length;
      int lb = b.length;
      
      if (ali > ari) {
         int maxEndInd = Math.min((la+lb)/2, b.length-1);
         int minStartInd = Math.max((la+lb)/2 - la, 0);
         return getMedianHelper(b, minStartInd, maxEndInd, a);
      }
      
      // Keeping shorter array first ensures midAInd is always <= required number of smaller items
      // and bLarIndSmallerthanMid is always within bounds of b. If you want to avoid having shorter
      // array first, then we need two additional conditions to make sure midAInd is already not above 
      // required value and bLarIndSmallerthanMid is within bounds of b. See getMedianHelper1 which
      // tackles this.
      int midAInd = (ali+ari)/2;
      int bLarIndSmallerthanMid = (la+lb)/2-midAInd-1;
      
      if (bLarIndSmallerthanMid >= 0 && a[midAInd] < b[bLarIndSmallerthanMid]) {
         return getMedianHelper(a, midAInd+1, ari, b);
      }
      
      if (bLarIndSmallerthanMid+1 < b.length && a[midAInd] > b[bLarIndSmallerthanMid+1]) {
         return getMedianHelper(a, ali, midAInd-1, b);
      }
      
      if ((la+lb)%2 == 1) {
         return a[midAInd];
      }
      
      if (bLarIndSmallerthanMid < 0) {
         return (a[midAInd] + a[midAInd-1])/2.0;
      }
      
      if (midAInd < 0) {
         return (a[midAInd] + b[bLarIndSmallerthanMid])/2.0;
      }
      
      return (a[midAInd] + Math.max(a[midAInd-1], b[bLarIndSmallerthanMid]))/2.0;
   }
   
   public static double getMedianHelper1(int[] a, int ali, int ari, int[] b) {
      int la = a.length;
      int lb = b.length;
      
      if (ali > ari) {
         int maxEndInd = Math.min((la+lb)/2, b.length-1);
         int minStartInd = Math.max((la+lb)/2 - la, 0);
         return getMedianHelper1(b, minStartInd, maxEndInd, a);
      }
      
      int midAInd = (ali+ari)/2;
      int bLarIndSmallerthanMid = (la+lb)/2-midAInd-1;
      
      if (midAInd > (la+lb)/2) {
         return getMedianHelper1(a, ali, midAInd-1, b);
      }
      
      if (bLarIndSmallerthanMid >= b.length) {
         return getMedianHelper1(a, midAInd+1, ari, b);
      }
      
      if (bLarIndSmallerthanMid >= 0 && a[midAInd] < b[bLarIndSmallerthanMid]) {
         return getMedianHelper1(a, midAInd+1, ari, b);
      }
      
      if (bLarIndSmallerthanMid+1 < b.length && a[midAInd] > b[bLarIndSmallerthanMid+1]) {
         return getMedianHelper1(a, ali, midAInd-1, b);
      }
      
      if ((la+lb)%2 == 1) {
         return a[midAInd];
      }
      
      if (bLarIndSmallerthanMid < 0) {
         return (a[midAInd] + a[midAInd-1])/2.0;
      }
      
      if (midAInd < 0) {
         return (a[midAInd] + b[bLarIndSmallerthanMid])/2.0;
      }
      
      return (a[midAInd] + Math.max(a[midAInd-1], b[bLarIndSmallerthanMid]))/2.0;
   }
   
   public static double getMedianLinear(int[] a, int[] b) {
      int la = a.length;
      int lb = b.length;
      int count = (la+lb)/2+1;
      int ai = 0;
      int bi = 0;
      int x=0, y=0;
      
      for (int i=0; i<count; i++) {
         int t;
         if (ai < la && bi <lb) {
            if (a[ai] <= b[bi]) {
               t = a[ai++];
            } else {
               t = b[bi++];
            }
         } else if (ai < la) {
            t = a[ai++];
         } else {
            t = b[bi++];
         }
         
         x = y;
         y = t;
      }
      
      if ((la+lb)%2 == 1) {
         return y;
      }
      
      return (x+y)/2.0;
   }
   
   public static void main(String args[]) {
    int[] a = {1,2,9,13,15,18,25,33,37,42};
    int[] b = {4,6,8,11,12,50,55};
    
    System.out.println("Optimal: " + getMedian(a, b));
    System.out.println("Optimal_V2: " + getMedianHelper1(a, 0, a.length-1, b));
    System.out.println("Linear: " + getMedianLinear(a, b));
   }
}