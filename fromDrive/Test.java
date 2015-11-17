package Misc;

public class Test {
   
   public static void changeFoo(Integer foo) {
      foo*=10;
   }
   
   public static void main(String args[]) {
      Integer foo = 10;
      changeFoo(foo);
      System.out.println(foo);
   }
}
