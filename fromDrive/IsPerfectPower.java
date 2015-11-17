package Misc;

public class IsPerfectPower {
   public static boolean isPerfectPower(int ip) {
      int maxBase = ip/2;
      int maxPower = (int) Math.ceil(Math.log(ip));

      for (int base=2; base<=maxBase; base++) {
         int sp=2, ep=maxPower;
         int mid;

         while(sp <= ep) {
            mid = sp + (ep-sp)/2;
            int val = (int) Math.pow(base, mid);
            if (val == ip)
               return true;

            if (val < ip) {
               sp = mid+1;
            } else {
               ep = mid-1;
            }
         }
      }

      return false;        
   }
   
   public static void main(String args[]) {
      System.out.println("4 : " + isPerfectPower(4));
      System.out.println("16 : " + isPerfectPower(16));
      System.out.println("18 : " + isPerfectPower(18));
      System.out.println("8 : " + isPerfectPower(8));
      System.out.println("64 : " + isPerfectPower(64));
      System.out.println("10000 : " + isPerfectPower(10000));
      System.out.println("256 : " + isPerfectPower(256));
      System.out.println("255 : " + isPerfectPower(255));
      System.out.println("342 : " + isPerfectPower(342));
      System.out.println("125 : " + isPerfectPower(125));
      System.out.println("625 : " + isPerfectPower(625));
   }
}
