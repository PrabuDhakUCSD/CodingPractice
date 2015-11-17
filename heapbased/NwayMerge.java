package heapbased;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NwayMerge {
    public static List<Integer> mergeSorted(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<Integer>();
        
        PriorityQueue<Node> heap = new PriorityQueue<Node>();
        for (int listId=0; listId<lists.size(); listId++) {
            List<Integer> aList = lists.get(listId);
            if (aList!=null && aList.size() > 0) {
                heap.add(new Node(aList.get(0), listId, 0));
            }
        }
        
        while(!heap.isEmpty()) {
            Node minNode = heap.remove();
            result.add(minNode.value);
            List<Integer> currentList = lists.get(minNode.listId);
            if (currentList.size()-1 == minNode.index)
                continue;
            
            minNode.setValues(currentList.get(minNode.index + 1), minNode.listId, minNode.index + 1);
            heap.add(minNode);
        }
        
        return result;
    }
    
    private static class Node implements Comparable<Node> {
        private int value;
        private int listId;
        private int index;
        
        public Node (int value, int listId, int index) {
            setValues(value, listId, index);
        }
        
        public void setValues(int value, int listId, int index) {
            this.value = value;
            this.listId = listId;
            this.index = index;
        }
        
        @Override
        public int compareTo(Node other) {
            return (this.value == other.value)? 0 : (this.value < other.value)? -1 : 1;
        }
    }
}
