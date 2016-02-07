import java.util.*;

public class MovingAverage {
    
    int k;
    int totalSum;
    List<Integer> list;
    
    public MovingAverage(int k) {
        this.k = k;
        list = new LinkedList<Integer>();
    }
    
    public void add(int elem) {
        list.add(elem);
        totalSum += elem;
        
        if (list.size() > k) {
            totalSum -= list.remove(0);
        }
    }
    
    public float getAvg() {
        assert(list.size() <= k);
        return (float)totalSum/list.size();
    }
    
    public void printElemsAndAverage() {
        for(int i : list)
            System.out.print(i + ", ");
      
        System.out.println(getAvg());
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        ma.add(5);
        ma.printElemsAndAverage();
        ma.add(8);
        ma.printElemsAndAverage();
        ma.add(2);
        ma.printElemsAndAverage();
        ma.add(11);
        ma.printElemsAndAverage();
        ma.add(17);
        ma.printElemsAndAverage();
        ma.add(4);
        ma.printElemsAndAverage();
        ma.add(5);
        ma.printElemsAndAverage();
        ma.add(9);
        ma.printElemsAndAverage();
        ma.add(10);
        ma.printElemsAndAverage();
        ma.add(13);
        ma.printElemsAndAverage();
        ma.add(11);
        ma.printElemsAndAverage();
        ma.add(80);
        ma.printElemsAndAverage();
        ma.add(7);
        ma.printElemsAndAverage();
        ma.add(65);
        ma.printElemsAndAverage();
        ma.add(33);
        ma.printElemsAndAverage();
    }
}
