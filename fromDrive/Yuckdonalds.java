package Misc;

import java.util.*;

public class Yuckdonalds {
   public static List<Integer> findProfitableSites(int[] dist, int[] profit, int minDist, int[] outMaxProfit) {
      int[] profUntilSiteI = new int[dist.length];
      int[] prevSite = new int[dist.length];
      boolean[] isSiteIncluded = new boolean[dist.length];
      profUntilSiteI[0] = profit[0];
      isSiteIncluded[0] = true;
      prevSite[0] = -1;
      
      
      for(int siteId=1; siteId<dist.length; siteId++) {
         prevSite[siteId] = siteId-1;
         isSiteIncluded[siteId] = false;
         
         int profWithoutCurSite = profUntilSiteI[siteId-1];
         int profWithCurSite = profit[siteId];
         int indOfFirstCompatibleSite = binSearch(dist, siteId, minDist);
         
         if (indOfFirstCompatibleSite != -1) {
            profWithCurSite += profUntilSiteI[indOfFirstCompatibleSite];
         }
         
         if (profWithCurSite > profWithoutCurSite) {
            profUntilSiteI[siteId] = profWithCurSite;
            prevSite[siteId] = indOfFirstCompatibleSite;
            isSiteIncluded[siteId] = true;
         } else {
            profUntilSiteI[siteId] = profWithoutCurSite;
         }
      }
      
      outMaxProfit[0] = profUntilSiteI[dist.length-1];
      
      List<Integer> output = new ArrayList<Integer>();
      
      for (int siteId = dist.length-1; siteId>=0;) {
         if (isSiteIncluded[siteId]) {
            output.add(0, siteId);
         }
         
         siteId = prevSite[siteId];
      }
      
      return output;
   }
   
   private static int binSearch(int[] dist, int siteId, int minDist) {
      int compatInd = -1;
      
      int s=0, e=siteId-1;
      int mid;
      int base = dist[siteId];
      
      while (s <= e) {
         mid = (s+e)/2;
         
         if (base - dist[mid] < minDist) {
            e = mid-1;
         } else {
            compatInd = mid;
            s = mid+1;
            
            if (base - dist[mid+1] < minDist)
               break;
         }
      }
      
      return compatInd;
   }
   
   public static void main(String args[]) {
      int[] dist = new int[] {1, 7, 10, 13, 19, 22, 26};
      int[] profit = new int[] {10, 3, 13, 8, 5, 4, 9};
      // int[] profit = new int[] {10, 26, 13, 2, 5, 24, 9};
      
      int[] outMaxProfit = new int[1];
      int minDist = 5;
      List<Integer> selectedSite = findProfitableSites(dist, profit, minDist, outMaxProfit);
      System.out.println("Max Profit obtainable: " + outMaxProfit[0]);
      System.out.println(selectedSite);
   }
}
