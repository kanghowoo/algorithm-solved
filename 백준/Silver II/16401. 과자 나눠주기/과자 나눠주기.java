import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] snacks = new int[N];

        for (int i = 0; i < N; i++) {
            snacks[i] = scanner.nextInt();
        }

        Arrays.sort(snacks);

        int left = 1;
        int right = snacks[N - 1];
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (snacks[i] >= mid) {
                    cnt += snacks[i] / mid;
                }
            }

            if (cnt >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
