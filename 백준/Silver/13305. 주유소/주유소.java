import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long[] cities = new long[N];
        long[] distances = new long[N-1];

        for (int i = 0; i < N - 1; i++) {
            distances[i] = scanner.nextLong();
        }

        for (int i = 0; i < N; i++) {
            cities[i] = scanner.nextLong();
        }

        long amount = 0;
        long min = cities[0];

        for (int i = 0; i < N - 1; i++) {
            if (cities[i] < min) {
                min = cities[i];
            }
            
            amount += min * distances[i];
        }

        System.out.println(amount);
    }
}
