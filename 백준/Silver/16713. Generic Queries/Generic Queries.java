import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        int[] arr = new int[N + 1];
        int[] acc = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = scanner.nextInt();
            acc[i] = acc[i - 1] ^ arr[i];
        }

        int[] xors = new int[Q];

        for (int i = 0; i < Q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            xors[i] = acc[b] ^ acc[a - 1];
        }

        int result = xors[0];
        for (int i = 1; i < Q; i++) {
            result = xors[i] ^ result;
        }

        System.out.println(result);
    }
}
