package graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

public class DFS {
    public static List<Integer> dfsWalkRecursive(Graph g, int start) {
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        dfsExplore(g, start, visited, result);
        return result;
    }
    
    private static void dfsExplore(Graph g, int current, Set<Integer> visited, List<Integer> result) {
        result.add(current);
        visited.add(current);
        
        for(Integer child : g.getChildren(current)) {
            if (!visited.contains(child))
                dfsExplore(g, child, visited, result);
        }
    }
    
    public static List<Integer> dfsWalkIterative(Graph g, int start) {
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        stack.addLast(start);
        
        while(!stack.isEmpty()) {
            Integer current = stack.getLast();
            
            if (!visited.contains(current)) {
                result.add(current);
                visited.add(current);
            }
            
            Integer unvisitedChild = g.getNextUnvisitedChild(current, visited);
            
            if (unvisitedChild != -1) {
                stack.addLast(unvisitedChild);
                continue;
            }
            
            stack.removeLast();
        }
        
        return result;
    }
}
