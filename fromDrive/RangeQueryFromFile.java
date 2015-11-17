package Misc;
import java.io.*;

public class RangeQueryFromFile {

   static class Query {
      int ind;
      int si;
      int ei;
      int rangeSum;
      int aggregateSum;
      
      public Query(int ind, int si, int ei) {
         this.ind = ind;
         this.si = si;
         this.ei = ei;
      }
   }

   public static int getRangeSum(int[] cumSum, int si, int ei) {
      int retValue = cumSum[ei];
      if (si > 0) {
         retValue -= cumSum[si-1];
      }
      
      return retValue;
   }
   
   public static int getRangeSum1(Query[] cumSum, int si, int ei) {
      int retValue = cumSum[ei].aggregateSum;
      if (si > 0) {
         retValue -= cumSum[si-1].aggregateSum;
      }
      
      return retValue;
   }
   
   public static void main(String[] args) throws Exception {
      String filepath = "C:\\Users\\prdhaksh\\Documents\\Coding\\CodingPractice\\src\\Misc\\testfiles\\rangesum.txt";
      BufferedReader br = new BufferedReader(new FileReader(filepath));
      int n = Integer.parseInt(br.readLine());
      int[] ip = new int[n];
      int[] cumSum = new int[n];
      int i=0;
      
      for(String s : br.readLine().split(" ")) {
         ip[i++] = Integer.parseInt(s);
      }
      
      cumSum[0] = ip[0];
      for (i=1; i<n; i++) {
         cumSum[i] = cumSum[i-1] + ip[i];
      }
      
      Query[] queries = new Query[n];
      
      for (i=0; i<n; i++) {
         String s = br.readLine();
         int si = Integer.parseInt(s.split(" ")[0]);
         int ei = Integer.parseInt(s.split(" ")[1]);
         queries[i] = new Query(i, si, ei);
      }
      
      queries[0].rangeSum = queries[0].aggregateSum = getRangeSum(cumSum, queries[0].si, queries[0].ei);
      
      for (i=1; i<n; i++) {
         queries[i].rangeSum = getRangeSum(cumSum, queries[i].si, queries[i].ei);
         queries[i].aggregateSum = queries[i-1].aggregateSum + queries[i].rangeSum;              
      }
      
      int numAsks = Integer.parseInt(br.readLine());
      
      int type;
      int sqi;
      int eqi;
      
      while(numAsks-- > 0) {
         String[] ask = br.readLine().split(" ");
         type = Integer.parseInt(ask[0]);
         sqi = Integer.parseInt(ask[1]);
         eqi = Integer.parseInt(ask[2]);
         
         System.out.println(getRangeSum1(queries, sqi, eqi));
      }
   }

}
