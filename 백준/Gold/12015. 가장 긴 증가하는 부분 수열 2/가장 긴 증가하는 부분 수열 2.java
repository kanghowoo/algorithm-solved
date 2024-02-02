import java.util.Scanner;

public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        dp = new int[N];
        dp[0] = arr[0];

        int len = 1;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (dp[len - 1] < arr[i]) {
                dp[len] = arr[i];
                len += 1;
            } else {
                idx = searchIndex(0, len, arr[i]);
                dp[idx] = arr[i];
            }
        }

        System.out.println(len);
    }

    private static int searchIndex(int left, int right, int target) {
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
