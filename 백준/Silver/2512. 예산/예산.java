import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] budgets = new int[N];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = sc.nextInt();
            sum += budgets[i];
        }

        int M = sc.nextInt();

        Arrays.sort(budgets);

        int left = 1;
        int right = budgets[N - 1];

        int mid;
        int max = 0;
        int result = 0;

        if (sum <= M) {
            System.out.println(right);
            return;
        }

        while (left <= right) {
            mid = (left + right) / 2;

            long total = 0;
            for (int i = 0; i < N; i++) {
                total += Math.min(budgets[i], mid);
            }

            if (total <= M) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }

        }

        System.out.println(max);
    }
}
