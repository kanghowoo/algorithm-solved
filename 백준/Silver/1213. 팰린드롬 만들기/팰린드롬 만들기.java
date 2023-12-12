import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] alphabets = new int[26];

        String input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            alphabets[input.charAt(i) - 65]++;
        }

        StringBuilder front = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder end = new StringBuilder();
        int cnt = 0;
        for (int j = 0; j < alphabets.length; j++) {
            if (alphabets[j] != 0) {
                for (int k = 0; k < alphabets[j] / 2; k++) {
                    front.append((char)('A' + j));
                }
            }

            if (alphabets[j] % 2 == 1) {
                mid.append((char)('A' + j));
                cnt++;
            }
        }

        StringBuilder result = new StringBuilder();

        if (cnt >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            System.out.println(result.append(front).append(mid).append(front.reverse()));
        }

    }
}
