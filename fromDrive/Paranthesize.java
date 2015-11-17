package Misc;
import java.util.*;

public class Paranthesize {
   
   public static boolean isValid(char[][] table, String input) {
      List<Set<Character>> dp = new ArrayList<Set<Character>>();
      dp.add(new HashSet<Character>());
      dp.get(0).add(input.charAt(0));
      
      for (int i=1; i<input.length(); i++) {
         Set<Character> currSet = new HashSet<Character>(); 
         dp.add(currSet);
         
         int currCharIndex = input.charAt(i)-'a';
         Set<Character> prevSet = dp.get(i-1);
         for(Character c : prevSet) {
            int prevResIndex = c-'a';
            currSet.add(table[prevResIndex][currCharIndex]);
         }
         
         Character currPrevProduct = table[input.charAt(i-1)-'a'][currCharIndex];
         currCharIndex = currPrevProduct-'a';
         if (i==1) {
            currSet.add(currPrevProduct);
         }
         else {
            prevSet = dp.get(i-2);
            for(Character c : prevSet) {
               int prevResIndex = c-'a';
               currSet.add(table[prevResIndex][currCharIndex]);
            }
         }
      }
      
      Set<Character> lastCharSet = dp.get(input.length()-1);
      return lastCharSet.contains('a');
   }
   
   public static void main(String[] args) {
      char[][] table = {
            {'b', 'b', 'a'},
            {'c', 'b', 'a'},
            {'a', 'c', 'c'}
         };
      
      if (isValid(table, "aac"))
         System.out.println("YES");
      else
         System.out.println("NO");
   }

}
