import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, K, D;
    static int[][] inputs;
    
    private static int getCount(int a, int b, int c, int mid) {
        int temp = 0;
        if (mid < a) return 0;
        if (mid >= b) temp = (b - a) / c + 1;
        else temp = (mid - a) == 0 ? 1 : (mid - a) / c + 1;

        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        D = sc.nextInt();

        inputs = new int[K][3];
        for (int i = 0; i < K; i++) {
            inputs[i][0] = sc.nextInt(); // A
            inputs[i][1] = sc.nextInt(); // B
            inputs[i][2] = sc.nextInt(); // C
        }

        Arrays.sort(inputs, (a,b) -> Integer.compare(a[2], b[2]));

        int left = 0;
        int right = N;
        
        int a = 0, b = 0, c = 0;
        while (left < right) {
            int mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                a = inputs[i][0];
                b = inputs[i][1];
                c = inputs[i][2];
                cnt += getCount(a, b, c, mid);
            }
            
            if (cnt < D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(right);
    }
}
