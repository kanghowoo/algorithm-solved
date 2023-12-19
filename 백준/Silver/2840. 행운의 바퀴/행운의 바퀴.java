import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] nums = new int[K];
        char[] inputs = new char[K];
        char[] result = new char[N];

        for (int i = K - 1; i >= 0; i--) {
            nums[i] = scanner.nextInt();
            inputs[i] = scanner.next().charAt(0);
        }

        for (int i = 0; i < N; i++) {
            result[i] = '?';
        }

        int nth = 0;
        for (int i = 0; i < K; i++) {
            if (nth > N - 1) {
                nth = nth - N;
            }

            if (result[nth] != '?' && inputs[i] != result[nth]) {
                System.out.println("!");
                return;
            }

            result[nth] = inputs[i];

            if (N - nums[i] < 0) {
                nth = nth + nums[i] % N;
            } else {
                nth = nth + nums[i];
            }
        }

        //중복확인 세팅
        int[] alphabets = new int[26];
        for (int i = 0; i < N; i++) {
            if (result[i] == '?') continue;
            alphabets[result[i] - 65]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            //중복이면 종료
            if (alphabets[i] > 1) {
                System.out.println("!");
                return;
            }

            sb.append(result[i]);
        }

        System.out.println(sb);

    }
}
