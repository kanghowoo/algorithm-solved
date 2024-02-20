import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int findOptimalValue(int[] arr, int start, int end, int value) {
        int l = start;
        int r = end;
        int optimalValue = 0;
        int optimalAbs = 2000000000;
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = value + arr[m];
            int sumAbs = Math.abs(sum);
            if (optimalAbs > sumAbs) {
                optimalAbs = sumAbs;
                optimalValue = arr[m];
            }

            if (sum < 0) l = m + 1;
            else if (sum > 0) r = m - 1;
            else return arr[m];
        }

        return optimalValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int minAbs = 2000000000;
        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < N - 1; i++) {
            int pairValue = findOptimalValue(arr, i + 1, N - 1, arr[i]);
            int sumAbs = Math.abs(arr[i] + pairValue);
            if (minAbs > sumAbs) {
                minAbs = sumAbs;
                answer1 = arr[i];
                answer2 = pairValue;
            }
        }

        System.out.println(answer1 + " " + answer2);

    }
}
