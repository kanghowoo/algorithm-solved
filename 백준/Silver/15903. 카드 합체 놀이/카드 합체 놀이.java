import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(scanner.nextLong());
        }

        int cnt = m;

        while (cnt > 0) {
            long a = pq.poll();
            long b = pq.poll();

            long sum = a + b;

            pq.offer(sum);
            pq.offer(sum);

            cnt--;
        }

        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
        
    }
}
