package Misc;

public class YoungsTableau {
   int getMinimum(Integer[][] grid) {
      return helper(grid, 0, 0, grid.length, grid[0].length);
   }
   
   Integer helper(Integer[][] grid, int r, int c, int maxRow, int maxCol) {
      if (r >= maxRow || c >= maxCol)
         return null;
      
      if (grid[r][c] != null)
         return grid[r][c];
      
      Integer rightVal = helper(grid, r, c+1, maxRow, maxCol);
      Integer bottomVal = helper(grid, r+1, c, maxRow, maxCol);
      
      if (rightVal != null)
         return bottomVal;
      
      if (bottomVal != null)
         return rightVal;
      
      return Math.min(rightVal, bottomVal);
   }
}
