import java.util.Scanner;

public class Main {
    static int[][] getPrefixSum(char[][] map) {
        int[][] acc = new int[map.length][map[0].length];
        for (int i = 1; i <= map.length - 1; i++) {
            for (int j = 1; j <= map[0].length - 1; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1]
                        + (map[i][j] == '*' ? 1 : 0);
            }
        }
        return acc;
    }

    static int getRangeSum(int[][] acc, int r, int c, int K) {
        int x1 = Math.max(r - K, 1);
        int y1 = Math.max(c - K, 1);
        int x2 = Math.min(r + K, acc.length - 1);
        int y2 = Math.min(c + K, acc[0].length - 1);

        return acc[x2][y2] - acc[x2][y1 - 1] - acc[x1 - 1][y2] + acc[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        char[][] map = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String row = sc.next();
            for (int j = 1; j <= M; j++) {
                map[i][j] = row.charAt(j - 1);
            }
        }

        while (T-- > 0) {
            int[][] acc = getPrefixSum(map);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(acc, i, j, K);
                    if (map[i][j] == '*') {
                        nearAlive--;
                        if (nearAlive < A || nearAlive > B) {
                            map[i][j] = '.';
                        }
                    } else if (A < nearAlive && nearAlive <= B){
                        map[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.printf("%s",map[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
