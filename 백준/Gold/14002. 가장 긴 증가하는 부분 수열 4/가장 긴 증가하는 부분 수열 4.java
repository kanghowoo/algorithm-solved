import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        memo = new int[N];
        int len = 0;
        for (int i = 0; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }

            len = Math.max(len, memo[i]);
        }

        System.out.println(len);

        //역추적

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = N - 1; i >= 0 ; i--) {
            if (len == memo[i]) {
                stack.push(arr[i]);
                len--;
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }

}
