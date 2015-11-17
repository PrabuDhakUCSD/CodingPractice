package Misc;

public class FindPairInPosNegMixArray {
   private static class Pair {
      int a;
      int b;
      public Pair(int a, int b) {
         this.a= a;
         this.b = b;
      }
   }
   
   private static Pair searchNeg(int[] ip, int k) {
      System.out.println("Searching neg...");
      Pair op = new Pair(-1, -1);
      int i=0;
      int j=ip.length-1;
      
      while (i<ip.length && ip[i] >=0)
         i++;
      
      if (i >= ip.length)
         return op;
      
      while (j>=0 && ip[j] >=0)
         j--;

      if (j<0 || i==j)
         return op;
      
      while (i < j) {
         if (ip[i] + ip[j] == k) {
            op.a = i;
            op.b = j;
            return op;
         }
         
         if (ip[i]+ip[j] < k) {
            j--;
            while (j>=0 && ip[j] >=0)
               j--;
         } else {
            i++;
            while (i<ip.length && ip[i] >=0)
               i++;
         }
      }
      
      return op;
   }
   
   private static Pair searchPos(int[] ip, int k) {
      System.out.println("Searching pos...");
      Pair op = new Pair(-1, -1);
      int i=0;
      int j=ip.length-1;
      
      while (i<ip.length && ip[i] < 0)
         i++;
      
      if (i >= ip.length)
         return op;
      
      while (j>=0 && ip[j] < 0)
         j--;

      if (j<0 || i==j)
         return op;
      
      while (i < j) {
         if (ip[i] + ip[j] == k) {
            op.a = i;
            op.b = j;
            return op;
         }
         
         if (ip[i]+ip[j] < k) {
            i++;
            while (i<ip.length && ip[i]<0)
               i++;
         } else {
            j--;
            while (j>=0 && ip[j] < 0)
               j--;
         }
      }
      
      return op;
   }
   
   private static Pair searchPosAndNeg(int[] ip, int k) {
      System.out.println("Searching pos and neg...");
      Pair op = new Pair(-1, -1);
      int i = ip.length - 1;
      int j = i;
      
      while (i>=0 && ip[i] >=0)
         i--;
      
      if (i < 0)
         return op;
      
      while (j>=0 && ip[j] < 0)
         j--;
      
      if (j<0)
         return op;
      
      while (i>=0 && j>=0) {
         if (ip[i] + ip[j] == k) {
            op.a = i;
            op.b = j;
            return op;
         }
         
         if (ip[i] + ip[j] < k) {
            i--;
            while (i>=0 && ip[i]>=0)
               i--;
         } else {
            j--;
            while (j>=0 && ip[j] < 0)
               j--;
         }
      }
      
      return op;
   }
   
   public static Pair findPair(int[] ip, int k) {
      Pair p = searchPosAndNeg(ip, k);
      if (p.a == -1) {
         return (k>=0)? searchPos(ip, k) : searchNeg(ip, k);
      }
      
      return p;
   }
   
   public static void main(String args[]) {
      int[] ip = new int[] {-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};
      Pair p = findPair(ip, -619);
      System.out.println(String.format("Indices: (%d, %d)", p.a, p.b));
      
      if (p.a != -1) {
         System.out.println(String.format("Values: (%d, %d)", ip[p.a], ip[p.b]));
      }
   }
   

}
