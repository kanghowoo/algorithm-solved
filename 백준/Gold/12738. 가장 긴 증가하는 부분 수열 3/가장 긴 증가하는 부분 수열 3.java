import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        memo = new int[N];
        memo[0] = arr[0];

        int len = 1;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            memo[i] = arr[i];
            if (memo[len - 1] < arr[i]) {
                memo[len] = arr[i];
                len += 1;
            } else {
                idx = findByBinarySearch(0, len, arr[i]);
                memo[idx] = arr[i];
            }
        }

        System.out.println(len);
    }

    private static int findByBinarySearch(int left, int right, int target) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (memo[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
