import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]));

        int[] inputs = new int[N];
        int[] memo = new int[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = arr[i][1];
        }

        for (int i = 0; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (inputs[j] < inputs[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        Arrays.sort(memo);
        System.out.println(N - memo[N - 1]);
    }
}
