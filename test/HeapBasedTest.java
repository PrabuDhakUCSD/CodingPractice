package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import heapbased.NwayMerge;

import org.junit.Test;

public class HeapBasedTest {

    @Test
    public void mergeTest1() {
        List<Integer> list1 = Arrays.asList(1,4,7);
        List<Integer> list2 = Arrays.asList(2,5,8);
        List<Integer> list3 = Arrays.asList(3,6,9);
        
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        
        List<Integer> expected = new ArrayList<Integer>();
        expected.addAll(list1);
        expected.addAll(list2);
        expected.addAll(list3);
        
        Collections.sort(expected);
        
        List<Integer> result = NwayMerge.mergeSorted(lists);
        assertTrue(compareList(expected, result));
    }
    
    @Test
    public void mergeTest2() {
        List<Integer> list1 = Arrays.asList(13,18,22,25);
        List<Integer> list2 = Arrays.asList(5,9,15);
        List<Integer> list3 = Arrays.asList(2,8,11);
        
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        
        List<Integer> expected = new ArrayList<Integer>();
        expected.addAll(list1);
        expected.addAll(list2);
        expected.addAll(list3);
        
        Collections.sort(expected);
        
        List<Integer> result = NwayMerge.mergeSorted(lists);
        assertTrue(compareList(expected, result));
    }
    
    private boolean compareList(List<Integer> first, List<Integer> second) {
        if ((first == null && second != null) || (first != null && second == null))
            return false;
        
        if (first == null && second == null)
            return true;
        
        if (first.size() != second.size())
            return false;
        
        for(int ind=0; ind<first.size(); ind++) {
            if (first.get(ind) != second.get(ind)) {
                printList(first);
                printList(second);
                return false;
            }
        }
        
        return true;
    }
    
    private void printList(List<Integer> list) {
        System.out.println();
        for(int ind=0; ind<list.size(); ind++) {
            System.out.print(list.get(ind));
        }
    }

}
