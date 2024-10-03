import java.util.*;

class Tile {
    int x;
    int y;
    
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Solution {
    static int m;
    static int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // 1. 경계에 있는 'O'에 대해서 BFS 탐색
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        // 2. 내부의 'O'를 'X'로 변경하고, '#'로 바꾼 부분을 다시 'O'로 복구
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // 내부 'O'는 'X'로 변경
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // 경계와 연결된 'O'는 다시 복구
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {
        Queue<Tile> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        board[x][y] = '#';
        q.offer(new Tile(x,y));

        while (!q.isEmpty()) {
            Tile tile = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = tile.x + dx[i];
                int newY = tile.y + dy[i];
                if (isNotEdge(newX, newY) && board[newX][newY] == 'O') {
                    board[newX][newY] = '#';
                    q.offer(new Tile(newX, newY));
                }
            }

        }
    }

    private boolean isNotEdge(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n; 
    }
}