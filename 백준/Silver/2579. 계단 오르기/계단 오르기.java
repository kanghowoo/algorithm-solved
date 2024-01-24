import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] dp = new int[N + 1];

        dp[1] = arr[1];
        if (N >= 2) dp[2] = dp[1] + arr[2];

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[N]);
    }
}
