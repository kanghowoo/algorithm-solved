import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] nArray;
    static boolean determination(long H) {
        int sum = 0;
        for(int i=1; i<=K; i++) {
            sum += nArray[i] / (int)H;
        }

        return sum >= N;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long answer = 0;

        nArray = new int[K+1];

        for(int i=1; i<=K; i++) {
            nArray[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nArray);

        long L = 1;
        long R = Integer.MAX_VALUE;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (determination(mid)) {
                answer = mid;
                L = mid+1;
            } else {
                R = mid-1;
            }
        }

        System.out.println(answer);

    }
}