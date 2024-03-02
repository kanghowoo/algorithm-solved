import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int result = 0;

        for (int i = 0; i < N; i++) {
            int num = arr[i] * (N - i);
            result = Math.max(result, num);
        }

        System.out.println(result);
    }
}
