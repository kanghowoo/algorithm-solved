import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] delta = new int[N + 2];
        int[] acc = new int[N + 1];

        while (M-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();

            delta[a] += k;
            delta[b + 1] -= k;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i -1] + delta[i];
            bw.write(arr[i] + acc[i] + " ");
        }
        
        bw.write("\n");
        bw.flush();
    }
}
