import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        dp[0][0] = arr[0][0];
        int result = dp[0][0];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}
