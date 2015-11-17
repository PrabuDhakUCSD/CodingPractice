package Misc;

import java.util.*;
public class SmartPurchase2 {
   
   private static class Pair {
      List<MenuItem> items;
      int totalCost;
      
      Pair(List<MenuItem> items, int cost) {
         this.items = items;
         this.totalCost = cost;
      }
   }
   
   private static class MenuItem {
      List<String> items;
      int price;
      
      MenuItem(List<String> items, int price) {
         this.items = items;
         this.price = price;
      }
      
      boolean containsItem(String item) {
         return items.contains(item);
      }
      
      public String toString() {
         return items.toString() + "\t\t" + String.valueOf(price); 
      }
   }
   
   private static List<MenuItem> getMenuItems(List<MenuItem> menu, String item) {
      List<MenuItem> output = new ArrayList<MenuItem>();
      
      for (MenuItem m : menu) {
         if (m.containsItem(item))
            output.add(m);
      }
      
      return output;
   }
   
   private static Pair getOptimalChoice(List<MenuItem> menu, List<String> toBuy) {
      if (toBuy.isEmpty()) {
         return new Pair(new ArrayList<MenuItem>(), 0);
      }
      
      String firstItem = toBuy.get(0);
      List<MenuItem> candidateMenuItems = getMenuItems(menu, firstItem);
      
      int bestPrice = Integer.MAX_VALUE;
      List<MenuItem> bestChoice = null;
      
      for (MenuItem aChoice : candidateMenuItems) {
         List<String> toBuyCopy = new ArrayList<String>(toBuy);
         toBuyCopy.removeAll(aChoice.items);
         
         Pair rest = getOptimalChoice(menu, toBuyCopy);
         
         if (rest.items != null && rest.totalCost + aChoice.price < bestPrice) {
            bestPrice = rest.totalCost + aChoice.price;
            rest.items.add(aChoice);
            bestChoice = rest.items;
         }
      }
      
      return new Pair(bestChoice, bestPrice);
   }
   
   public static void main(String args[]) {
      List<MenuItem> menu = new ArrayList<MenuItem>();
      
      menu.add(new MenuItem(Arrays.asList("burger"), 5));
      menu.add(new MenuItem(Arrays.asList("ff"), 4));
      menu.add(new MenuItem(Arrays.asList("drink"), 8));
      menu.add(new MenuItem(Arrays.asList("burger", "ff", "drink"), 12));
      menu.add(new MenuItem(Arrays.asList("burger", "drink"), 14));
      
      List<String> toBuy;
      Pair p;
      
      toBuy = Arrays.asList("drink");
      p = getOptimalChoice(menu, toBuy);
      if (p.items != null)
         System.out.println(p.items);
      else
         System.out.println("No possible to buy all the items");
      
      toBuy = Arrays.asList("burger", "drink");
      p = getOptimalChoice(menu, toBuy);
      if (p.items != null)
         System.out.println(p.items);
      else
         System.out.println("No possible to buy all the items");
      
      toBuy = Arrays.asList("burger", "ff");
      p = getOptimalChoice(menu, toBuy);
      if (p.items != null)
         System.out.println(p.items);
      else
         System.out.println("No possible to buy all the items");
      
      toBuy = Arrays.asList("burger", "chicken");
      p = getOptimalChoice(menu, toBuy);
      if (p.items != null)
         System.out.println(p.items);
      else
         System.out.println("No possible to buy all the items");
      
   }
}