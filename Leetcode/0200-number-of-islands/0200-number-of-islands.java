class Tile {
    int x;
    int y;
    int c;

    public Tile(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

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
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Tile> tiles = new ArrayDeque();        
        tiles.offer(new Tile(x, y, '1'));

        while (!tiles.isEmpty()) {
            Tile tile = tiles.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tile.x + dx[i];
                int ny = tile.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == '1') {
                    tiles.offer(new Tile(nx, ny, '1'));
                    grid[nx][ny] = '0';
                }
            }
        }
    }
}