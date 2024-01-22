import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int INT = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        long[] dp = new long[1001];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < num + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = (2 * (dp[i - 1] - 1) + 3) % INT;
            } else {
                dp[i] = (2 * (dp[i - 1] - 1) + 1) % INT;
            }
        }

        System.out.println(dp[num]);
    }
}
