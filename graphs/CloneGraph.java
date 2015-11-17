package graphs;
import java.util.*;

public class CloneGraph {
    public static Node cloneGraph(Node root) {
        Map<Node, Node> oldToNew = new HashMap<Node, Node>();
        return copyNode(root, oldToNew);
    }
    
    private static Node copyNode(Node current, Map<Node, Node> oldToNew) {
        if (current == null)
            return current;
        
        if (oldToNew.containsKey(current))
            return oldToNew.get(current);
        
        List<Node> newChildren = (current.children != null && current.children.size() > 0)? new ArrayList<Node>() : null;
        Node newNode = new Node(current.c, newChildren);
        oldToNew.put(current,  newNode);
        
        if (current.children != null) {
            for (Node child : current.children) {
                newNode.children.add(copyNode(child, oldToNew));
            }
        }
        
        return newNode;
    }
}

class Node {
    
    public Node(char c, List<Node> children) {
        this.c = c;
        this.children = children;
    }
    
    public char c;
    public List<Node> children;
}
