import java.util.Scanner;

public class Main {
    static int[] times;
    static int N;
    static int M;

    private static int getCount(int mid) {
        int num = mid;
        int count = 1;

        for (int i = 0; i < N; i++) {
            if (num < times[i]) {
                num = mid;
                count += 1;
            }
            num -= times[i];
        }

        return count;
    }

    private static int lowerBound(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (getCount(mid) > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int sum = 0;
        int maxValue = 0;

        times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
            sum += times[i];
            if (maxValue < times[i]) {
                maxValue = times[i];
            }
        }

        System.out.println(lowerBound(maxValue, sum, M));
    }
}
