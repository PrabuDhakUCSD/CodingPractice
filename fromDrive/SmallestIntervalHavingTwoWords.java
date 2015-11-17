package Misc;

public class SmallestIntervalHavingTwoWords {
   public static Pair<Integer, Integer> findInternval(String[] ip, String word1, String word2) {
      Pair<Integer, Integer> out = new Pair<Integer, Integer>();
      out.item1 = -1;
      out.item2 = -1;
      
      int ind=0;
      boolean seenWord1 = false;
      int startInd;
      
      while (ind < ip.length) {
         if (ip[ind].equals(word1)) {
            seenWord1 = true;
            startInd = ind;
            break;
         }
         
         if (ip[ind].equals(word2)) {
            startInd = ind;
            break;
         }
         
         ind++;
      }
      
      if (ind == ip.length)
         return out;
      
      ind++;
      
      while (ind < ip.length) {
         if (ip[ind].equals(word1)) {
            if (seenWord1) {
               startInd = ind;
            } else {
               updatePair(out, startInd, ind);
               startInd = ind;
               seenWord1 = true;
            }
         } else if (ip[ind].equals(word2)) {
            if (!seenWord1) {
               startInd = ind;
            } else {
               updatePair(out, startInd, ind);
               startInd = ind;
               seenWord1 = false;
            }
         }
         
         ind++;
      }
      
      return out;
   }
   
   private static void updatePair(Pair<Integer, Integer> out, int sind, int eind) {
      if (eind - sind < out.item2-out.item1) {
         out.item1 = sind;
         out.item2 = eind;
      }
   }
}