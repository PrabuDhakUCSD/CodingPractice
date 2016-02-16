
public class CloneBinaryTreeWithRandomPointers {

    static class Node {
        public Node(char label) {
            this.label = label;
            this.left = this.right = this.random = null;
        }
        
        public Node(char label, Node left, Node right) {
            this.label = label;
            this.left = left;
            this.right = right;
            this.random = null;
        }
        
        char label;
        Node left;
        Node right;
        Node random;
    }
    
    public static Node cloneTree(Node root) {
        if (root == null)
            return null;
        
        // clone each node and add it as the left child of the original node. 
        cloneEachNode(root);
        
        // fix random pointers
        fixRandomPointers(root);
        
        // restore tree to the original form
        return restoreTree(root);
    }
    
    private static Node restoreTree(Node current) {
        if (current == null)
            return null;
        
        Node currentClone = current.left;
        current.left = currentClone.left;
        currentClone.left = restoreTree(current.left);
        currentClone.right = restoreTree(current.right);
        
        return currentClone;
    }
    
    private static void fixRandomPointers(Node current) {
        if (current == null)
            return;
        
        current.left.random = current.random == null? null : current.random.left;
        
        fixRandomPointers(current.left.left);
        fixRandomPointers(current.right);
    }
    
    private static void cloneEachNode(Node current) {
        if (current == null)
            return;
        
        Node currentClone = new Node(current.label);
        currentClone.left = current.left;
        current.left = currentClone;
        
        cloneEachNode(currentClone.left);
        cloneEachNode(current.right);
    }
    
    private static void print(Node current, boolean isInorder) {
        if (current == null)
            return;
        
        if (isInorder) { 
            print(current.left, isInorder);
            System.out.print(current.label + ",");
            print(current.right, isInorder);
        } else { // pre order
            System.out.print(current.label + ",");
            print(current.left, isInorder);
            print(current.right, isInorder);
        }
    }
    
    private static void printRandom(Node current) {
        if (current == null)
            return;
        
        printRandom(current.left);
        if (current.random != null)
            System.out.print(current.random.label + ",");
        else
            System.out.print("NA,");
        printRandom(current.right);
    }
    
    private static Node createRandomTree() {
        /*
         *                   A
         *               B        C
         *                  F    D  E
         *                            G
         */
        
                
        Node f = new Node('f');
        Node d = new Node('d');
        Node g = new Node('g');
        Node b = new Node('b', null, f);
        Node e = new Node('e', null, g);
        Node c = new Node('c', d, e);
        Node a = new Node('a', b, c);
        
        a.random = e;
        b.random = d;
        c.random = g;
        d.random = f;
        f.random = a;
        g.random = e;
        
        return a;
    }
    
    public static void main(String[] args) {
        Node orig = createRandomTree();
        Node clone = cloneTree(orig);
        
        print(orig, true);
        System.out.println();
        
        print(clone, true);
        System.out.println();
        
        print(orig, false);
        System.out.println();
        
        print(clone, false);
        System.out.println();
        
        printRandom(orig);
        System.out.println();
        
        printRandom(clone);
    }
}