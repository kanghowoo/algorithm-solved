import java.util.Scanner;

public class Main {
    public static int findMaxRow(char[][] arr) {
        int N = arr.length;
        int maxRow = 0;
        for (int r = 0; r < N; r++) {
            int len = 1;
            for (int c = 1; c < N; c++) {
                if (arr[r][c] == arr[r][c - 1]) {
                    len++;
                } else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }

        return maxRow;
    }

    public static int findMaxColumn(char[][] arr) {
        int N = arr.length;
        int maxColumn = 0;
        for (int c = 0; c < N; c++) {
            int len = 1;
            for (int r = 1; r < N; r++) {
                if (arr[r][c] == arr[r -1][c]) {
                    len++;
                } else {
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }

        return maxColumn;
    }

    public static void swapCandy(char[][] arr, int r1, int c1, int r2, int c2) {
        char temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    swapCandy(arr, i, j, i, j + 1);
                    ans = Math.max(ans,Math.max(findMaxColumn(arr), findMaxRow(arr)));
                    swapCandy(arr, i, j, i, j + 1);
                }

                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    swapCandy(arr, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxColumn(arr), findMaxRow(arr)));
                    swapCandy(arr, i, j, i + 1, j);
                }
            }
        }

        System.out.println(ans);


    }
}
