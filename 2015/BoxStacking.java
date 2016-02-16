import java.util.*;

public class BoxStacking {
    static class box implements Comparable<box> {
        public box(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }
        
        public int baseArea() {
            return l*w;
        }
        
        @Override
        public int compareTo(box other) {
            return other.baseArea() - this.baseArea();
        }
        
        public boolean canSitOnTopOf(box bottombox) {
            return this.l < bottombox.l && this.w < bottombox.w;
        }
        
        // Helper to create a box with base where l > w;
        public static box createBox(int l, int w, int h) {
            int len = (l>w)? l : w;
            int wid = (l>w)? w : l;
            
            return new box(len, wid, h);
        }
        
        @Override
        public String toString() {
            return String.format("[%d, %d, %d]", l, w, h);
        }
        
        int l, w, h;
    }
    
    public static void stackBoxes(List<box> boxes) {
        List<box> curatedBoxes = new ArrayList<box>();
        
        for(box b : boxes) {
            curatedBoxes.add(box.createBox(b.l, b.w, b.h));
            curatedBoxes.add(box.createBox(b.l, b.h, b.w));
            curatedBoxes.add(box.createBox(b.w, b.h, b.l));
        }
        
        Collections.sort(curatedBoxes);
        
        int len = curatedBoxes.size();
        int maxHeight = Integer.MIN_VALUE;
        int maxIndex = -1;
        
        int[] height = new int[len]; // height[i] = max height attainable when 'i' is the top box
        int[] prev = new int[len]; // prev[i] = index of bottom box of 'i'th box
        
        for(int i=0; i<len; i++) {
            box current = curatedBoxes.get(i);
            height[i] = current.h;
            prev[i] = -1;
            
            for(int j=i-1; j>=0; j--) {
                box bottomBox = curatedBoxes.get(j);
                if (current.canSitOnTopOf(bottomBox) && 
                        current.h + height[j] > height[i]) {
                    height[i] = current.h + height[j];
                    prev[i] = j;
                }
            }
            
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        
        System.out.println("Max height possible: " + maxHeight);
        
        while(maxIndex != -1) {
            System.out.println(curatedBoxes.get(maxIndex));
            maxIndex = prev[maxIndex];
        }
    }
    
    public static void main(String[] args) {
        List<box> boxes = new ArrayList<box>();
        boxes.add(new box(1,2,4));
        boxes.add(new box(3,2,5));
        
        stackBoxes(boxes);
    }
}