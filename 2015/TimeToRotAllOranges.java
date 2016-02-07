import java.util.*;

public class TimeToRotAllOranges {
    /*
     *  Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:

        0: Empty cell
        1: Cells have fresh oranges
        2: Cells have rotten oranges
     
        So we have to determine what is the minimum time required so that all the oranges become rotten.
        A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right).
        If it is impossible to rot every orange then simply return -1.
    */
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static boolean isValid(int maxRow, int maxCol, int x, int y) {
        return x>=0 && x<=maxRow && y>=0 && y<=maxCol;
    }
    
    public static int timeToRot(int[][] mat) {
        int rowMaxInd = mat.length-1;
        int colMaxInd = mat[0].length-1;
        
        Deque<Point> currentQueue = new ArrayDeque<Point>();
        Deque<Point> nextQueue = new ArrayDeque<Point>();
        
        int orangesToRot = 0;
        int timeUnits = 0;
        
        for(int i=0; i<=rowMaxInd; i++) {
            for (int j=0; j<=colMaxInd; j++) {
                if (mat[i][j] == 2) {
                    currentQueue.addLast(new Point(i,j));
                }
                
                if (mat[i][j] == 1) {
                    orangesToRot++;
                }
            }
        }
        
        while(!currentQueue.isEmpty()) {
            
            while(!currentQueue.isEmpty()) {
                Point p = currentQueue.removeFirst();
                
                if (isValid(rowMaxInd, colMaxInd, p.x, p.y+1) && mat[p.x][p.y+1] == 1) {
                    mat[p.x][p.y+1] = 2;
                    nextQueue.addLast(new Point(p.x, p.y+1));
                    orangesToRot--;
                }
                
                if (isValid(rowMaxInd, colMaxInd, p.x, p.y-1) && mat[p.x][p.y-1] == 1) {
                    mat[p.x][p.y-1] = 2;
                    nextQueue.addLast(new Point(p.x, p.y-1));
                    orangesToRot--;
                }
                
                if (isValid(rowMaxInd, colMaxInd, p.x+1, p.y) && mat[p.x+1][p.y] == 1) {
                    mat[p.x+1][p.y] = 2;
                    nextQueue.addLast(new Point(p.x+1, p.y));
                    orangesToRot--;
                }
                
                if (isValid(rowMaxInd, colMaxInd, p.x-1, p.y) && mat[p.x-1][p.y] == 1) {
                    mat[p.x-1][p.y] = 2;
                    nextQueue.addLast(new Point(p.x-1, p.y));
                    orangesToRot--;
                }
            }
            
            currentQueue = nextQueue;
            nextQueue = new ArrayDeque<Point>();
            
            if (!currentQueue.isEmpty())
                timeUnits++;
        }
        
        return orangesToRot == 0? timeUnits : -1;
    }
    
    public static void main(String[] args)  {
        int timeRequired = timeToRot(new int[][] {
            {2,1,0,2,1},
            {1,0,1,2,1},
            {1,0,0,2,1},
        });
        
        System.out.println(timeRequired);
        
        timeRequired = timeToRot(new int[][] {
            {2,1,0,2,1},
            {0,0,1,2,1},
            {1,0,0,2,1},
        });
        
        System.out.println(timeRequired);
        
        timeRequired = timeToRot(new int[][] {
            {0,0},
            {0,0},
        });
        
        System.out.println(timeRequired);

        timeRequired = timeToRot(new int[][] {
            {1,0},
            {0,0},
        });
        
        System.out.println(timeRequired);
        
        timeRequired = timeToRot(new int[][] {
            {2,1},
            {0,0},
        });
        
        System.out.println(timeRequired);
        
        timeRequired = timeToRot(new int[][] {
            {2,0},
            {0,1},
        });
        
        System.out.println(timeRequired);
        
        timeRequired = timeToRot(new int[][] {
            {2,2},
            {2,2},
        });
        
        System.out.println(timeRequired);
    }
}
