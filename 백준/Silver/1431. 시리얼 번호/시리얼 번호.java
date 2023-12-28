import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        String[] guitars = new String[N];

        for (int i = 0; i < N; i++) {
            guitars[i] = scanner.next();
        }

        Arrays.sort(guitars, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return getSortGuitarWhenSameLength(o1, o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(guitars[i]);
        }
    }

    private static int getSortGuitarWhenSameLength(String o1, String o2) {
        int sumA = 0;
        for (int i = 0; i < o1.length(); i++) {
            if (Character.isDigit(o1.charAt(i))) {
                sumA += o1.charAt(i) - '0';
            }
        }

        int sumB = 0;

        for (int i = 0; i < o2.length(); i++) {
            if (Character.isDigit(o2.charAt(i))) {
                sumB += o2.charAt(i) - '0';
            }
        }

        if (sumA == sumB) return o1.compareTo(o2);
        else return sumA - sumB;

    }
}
