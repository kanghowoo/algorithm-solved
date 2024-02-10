import java.util.*;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        memo = new int[N];
        memo[0] = arr[0][1];

        int len = 1;
        int idx = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            if (memo[len - 1] < arr[i][1]) {
                memo[len] = arr[i][1];
                len += 1;
                dp[i] = len;
            } else {
                idx = findBinarySearch(0, len, arr[i][1]);
                memo[idx] = arr[i][1];
                dp[i] = idx + 1;
            }
        }

        System.out.println(N - len);

        //역추적
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N - 1; i >= 0 ; i--) {
            if (len != dp[i]) {
                deque.push(arr[i][0]); //A 전봇대 위치 기준
            } else {
                len--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop() + "\n");
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
