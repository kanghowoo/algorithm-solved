import java.util.*;

class Solution {
    static int m;
    static int n;

    int[][] directions = {{-1,0}, {1,0}, {0, -1} ,{0, 1}}; // 상하좌우
    static boolean valid;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        valid = true;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result += bfs(grid, i, j);
                }
            }
        }

        if (!valid) result = 0;

        return result;

    }

    public int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        grid[x][y] = 0;

        int area = 0;
        boolean valid = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            area++;

            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    valid = false;
                }

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }
        }

        if (!valid) area = 0;

        return area;
    }
}