package myutils;

import java.util.List;

public class utilfuncs {
    public static boolean compareList(List<Integer> first, List<Integer> second) {
        if ((first == null && second != null) || (first != null && second == null))
            return false;
        
        if (first == null && second == null)
            return true;
        
        if (first.size() != second.size())
            return false;
        
        for(int ind=0; ind<first.size(); ind++) {
            if (first.get(ind) != second.get(ind)) {
                return false;
            }
        }
        
        return true;
    }
}
