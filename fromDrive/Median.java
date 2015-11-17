package Misc;

public class Median {
   static double getMedian(int[] arr1, int[] arr2) {
      int i=0, j=0;
      int med1 = -1, med2 = -1;
      int cur;
      for (int count=0; count<= (arr1.length + arr2.length)/2; count++) {
         cur = (j==arr2.length || (i < arr1.length && arr1[i] < arr2[j]))?arr1[i++]:arr2[j++];      
         med1 = med2;
         med2 = cur;
      }
      
      if ((arr1.length + arr2.length)%2 == 0)
         return (med1+med2)/2.0;
      
      return med2;
   }
   
   static double getMedianOptimal(int[] arr1, int[] arr2) {   
      return helper(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1);
   }
   
   private static double helper(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2) {
      int len1 = e1-s1+1;
      int len2 = e2-s2+1;
      
      if (len1 != len2) 
         throw new IllegalArgumentException(String.format("Len of both arrays not equlal: %d, %d", len1, len2));
      
      if (len1 == 1)
         return (arr1[s1]+arr2[s2])/2.0;
      
      if (len1 == 2)
         return (Math.max(arr1[s1], arr2[s2])+ Math.min(arr1[e1], arr2[e2]))/2.0;
      
      int med1 = arr1[s1 + (len1/2)];
      int med2 = arr2[s2 + (len2/2)];
      
      if (med1 == med2)
         return med1;
      
      if (med1 < med2) {
         if (len1 % 2 == 0) {
            return helper(arr1, s1 + (len1/2-1), e1, arr2, s2, s2 + (len2/2));
         }
         
         return helper(arr1, s1 + (len1/2), e1, arr2, s2, s2 + (len2/2));
      }
      
      if (len1 % 2 == 0) {
         return helper(arr1, s1, s1 + (len1/2), arr2, s2 + (len2/2-1), e2);
      }
      
      return helper(arr1, s1, s1 + (len1/2), arr2, s2 + (len2/2), e2);    
   }
   
   public static void main(String args[]) {
      int[] arr1 = new int[] {5, 6, 10, 12, 13, 18, 20, 27, 29, 33, 54};
      int[] arr2 = new int[] {2, 3, 4, 7, 14, 15, 19, 23, 30, 45, 50};
      
      System.out.println(getMedian(arr1, arr2));
      System.out.println(getMedianOptimal(arr1, arr2));
   }
}