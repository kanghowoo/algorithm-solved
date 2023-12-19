import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int H = Integer.parseInt(scanner.next());
            int W = Integer.parseInt(scanner.next());
            int N = Integer.parseInt(scanner.next());

            int distance = ((N - 1) / H) + 1;
            int floor = ((N - 1) % H) + 1;

            int ans = floor * 100 + distance;

            System.out.println(ans);

        }
    }
}
