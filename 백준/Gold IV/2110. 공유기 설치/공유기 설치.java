import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int C = scanner.nextInt();

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = scanner.nextInt();
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1] - houses[0];
        int answer = 0;
        int dis = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int start = houses[0];
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                dis = houses[i] - start;
                if (dis >= mid) {
                    cnt++;
                    start = houses[i];
                }
            }

            if (cnt >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
