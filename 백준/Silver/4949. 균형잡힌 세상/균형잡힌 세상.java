import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while (true) {

            s = br.readLine();

            if (s.equals(".")) { // 종료 조건문
                break;
            }

            sb.append(solution(s)).append('\n');
        }

        System.out.println(sb);
    }

    private static String solution(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int k = 0; k < input.length(); k++) {
            char c = input.charAt(k);

            if (c == '.') break;
            if (c == '(' || c == '[') {
                deque.addLast(c);
            } else if (c == ')') {
                if (deque.isEmpty() || deque.peekLast() != '(') {
                    return "no";
                } else {
                    deque.removeLast();
                }
            } else if (c == ']') {
                if (deque.isEmpty() || deque.peekLast() != '[') {
                    return "no";
                } else {
                    deque.removeLast();
                }
            }
        }

        if (deque.isEmpty()) {
            deque.clear();
            return "yes";
        } else {
            deque.clear();
            return "no";
        }

    }

}
