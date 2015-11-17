void editDist(String from, String to) {
    if (from == null || to == null)
        throw new IllegalArgumentException();
        
    enum Change {
        Insert,
        Delete,
        Change
    }
    
    char[] cfrom = form.toCharArray();
    char[] cto = to.toCharArray();
    
    int rows = cfrom.length;
    int cols = cto.length;
    
    int[][] minCost = new int[rows][cols];
    Change[][] direction = new Change[rows][cols];
    
    minCost[0][0] = (cfrom[0] == cto[0])? 0 : 1;
    
    // Initialize 1st row.
    for (int c=1; c<cols; c++) {
        minCost[0][c] = minCost[0][c-1] + (cfrom[0] == cto[c])? 0 : 1;
    }
    
    // Initialize 1st column.
    for (int r=1; r<rows; r++) {
        minCost[r][0] = minCost[r-1][0] + (cFrom[r] == cto[0])? 0 : 1;
    }
    
    for (int r=1; r<rows; r++) {
        for (int c=1; c<cols; c++) {
            int insertCost = minCost[r][c-1] + 1;
            int deleteCost = minCost[r-1][c] + 1;
            int changeCost = minCost[r-1][c-1] + (cfrom[r] == cto[c])? 0 : 1;
            
            minCost[r][c] = insertCost;
            
            if (deleteCost < minCost[r][c])
                minCost[r][c] = deleteCost;
                
            if (changeCost < minCost[r][c])
                minCost[r][c] = changeCost;
        }
    }
}
