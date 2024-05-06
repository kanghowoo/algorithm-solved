import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] costs = new int[N];

        for (int i = 0; i < N; i++) {
            costs[i] = scanner.nextInt();
        }

        int left = 1, right = N * 10_000, answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(costs, mid, M)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
       
        System.out.println(answer);

    }

    private static boolean isPossible(int[] costs, int mid, int m) {
        int count = 1;
        int amount = mid;

        for (int cost : costs) {
            if (cost > mid) return false;
            if (amount < cost) {
                if (count == m) return false;
                count++;
                amount = mid;
            }
            
            amount -= cost;
        }
        
        return true;
    }
}
