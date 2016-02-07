import java.util.*;

public class RecognizeWordFromStream {

    class Node {
        char c;
        boolean isTerminal;
        Map<Character, Node> children;
        
        public Node(char c, boolean isTerminal) {
            this.c = c;
            this.isTerminal = isTerminal;
            children = new HashMap<Character, Node>();
        }
    }
    
    Node root;
    List<Character> stream = new LinkedList<Character>();
    int longestWordLen;
    
    public RecognizeWordFromStream(String[] words) {
        root = new Node('.', false);
        for(String word : words) {
            addWordToGraph(word);
            
            longestWordLen = Math.max(longestWordLen, word.length());
        }
    }
    
    public void addToStream(char c) {
        
        System.out.println("Adding: " + c);
        stream.add(0, c);
        
        if (stream.size() > longestWordLen)
            stream.remove(stream.size()-1);
        
        
        Node current = root;
        for(Character ch : stream) {
            if(current.children.containsKey(ch))
                current = current.children.get(ch);
            else
                break;
        }
        
        if (current.isTerminal) {
            System.out.println("Seen a word.");
        }
    }
    
    private void addWordToGraph(String word) {
        Node current = root;
        
        char[] wordCh = word.toCharArray();
        
        for(int i=wordCh.length-1; i>=0; i--) {
            if (!current.children.containsKey(wordCh[i])) {
                Node n = new Node(wordCh[i], (i==0));
                current.children.put(wordCh[i], n);
            }
            
            current = current.children.get(wordCh[i]);
        }
    }
    
    public static void main(String[] args) {
        RecognizeWordFromStream r = new RecognizeWordFromStream(new String[] {"ok", "test", "one", "try", "trying"});
        r.addToStream('a');
        r.addToStream('b');
        r.addToStream('c');
        r.addToStream('o');
        r.addToStream('k');
        r.addToStream('f');
        r.addToStream('o');
        r.addToStream('o');
        r.addToStream('b');
        r.addToStream('t');
        r.addToStream('r');
        r.addToStream('y');
        r.addToStream('i');
        r.addToStream('n');
        r.addToStream('g');
    }

}
