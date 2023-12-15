import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int X = scanner.nextInt();

        boolean[] exist = new boolean[10000001];
        for (int i = 0; i < N; i++) {
            exist[arr[i]] = true;
        }
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            int num = X - arr[i];
            if (0 <= num && num <= 1000000) {
                result += exist[num] ? 1 : 0;
            }
        }

        System.out.println(result / 2);
        
    }
}
