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

        if (sum <= M) {
            System.out.println(right);
            return;
        }

        int result = 0;
        int mid;
        while (left <= right) {
            long budget = 0;

            mid = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                budget += Math.min(mid, budgets[i]);
            }

            if (M >= budget) {
                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}
