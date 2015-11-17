package Misc;

public class RotateArray {
   public static void rotateArray(int[][] arr) {
      int rs=0, cs=0, re=arr.length-1, ce=arr[0].length-1;
      while (rs < re) {
         int startRow = rs, startCol = cs, destRow, destCol;
         int tempVal;
         int colIndex = 0;
         while(startCol < ce) {
            destRow = rs+colIndex;
            destCol = ce;
            tempVal = swap(arr, destRow, destCol, arr[startRow][startCol]);
            
            destRow = re;
            destCol = ce-colIndex;
            tempVal = swap(arr, destRow, destCol, tempVal);
            
            destCol = cs;
            destRow = re-colIndex;
            tempVal = swap(arr, destRow, destCol, tempVal);
            
            destRow = startRow;
            destCol = startCol;
            tempVal = swap(arr, destRow, destCol, tempVal);
            
            startCol++;
            colIndex++;
         }
         
         rs++;
         re--;
         cs++;
         ce--;
      }
   }
   
   private static int swap(int[][] arr, int destRow, int destCol, int newVal) {
      int temp = arr[destRow][destCol];
      arr[destRow][destCol] = newVal;
      return temp;
   }
   
   public static void rotateArrayV2(int[][] input) {
      int rs=0, cs=0, re=input.length-1, ce=input[0].length-1;
      while (rs < re) {
         int offset = 0;
         
         while(cs+offset < ce) {
            int topLeft = input[rs][cs+offset];
            input[rs][cs+offset] = input[re-offset][cs];
            input[re-offset][cs] = input[re][ce-offset];
            input[re][ce-offset] = input[rs+offset][ce];
            input[rs+offset][ce] = topLeft;
            
            offset++;
         }
         
         rs++;
         re--;
         cs++;
         ce--;
      }
   }
   
   private static void print(int[][] input, int re, int ce) {
      for (int i=0; i<=re; i++) {
         for(int j=0; j<=ce; j++) {
            System.out.print(input[i][j] + "\t");
         }
         
         System.out.println();
      }
   }
   
   public static void main(String args[]) {
      int[][] input ={
                        { 4, 8, 12, 16 },
                        { 3, 7, 11, 15 },
                        { 2, 6, 10, 14 },
                        { 1, 5, 9, 13 }
                     };
      rotateArrayV2(input);
      print(input, 3, 3);
   }
}