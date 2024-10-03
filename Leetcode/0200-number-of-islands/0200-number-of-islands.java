import java.util.*;

class Tile {
    int x;
    int y;
    char c;

    public Tile(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;


        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }


    private void bfs(char[][] grid, int x, int y) {
        Queue<Tile> q = new LinkedList<Tile>();
        int m = grid.length;
        int n = grid[0].length;
        q.offer(new Tile(x, y, '1'));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Tile tile = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = tile.x + dx[i];
                int newY = tile.y + dy[i];

                if (newX < m && newX >= 0 && newY < n && newY >= 0 && grid[newX][newY] == '1') {
                    q.offer(new Tile(newX, newY, '1'));
                    grid[newX][newY] = '0';
                }
            }
        }
    }

}