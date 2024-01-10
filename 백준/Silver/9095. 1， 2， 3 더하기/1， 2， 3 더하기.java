import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];
        int[] dp = new int[11];

        for(int i=0; i<t; i++) {
            num[i] = Integer.parseInt(br.readLine());

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j=4; j<11; j++) {
                dp[j] = dp[j-3] + dp[j-2]+ dp[j-1];
            }
        }

        for(int k=0; k<num.length; k++) {
            System.out.println(dp[num[k]]);
        }
    }
}
