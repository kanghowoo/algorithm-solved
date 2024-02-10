import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String doc = scanner.nextLine();
        String word = scanner.nextLine();

        int startIndex = 0;
        int answer = 0;

        while (true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0) break;
            
            startIndex = findIndex + word.length();
            answer++;
        }

        System.out.println(answer);

    }
}
