import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] xs = new int[N][2];

        for (int i = 0; i < N; i++) {
            xs[i][0] = scanner.nextInt();
            xs[i][1] = i;
        }

        Arrays.sort(xs, Comparator.comparingInt(o -> o[0]));

        int[] results = new int[N];
        int cnt = 0;
        results[xs[0][1]] = cnt;
        for (int i = 1; i < N; i++) {
            if (xs[i][0] != xs[i - 1][0]) {
                results[xs[i][1]] = ++cnt;
            } else {
                results[xs[i][1]] = cnt;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(results[i] + " ");
        }

        bw.write("\n");
        bw.flush();
    }
}
