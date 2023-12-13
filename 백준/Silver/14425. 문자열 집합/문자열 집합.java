import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean isExist(String[] docs, String target) {
        int l = 0;
        int r = docs.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (docs[m].compareTo(target) < 0) l = m + 1;
            else if (docs[m].compareTo(target) > 0) r = m - 1;
            else return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        String[] docs = new String[N];
        for (int i = 0; i < N; i++) {
            docs[i] = scanner.next();
        }

        Arrays.sort(docs);

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String input = scanner.next();

            boolean isExist = isExist(docs, input);

            if (isExist) cnt++;
        }

        System.out.println(cnt);
    }
}
