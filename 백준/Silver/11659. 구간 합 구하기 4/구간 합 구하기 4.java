import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N + 1];
        int[] acc = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = scanner.nextInt();

            acc[i] = acc[i - 1] + arr[i];
        }

        int[] results = new int[M];

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            results[i] = acc[b] - acc[a - 1];
        }

        for (int i = 0; i < M; i++) {
            System.out.println(results[i]);
        }
    }
}
