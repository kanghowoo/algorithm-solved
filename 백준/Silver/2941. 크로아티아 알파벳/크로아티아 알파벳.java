import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] docs = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String input = scanner.next();

        for (int i = 0 ; i < docs.length; i++) {
            input = input.replace(docs[i], "x");
        }

        System.out.println(input.length());


    }
}