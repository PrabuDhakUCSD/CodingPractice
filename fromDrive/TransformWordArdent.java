package Misc;

import java.util.*;

public class TransformWordArdent {
   public static Map<String, Set<String>> buildTransformGraph(Set<String> dic) {
      Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
      
      for(String word : dic) {        
         String newStr;      
         // remove one character
         for (int ind=0; ind<word.length(); ind++) {
            newStr = word.substring(0, ind) + word.substring(ind+1);
            addToGraph(graph, dic, word, newStr);

            // transform one character
            char currChar = word.charAt(ind);
            for (int c='a'; c<='z'; c++) {
               if (c != currChar) {
                  newStr = word.substring(0, ind) + Character.toString((char)c) + word.substring(ind+1);
                  addToGraph(graph, dic, word, newStr);
               }
            }
         }
         
         // add one character
         for (int ind=0; ind<=word.length(); ind++) {
            for (int c='a'; c<='z'; c++) {
               newStr = word.substring(0, ind) + Character.toString((char)c) + word.substring(ind);
               addToGraph(graph, dic, word, newStr);
            }
         }
      }
      
      return graph;
   }
   
   public static List<String> doTransform(Set<String> dic, String from, String to) {
      Map<String, Set<String>> graph = buildTransformGraph(dic);
      Set<String> visited = new HashSet<String>();
      
      if (from.equals(to)) {
         List<String> out = new ArrayList<String>();
         out.add(from);
         return out;
      }
      
      Deque<List<String>> q = new ArrayDeque<List<String>>();
      visited.add(from);
      List<String> l = new ArrayList<String>();
      l.add(from);
      q.addLast(l);
 
      while(!q.isEmpty()) {
         List<String> pathSoFar = q.removeFirst();
         String currRoot = pathSoFar.get(pathSoFar.size()-1);
         
         if (!graph.containsKey(currRoot))
            continue;
         
         for(String child : graph.get(currRoot)) {
            if (!visited.contains(child)) {
               
               if (child.equals(to)) {
                  pathSoFar.add(child);
                  return pathSoFar;
               }
               
               List<String> copyOfPath = makeListCopy(pathSoFar);
               copyOfPath.add(child);
               visited.add(child);
               q.addLast(copyOfPath);
            }
         }
      }
      
      return new ArrayList<String>();
   }
   
   private static void addToGraph(Map<String, Set<String>> graph, Set<String> dic, String key, String val) {
      // do nothing if the transformation does not produce a word in the input dictionary
      if (!dic.contains(val))
         return;
      
      if (!graph.containsKey(key)) {
         graph.put(key, new HashSet<String>());
      }
      
      graph.get(key).add(val);
   }
   
   private static List<String> makeListCopy(List<String> ip) {
      if (ip == null)
         return null;
      
      List<String> out = new ArrayList<String>();
      out.addAll(ip);
      
      return out;
   }
   
   public static void main(String args[]) {
      Set<String> dic = new HashSet<String>();
      dic.addAll(Arrays.asList(new String[] {"cat", "bat", "bet", "bed", "at", "ad", "ed"}));
      
      List<String> path = doTransform(dic, "cat", "bed");
      System.out.println(path.toString());
      
      path = doTransform(dic, "cat", "at");
      System.out.println(path.toString());
      
      dic.remove("bet");
      
      path = doTransform(dic, "cat", "bed");
      System.out.println(path.toString());
      
      path = doTransform(dic, "boy", "boy");
      System.out.println(path.toString());
   }
}
