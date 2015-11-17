package Misc;
import java.util.*;

public class SmartPurchase {
   
   private static class Pair<U,V> {
      private U item1;
      private V item2;
      
      Pair(U item1, V item2) {
         this.item1 = item1;
         this.item2 = item2;
      }
   }
   
   private static void getOptimalChoice(List<Pair<List<String>, Integer>> menu, List<String> toBuy) {
      List<List<Integer>> combos = getCombinations(menu.size());
      Set<String> toBuySet = new HashSet<String>(toBuy);
      Set<String> comboSet;
      
      List<Integer> bestCombo = new ArrayList<Integer>();
      int bestPrice = Integer.MAX_VALUE;
      
      for(List<Integer> aCombo : combos) {
         comboSet = new HashSet<String>();
         int comboPrice = 0;
         for (Integer i : aCombo) {
            comboSet.addAll(menu.get(i).item1);
            comboPrice += menu.get(i).item2;
         }
         
         if (matches(comboSet, toBuySet) && comboPrice < bestPrice) {
            bestPrice = comboPrice;
            bestCombo = aCombo;
         }
      }
      
      System.out.println("Best Price: " + bestPrice);
      System.out.println("Items to purchse: " + bestCombo.toString());
   }
   
   private static boolean matches(Set<String> comboSet, Set<String> toBuySet) {
      for (String item : toBuySet) {
         if (!comboSet.contains(item))
            return false;
      }
      
      return true;
   }
   
   private static List<List<Integer>> getCombinations(int n) {
      List<List<Integer>> outer;
      List<Integer> inner;
      
      if (n == 1) {
         outer = new ArrayList<List<Integer>>();
         inner = new ArrayList<Integer>();
         inner.add(n-1);
         outer.add(inner);
         return outer;
      }
      
      outer = getCombinations(n-1);
      
      int len = outer.size();
      for (int i=0; i<len; i++) {
         List<Integer> item = outer.get(i);
         inner = new ArrayList<Integer>(item);
         inner.add(n-1);
         outer.add(inner);
      }
      
      inner = new ArrayList<Integer>();
      inner.add(n-1);
      outer.add(inner);
      
      return outer;
   }
   
   public static void main(String args[]) {
      List<Pair<List<String>, Integer>> menu = new ArrayList<Pair<List<String>, Integer>>();
      List<String> menuItem = Arrays.asList("burger");
      menu.add(new Pair<List<String>, Integer>(menuItem, 5));
      
      menuItem = Arrays.asList("ff");
      menu.add(new Pair<List<String>, Integer>(menuItem, 4));
      
      menuItem = Arrays.asList("drink");
      menu.add(new Pair<List<String>, Integer>(menuItem, 8));
      
      menuItem = Arrays.asList("burger", "ff", "drink");
      menu.add(new Pair<List<String>, Integer>(menuItem, 12));
      
      menuItem = Arrays.asList("burger", "drink");
      menu.add(new Pair<List<String>, Integer>(menuItem, 14));
      
      List<String> toBuy;
      
      toBuy = Arrays.asList("drink");
      getOptimalChoice(menu, toBuy);
      
      toBuy = Arrays.asList("burger", "drink");
      getOptimalChoice(menu, toBuy);
      
      toBuy = Arrays.asList("burger", "ff");
      getOptimalChoice(menu, toBuy);


   }

}
