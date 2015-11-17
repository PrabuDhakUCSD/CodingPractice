package graphs;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Graph {
    
    private Map<Integer, List<Integer>> adjList;
    
    public Graph() {
        adjList = new HashMap<Integer, List<Integer>>();
    }
    
    public void addEdge(int from, int to) {
        if (!adjList.containsKey(from)) {
            adjList.put(from, new ArrayList<Integer>());
        }
        
        if (!adjList.containsKey(to)) {
            adjList.put(to,  new ArrayList<Integer>());
        }
        
        adjList.get(from).add(to);
    }
    
    public List<Integer> getChildren(int vertex) {
        if (!adjList.containsKey(vertex))
            return new ArrayList<Integer>();
        
        return adjList.get(vertex);
    }
    
    public int getNextUnvisitedChild(int vertex, Set<Integer> visited) {
        if (!adjList.containsKey(vertex))
            return -1;
        
        List<Integer> childrenList = adjList.get(vertex);
        
        for (int child : childrenList) {
            if (!visited.contains(child))
                return child;
        }
        
        return -1;
    }
}
