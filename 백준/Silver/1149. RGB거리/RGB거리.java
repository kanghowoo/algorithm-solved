import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N + 1][4];
        int[][] dp = new int[N + 1][4];  // 1 빨 2 초 3 파

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 4; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        dp[1][3] = arr[1][3];

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < 4; j++) {
                if (j == 1) dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + arr[i][j];
                if (j == 2) dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + arr[i][j];
                if (j == 3) dp[i][j] = Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]) + arr[i][j];
            }
        }

        System.out.println(Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3])));

    }
}
