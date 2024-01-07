import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        dp = new Integer[n+1];

        dp[0] = dp [1] = 0;

        System.out.print(funcA(n));

    }

    static int funcA(int n) {
        if ( dp[n] == null ) {
            if ( n % 6 == 0 ) {
                dp[n] = Math.min(funcA(n - 1), Math.min(funcA(n / 2 ), funcA(n/ 3))) + 1;
            }

            else if ( n % 3 == 0 ) {
                dp[n] = Math.min(funcA(n / 3), funcA(n -1)) + 1;
            }

            else if ( n % 2 == 0 ) {
                dp[n] = Math.min(funcA( n / 2 ), funcA( n - 1)) + 1;
            }

            else {
                dp[n] = funcA( n - 1 ) + 1;
            }
        }

        return dp[n];
    }
}
