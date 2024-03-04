import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (num <= 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
        }

        int result = getSum(minus) + getSum(plus);
        System.out.println(result);
        
    }

    private static int getSum(PriorityQueue<Integer> pq) {
        Deque<Integer> nums = new ArrayDeque<>();
        
        while (!pq.isEmpty()) {
            int num1 = pq.poll();

            if (pq.isEmpty()) {
                nums.add(num1);
            } else {
                int num2 = pq.poll();
                if (num1 == 1 || num2 == 1) {
                    nums.add(num1);
                    nums.add(num2);
                } else {
                    nums.add(num1 * num2);
                }
            }
        }
        
        int sum = 0;
        while (!nums.isEmpty()) {
            int num = nums.poll();

            sum += num;
        }
        
        return sum;
    }
}
