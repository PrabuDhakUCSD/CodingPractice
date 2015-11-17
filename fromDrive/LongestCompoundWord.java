package Misc;
import java.util.*;

class Node {
   Character val;
   Map<Character, Node> children = new HashMap<Character, Node>();
   boolean isTerminal;
   
   Node(Character val) {
      this.val = val;
   }
}

class Trie {
   Node root = new Node('.');
   
   void addWord(String word) {
      if (word == null || word.isEmpty())
         return;
      
      Node cur = root;
      
      for (int i=0; i<word.length(); i++) {
         Character c = word.charAt(i);
         if (!cur.children.containsKey(c)) {
            cur.children.put(c, new Node(c));
         }
         cur = cur.children.get(c);
      }
      
      cur.isTerminal = true;
   }
}

public class LongestCompoundWord {
   
   public static Trie constructTrie(String[] words) {
      
      if (words == null || words.length == 0)
         return null;
      
      Trie t = new Trie();
      for(String word : words) {
         t.addWord(word);
      }
      
      return t;
   }
   
   public static int isCompoundWord(Trie t, String word, Map<String, Integer> dp) {
      if (word.isEmpty())
         return 0;
      
      if (dp.containsKey(word)) {
         System.out.println("dp hit");
         return dp.get(word);
      }
      
      int compLen = 0;
      Node cur = t.root;
      
      for(int i=0; i<word.length(); i++) {
         Character c = word.charAt(i);
         if (!cur.children.containsKey(c)) {
            dp.put(word, compLen);
            return compLen;
         }
         
         cur = cur.children.get(c);
         
         if (!cur.isTerminal)
            continue;
         
         int lenRest = isCompoundWord(t, word.substring(i+1), dp);
         
         if (lenRest != 0 && lenRest + 1 > compLen) {
            compLen = lenRest + 1;
         }
      }
      
      if (cur.isTerminal) {
         compLen = Math.max(1, compLen);
      }
      
      dp.put(word, compLen);
      return compLen;
   }
   
   public static void main(String args[]) {
      String[] words = {"cat", "cats", "catsdogcats", "catxdogcatsrat", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcat", "ratcatdog", "ratcatdogcat"};
      Trie t = constructTrie(words);
      Map<String, Integer> dp = new HashMap<String, Integer>();
      
      for( String word : words) {
         System.out.println(word + "\t\t\t\t" + String.valueOf(isCompoundWord(t, word, dp)));
      }
   }
}
