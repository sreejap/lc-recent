# https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid == null || rows ==0 || cols ==0 || (grid [0][0] !=0) || grid [rows-1][cols-1]!=0 ){
            return -1;
        }


        int [][] directions = new int [][] { {0,1}, {0,-1}, {1,0}, {-1,0}, {1,-1}, {1,1}, {-1,1}, {-1,-1} };
        Queue <int []> bfsQ = new ArrayDeque <>();

        boolean [][]visited = new boolean [rows][cols];

        bfsQ.offer(new int []{0,0});
        visited [0][0] = true;
        int shortestDistance = 1;

        while (!bfsQ.isEmpty()) {
            int qSize = bfsQ.size();

            for (int i=0; i < qSize; i++){
                int [] cell = bfsQ.poll();
                if (cell[0] == rows-1 && cell[1] == cols-1) {
                    return shortestDistance; // we are the end...
                }
                for (int [] dir: directions) {
                    int newRow = cell [0] + dir[0];
                    int newCol = cell [1] + dir[1];
                    if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && grid [newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        bfsQ.offer(new int [] {newRow, newCol});
                        visited [newRow] [newCol] = true;
                    }
                }
            }
            shortestDistance++; // increment here because all nodes at a level are at the same distance
        }
        
        return -1;
    }
}
