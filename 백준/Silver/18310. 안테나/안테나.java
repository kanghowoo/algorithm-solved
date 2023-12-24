import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        System.out.println(nums[(N - 1)/2]);

    }
}
