import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String[] doc = new String[N];

        for (int i = 0; i < N; i++) {
            doc[i] = scanner.next();
        }

        Arrays.sort(doc, (String s1, String s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }

            else return s1.length() - s2.length();
        });


        System.out.println(doc[0]);
        for (int i = 1 ; i < doc.length; i++) {
            if (!doc[i].equals(doc[i-1])) {
                System.out.println(doc[i]);
            }
        }
    }
}
