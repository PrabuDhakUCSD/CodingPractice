package graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

public class BFS {
    public static List<Integer> bfsWalk(Graph g, int start) {
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        
        visited.add(start);
        queue.addLast(start);
        
        while(!queue.isEmpty()) {
            Integer current = queue.removeFirst();
            result.add(current);
            
            for (Integer child : g.getChildren(current)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.addLast(child);
                }
            }
        }
        
        return result;
    }
}
