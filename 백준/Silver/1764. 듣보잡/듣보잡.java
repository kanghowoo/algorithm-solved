import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.next());
        int M = Integer.parseInt(scanner.next());

        Set<String> set = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            set.add(scanner.nextLine());
        }

        List<String> results = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            String temp = scanner.nextLine();
            if (!set.add(temp)) {
                results.add(temp);
            }
        }

        Collections.sort(results);
        System.out.println(results.size());
        for (String result : results) {
            System.out.println(result);
        }

    }
}
