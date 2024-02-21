import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }

        Arrays.sort(trees);

        int left = 0;
        int right = 1_000_000_000;
        int mid, result = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    total += trees[i] - mid;
                }
            }

            if (total >= M) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(result);

    }
}
