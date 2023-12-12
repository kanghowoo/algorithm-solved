import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        char[] array = input.toCharArray();

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        sb.append(array);
        sb.reverse();

        System.out.println(sb);
    }
}
