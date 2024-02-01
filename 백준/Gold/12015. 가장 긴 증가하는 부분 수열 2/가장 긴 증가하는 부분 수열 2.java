import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int idx = 0;
        int num = 0;
        for (int i = 0; i < N; i++) {
            if (dp[idx] < arr[i]) {
                idx += 1;
                dp[idx] = arr[i];
            } else {
                num = findIndexByBinarySearch(0, idx, arr[i]);
                dp[num] = arr[i];
            }
        }

        System.out.println(idx);

    }

    private static int findIndexByBinarySearch(int left, int right, int target) {
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
