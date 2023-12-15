import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            arr[i] = input.toCharArray();
        }

        int rowCnt = 0;
        int colCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'X') break;
                if (j == M - 1 && arr[i][j] != 'X') rowCnt++;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 'X') break;
                if (j == N - 1 && arr[j][i] != 'X') colCnt++;
            }
        }

        System.out.println(Math.max(rowCnt, colCnt));

    }
}
