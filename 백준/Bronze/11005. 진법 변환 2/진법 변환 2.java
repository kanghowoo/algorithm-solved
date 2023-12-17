import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int B = scanner.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();

        String answer = "";
        while (N > 0) {
            int mod = N % B;
            if (mod < 10) answer += mod;
            else answer += (char) ('A' + mod - 10);

            N = N / B;
        }

        for (int i = answer.length() - 1; i >= 0; i--) {
            System.out.print(answer.charAt(i));
        }

    }
}
