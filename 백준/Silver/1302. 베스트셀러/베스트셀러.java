import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] books = new String[N];

        for (int i = 0; i < N; i++) {
            books[i] = sc.next();
        }

        Arrays.sort(books);

        int max = 1;
        int cnt = 1;
        String now = books[0];
        String best = now;
        for (int i = 1; i < N; i++) {
            if (now.equals(books[i])) {
                cnt+=1;

                if (i == N - 1) {
                    if (max < cnt) {
                        best = now;
                    }
                }
            } else {
                if (max < cnt) {
                    max = cnt;
                    best = now;
                }

                cnt = 1;
            }

            now = books[i];
        }

        System.out.println(best);

    }
}
