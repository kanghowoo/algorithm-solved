import java.util.*;

class Orange{
    int x;
    int y;
    int mins;

    public Orange(int x, int y, int mins) {
        this.x = x;
        this.y = y;
        this.mins = mins;
    }
    
}

class Solution {
    public int orangesRotting(int[][] grid) {
        //서, 북, 동, 남
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int freshCnt = 0;

        Queue<Orange> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCnt++;
                }

                if (grid[i][j] == 2) {
                    q.offer(new Orange(i, j, 0));
                }
            }
        }

        if (q.isEmpty() && freshCnt == 0) {
            return 0;
        }

        int maxMins = 0;

        while (!q.isEmpty()) {
            Orange orange = q.poll();

            maxMins = Math.max(maxMins, orange.mins);

            for (int i = 0; i < 4; i++) {
                int nextX = orange.x + dx[i];
                int nextY = orange.y + dy[i];

                if (nextX >= 0 && nextY < grid[0].length && nextX < grid.length && nextY >= 0 && grid[nextX][nextY] == 1) {
                    q.offer(new Orange(nextX, nextY, orange.mins + 1));

                    freshCnt--;
                    grid[nextX][nextY] = 2;
                }
            }
        }

        if (freshCnt > 0) return -1;

        return maxMins;
        
    }
}