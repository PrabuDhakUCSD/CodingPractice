package Misc;
import java.util.*;
   
public class DisplayPossiblePaths {
   private static class Pair {
      int x;
      int y;
      
      Pair(int x, int y) {
         this.x = x;
         this.y = y;
      }
      
      public String toString() {
         return "(" + x + "," + y + ")";
      }
   }
   
   private static class Path {
      List<Pair> path;
      Path(List<Pair> path) {
         this.path = path;
      }
      
      public String toString() {
         return path.toString();
      }
   }
   
   private static List<Path> getAllPaths(int[][] grid, int x, int y, int gx, int gy, int maxSteps) {
      int rows = grid.length;
      int cols = grid[0].length;
      
      boolean[][] visited = new boolean[rows][cols];
      return helper(grid, visited, x, y, gx, gy, maxSteps);
   }
   
   private static List<Path> helper(int[][] grid, boolean[][] visited, int x, int y, int gx, int gy, int maxSteps) {
      int rows = grid.length;
      int cols = grid[0].length;
      
      List<Path> paths = new ArrayList<Path>();
      if (maxSteps < 0 || x < 0 || x >= rows || y < 0 || y>= cols || grid[x][y] == 1 || visited[x][y])
         return paths;
      
      if (x==gx && y==gy) {
         Path p = new Path(new ArrayList<Pair>());
         p.path.add(new Pair(x,y));
         paths.add(p);
         return paths;
      }
      
      visited[x][y] = true;
      
      List<Path> possiblePath = helper(grid, visited, x-1, y, gx, gy, maxSteps-1);
      possiblePath.addAll(helper(grid, visited, x+1, y, gx, gy, maxSteps-1));
      possiblePath.addAll(helper(grid, visited, x, y-1, gx, gy, maxSteps-1));
      possiblePath.addAll(helper(grid, visited, x, y+1, gx, gy, maxSteps-1));
      
      visited[x][y] = false;
      
      for (Path p : possiblePath) {
         p.path.add(0, new Pair(x,y));
      }
      
      return possiblePath;
   }
   
   public static void main(String args[]) {
      int[][] grid = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
         };
      
      List<Path> paths = getAllPaths(grid, 0, 0, 2, 3, 5);
      for (Path p : paths)
         System.out.println(p);
      
   }
}
