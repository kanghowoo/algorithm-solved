import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int s = 0, e = N-1;
        int min = Integer.MAX_VALUE;
        int ansS = 0, ansE = 0;
        while (s < e) {
            int sum = Math.abs(arr[e]+arr[s]);
            if (sum < min) {
                min = sum;
                ansS = s;
                ansE = e;
            }
            if (sum == 0)
                break;

            if (arr[e]+arr[s] > 0) e--;
            else s++;
        }

        System.out.println(arr[ansS] + " " + arr[ansE]);

    }
}
