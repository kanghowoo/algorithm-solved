import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int L = scanner.nextInt();

        int[] stations = new int[N + 2];

        for (int i = 1; i < N + 1; i++) {
            stations[i] = scanner.nextInt();
        }
        stations[0] = 0;
        stations[N + 1] = L;

        Arrays.sort(stations);

        int left = 1;
        int right = L;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            int count = 0;
            for (int i = 1; i < N+ 2; i++) {
                count += (stations[i] - stations[i - 1] - 1) / mid;
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
