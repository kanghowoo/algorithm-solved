class Solution {
    static int m;
    static int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }

        return result;
    }

    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        grid[x][y] = '0';

        int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}}; //상하좌우

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] dir : directions) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == '1') {
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = '0';
                }
            }
        }

    }
}