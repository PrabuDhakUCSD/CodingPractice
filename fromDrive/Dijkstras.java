package Misc;
import java.util.*;

public class Dijkstras {
   private class Pair {
      int distance;
      Vertex vertex;
      
      Pair(int distance, Vertex vertex) {
         this.distance = distance;
         this.vertex = vertex;
      }
   }
   
   private static class Vertex implements Comparable<Vertex> {
      String label;
      List<Pair> children;
      Vertex prev;
      int minDistanceFromSource;
      
      Vertex(String label) {
         this.label = label;
         this.children = new ArrayList<Pair>();
         prev = null;
         minDistanceFromSource = Integer.MAX_VALUE;
      }
      
      @Override
      public int compareTo(Vertex other) {
         return this.minDistanceFromSource-other.minDistanceFromSource;
      }
   }
   
   public static List<Vertex> getShortestPath(Vertex src, Vertex dest, List<Vertex> allVertices) {
      PriorityQueue<Vertex> minDistanceQueue = new PriorityQueue<Vertex>();
      src.minDistanceFromSource = 0;
      src.prev = null;
      
      minDistanceQueue.addAll(allVertices);
      
      Vertex minVertex;
      
      while(minVertex = minDistanceQueue.poll()) {
         
         if (minVertex == dest)
            break;
         
         for(Pair child : minVertex.children) {
            Vertex childVertex = child.vertex;
            
            if (minVertex.minDistanceFromSource + child.distance < childVertex.minDistanceFromSource) {
               childVertex.minDistanceFromSource = minVertex.minDistanceFromSource + child.distance;
               childVertex.prev = minVertex;
               minDistanceQueue.heapify();
            }
         }
      }
      
      if (dest.minDistanceFromSource == Integer.MAX_VALUE)
         return null;
      
      List<Vertex> shortestPath = new ArrayList<Vertex>();
      
      Vertex currentVertex = dest;
      
      while(dest != null) {
         shortestPath.add(0, currentVertex);
         currentVertex = currentVertex.prev;
      }
      
      return shortestPath;
   }
}