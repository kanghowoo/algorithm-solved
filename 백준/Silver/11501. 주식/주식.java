import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int N; // 2<= N <= 1,000,000
        int[] arr;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            N = scanner.nextInt();
            arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = scanner.nextInt();
            }

            int max = arr[N - 1];
            long amount = 0;

            for (int j = N - 2; j >= 0; j--) {
                if (arr[j] < max) {
                    amount += max - arr[j];
                } else {
                    max = arr[j];
                }
            }
            
            sb.append(amount + "\n");
        }

        System.out.println(sb);
    }
}
