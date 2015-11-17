package dp;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class knapsack {
    public static List<Integer> withrepetition(int[] weight, int[] value, int capacity) {
        int numItem = value.length;
        int[] itemChosen = new int[capacity+1];
        int[] valueObtained = new int[capacity+1];
        
        Arrays.fill(itemChosen, -1);
        Arrays.fill(valueObtained, 0);
        
        for (int c=1; c<=capacity; c++) {
            for (int item = 0; item < numItem; item++) {
                if (weight[item] > c)
                    continue;
                
                int remCap = c - weight[item];
                int valForRemCap = valueObtained[remCap];
                if (valForRemCap + value[item] > valueObtained[c]) {
                    valueObtained[c] = valForRemCap + value[item];
                    itemChosen[c] = item;
                }
            }
        }
        
        List<Integer> output = new ArrayList<Integer>();
        output.add(valueObtained[capacity]);
        
        int item;
        int remCap = capacity;
        
        while(true) {
            item = itemChosen[remCap];
            if (item == -1)
                break;
            
            output.add(item);
            remCap -= weight[item];
        }
        
        return output;
    }
}