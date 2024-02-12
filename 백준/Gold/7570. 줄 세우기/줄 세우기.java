import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        memo = new int[N + 1];
        int max = 0;

        for (int i = 0; i < N; i++) {
            memo[arr[i]] = memo[arr[i] - 1] + 1;
            max = Math.max(max, memo[arr[i]]);
        }

        System.out.println(N -max);
    }

}
