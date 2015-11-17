package Misc;

import java.util.*;

public class ReconstructWordFromTriplet {
   private static class Node {
      Character c;
      Map<Character, Node> children;
      
      Node(char c) {
         this.c = c;
         children = new HashMap<Character, Node>();
      }
   }
   
   private static void addToGraph(Map<Character, Node> graphNodes, String triplet) {
      Node prev = null;
      for (int i=2; i>=0; i--) {
         char c = triplet.charAt(i);
         Node node;
         if (!graphNodes.containsKey(c)) {
             node = new Node(c);
            graphNodes.put(c, node);
         }
         
         node = graphNodes.get(c);
         
         if (prev != null && !prev.children.containsKey(c)) {
            prev.children.put(c, node);
         }
         
         prev = node;
      }
   }
   
   private static String findString(Map<Character, Node> graphNodes) {
      Set<Character> visited = new HashSet<Character>();
      StringBuilder output = new StringBuilder();
      
      for(Map.Entry<Character, Node> entry : graphNodes.entrySet()) {
         Node n = entry.getValue();
         if (!visited.contains(n.c)) {
            dfsVisit(n, visited, output);
         }
      }
      
      return output.toString();
   }
   
   private static void dfsVisit(Node n, Set<Character> visited, StringBuilder output) {
      visited.add(n.c);
      
      for(Map.Entry<Character, Node> childEntry : n.children.entrySet()) {
         Node child = childEntry.getValue();
         
         if (!visited.contains(child.c)) {
            dfsVisit(child, visited, output);
         }
      }
      
      output.append(n.c);
   }
   
   private static List<String> getAllTriplets(String input) {
      List<String> output = new ArrayList<String>();
      
      StringBuilder s;
      
      char[] charInput = input.toCharArray();
      int len = charInput.length;
      
      for (int first=0; first<len-2; first++) {
         for( int sec=first+1; sec<len-1; sec++) {
            for (int third = sec+1; third<len; third++) {
               s = new StringBuilder();
               s.append(charInput[first]);
               s.append(charInput[sec]);
               s.append(charInput[third]);
               
               output.add(s.toString());
            }
         }
      }
      
      return output;
   }
   
   public static void main(String args[]) {
      Map<Character, Node> graphNodes = new HashMap<Character, Node>();
      List<String> triplets = getAllTriplets("brown pig");
      System.out.println("Number of triplets: " + triplets.size() + "\n" + triplets);
      for(String triplet : triplets) {
         addToGraph(graphNodes, triplet);
      }
   /*   addToGraph(graphNodes, "wol");
      addToGraph(graphNodes, "old");
      addToGraph(graphNodes, "orl");
      addToGraph(graphNodes, "wld");
      addToGraph(graphNodes, "wor");
      addToGraph(graphNodes, "wrl");
      addToGraph(graphNodes, "rld");
      addToGraph(graphNodes, "ord");
      addToGraph(graphNodes, "wod");
      addToGraph(graphNodes, "wrd");
      addToGraph(graphNodes, "wrd");
      addToGraph(graphNodes, "wrd"); */
      
      System.out.println(findString(graphNodes));
   }
}