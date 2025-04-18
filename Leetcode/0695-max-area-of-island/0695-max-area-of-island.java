import java.util.*;

class Solution {
    static int m;
    static int n;

    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    result = Math.max(result, area);
                }
            }
        }

        return result;
    }

    public int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        int area = 0;

        grid[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] direction: directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }

            area++;

        }

        return area;
        
    }
}