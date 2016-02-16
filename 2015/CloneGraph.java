/*
 * Given a graph clone it. Graph is given as a List<Vertex> and vertex
 * can have a zero or more number of children. There is no single root
 * to the graph.
 * 
 * Assume that vertex defines equals and hashcode method so that it can
 * be successfully used during hash operations.
 * 
 * Verify results using bfs based traversal.
 */

import java.util.*;

public class CloneGraph {

    static class Vertex {
        public Vertex(char label) {
            this.label = label;
            this.children = null;
        }
        
        public void addChild(Vertex child) {
            if (this.children == null)
                this.children = new ArrayList<Vertex>();
            
            this.children.add(child);
        }
        
        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof Vertex))
                return false;
            
            Vertex otherVertex = (Vertex) other;
            return otherVertex.label == this.label;
        }
        
        @Override
        public int hashCode() {
            Character c = this.label;
            return 31 * c.hashCode();
        }
        
        char label;
        List<Vertex> children;
    }
    
    public static List<Vertex> cloneGraph(List<Vertex> vertices) {
        Map<Vertex, Vertex> map = new HashMap<Vertex, Vertex>();
        List<Vertex> clonedVertices = new ArrayList<Vertex>();
        for(Vertex v : vertices) {
            if (!map.containsKey(v)) 
                DFSWalk(v, map, clonedVertices);
        }
        
        return clonedVertices;
    }
    
    private static void DFSWalk(Vertex current, Map<Vertex, Vertex> map,
            List<Vertex> clonedVertices) {
        Vertex clone = new Vertex(current.label);
        clonedVertices.add(clone);
        map.put(current, clone);
        
        if (current.children != null) {
            clone.children = new ArrayList<Vertex>();
            for(Vertex child : current.children) {
                if (!map.containsKey(child)) {
                    DFSWalk(child, map, clonedVertices);
                }
                
                clone.children.add(map.get(child));
            }
        }
    }
    
    private static void bfsTraversal(List<Vertex> graph) {
        Set<Vertex> visited = new HashSet<Vertex>();
        
        for(Vertex v : graph) {
            if (!visited.contains(v)) {
                bfsWalk(v, visited);
                System.out.println("\n");
            }
        }
    }
    
    private static void bfsWalk(Vertex current, Set<Vertex> visited) {
        Deque<Vertex> queue = new ArrayDeque<Vertex>();
        visited.add(current);
        queue.addLast(current);
        
        while(!queue.isEmpty()) {
            Vertex v = queue.removeFirst();
            System.out.print(v.label + ",");
            
            if (v.children != null) {
                for(Vertex child : v.children) {
                    
                    if (!visited.contains(child)) {
                        visited.add(child);
                        queue.addLast(child);
                    }
                }
            }
        }
    }
    
    public static List<Vertex> createRandomGraph() {
        List<Vertex> graph = new ArrayList<Vertex>();
        
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        
        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        
        b.addChild(d);
        d.addChild(c);
        
        e.addChild(f);
        f.addChild(g);
        g.addChild(e);
        
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);
        graph.add(g);
        
        return graph;
    }
    
    public static void main(String[] args) {
        List<Vertex> graph = createRandomGraph();
        List<Vertex> clonedGraph = cloneGraph(graph);
        
        System.out.println("Original bfs walk:");
        bfsTraversal(graph);
        
        System.out.println("Clone bfs walk:");
        bfsTraversal(clonedGraph);
    }
}