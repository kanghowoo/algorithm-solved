import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println(solution(scanner.next()));
        }
    }

    private static String solution(String next) {

        Deque deque = new ArrayDeque();

        for (int i = 0 ; i < next.length(); i++) {
            char c = next.charAt(i);

            if (c == '(') {
                deque.addLast(c);
            }

            if (c == ')' && deque.isEmpty()) {
                return "NO";
            }

            if (c == ')') deque.pop();
        }

        if (deque.isEmpty()) {
            return "YES";
        }

        return "NO";

    }
}
