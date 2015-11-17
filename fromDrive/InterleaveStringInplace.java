package Misc;

public class InterleaveStringInplace {
   public static int getSrcPos(int targetPos, int numBlocks, int blockSize) {
      int srcBlock = targetPos%numBlocks;
      int offset = targetPos/numBlocks;
      
      return srcBlock*blockSize + offset;
   }
   
   public static void interleave(char[] input) {
      int numBlocks = 4;
      int blockSize = input.length/numBlocks;
      
      for (int destPos=0; destPos<input.length; destPos++) {
         int srcPos = getSrcPos(destPos, numBlocks, blockSize);
         while (srcPos < destPos) {
            srcPos = getSrcPos(srcPos, numBlocks, blockSize);
         }
       
         if (srcPos != destPos)
            swap(input, srcPos, destPos);
      }
   }
   
   public static void swap(char[] ip, int src, int dest) {
      char temp = ip[src];
      ip[src] = ip[dest];
      ip[dest] = temp;
   }
   
   public static void main(String args[]) {
      String ip = "abcde12345pqrst!@#$%";
      char[] cip = ip.toCharArray();
      interleave(cip);
      System.out.println(cip);
   }
}