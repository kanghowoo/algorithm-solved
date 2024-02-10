import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int[] info = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        memo = new int[N];
        memo[0] = arr[0];
        info[0] = 1;

        int len = 1;
        int idx;

        for (int i = 0; i < N; i++) {
            if (memo[len - 1] < arr[i]) {
                memo[len] = arr[i];
                len += 1;
                info[i] = len;
            } else {
                idx = findBinarySearch(0, len, arr[i]);
                memo[idx] = arr[i];
                info[i] = idx + 1;
            }
        }

        System.out.println(len);

        //역추척

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {
            if (len == info[i]) {
                deque.push(arr[i]);
                len--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop() + " ");
        }
        System.out.println(sb);
    }

    static int findBinarySearch(int left, int right, int target) {
        int mid;
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
