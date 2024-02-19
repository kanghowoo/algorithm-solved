import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        int[] nums = new int[M];

        for (int i = 0; i < M; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append(upperBound(cards, nums[i]) - lowerBound(cards, nums[i])).append(' ');
        }

        System.out.println(sb);
    }
    
    private static int upperBound(int[] cards, int target) {
        int left = 0;
        int right = cards.length;
        int mid;
        
        while (left < right) {
            mid = (left + right) / 2;

            if (target < cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private static int lowerBound(int[] cards, int target) {
        int left = 0;
        int right = cards.length;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (target <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
}
