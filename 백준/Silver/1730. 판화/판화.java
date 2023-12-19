import java.util.Scanner;

public class Main {
    public static void printResult(boolean[][] rowHistories, boolean[][] columnHistories) {
        for (int i = 0; i < rowHistories.length; i++) {
            for (int j = 0; j < rowHistories[i].length; j++) {
                if (rowHistories[i][j] && columnHistories[i][j]) {
                    System.out.print((char)43);
                } else if (rowHistories[i][j] && !columnHistories[i][j]) {
                    System.out.print((char)124);
                } else if (!rowHistories[i][j] && columnHistories[i][j]) {
                    System.out.print((char)45);
                } else {
                    System.out.print((char)46);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] dx = {-1, 0, 1, 0}; //북동남서
        int[] dy = {0, 1, 0, -1}; //북동남서
        char[] types = {'U', 'R', 'D', 'L'};

        String input = scanner.hasNext() ? scanner.next() : "";
        char[] inputs = input.toCharArray();

        boolean[][] rowHistories = new boolean[N][N];
        boolean[][] columnHistories = new boolean[N][N];

        int x = 0;
        int y = 0;

        for (int i = 0; i < inputs.length; i++) {

            for (int j = 0; j < 4; j++) {

                if (inputs[i] == types[j]) {
                    if (x + dx[j] >= 0 && x + dx[j] <= N - 1
                            && y + dy[j] >= 0 && y + dy[j] <= N - 1) {

                        if (j == 0 || j == 2) {
                            rowHistories[x][y] = true;
                        }
                        if (j == 1 || j == 3){
                            columnHistories[x][y] = true;
                        }
                        x = x + dx[j];
                        y = y + dy[j];
                        
                        if (j == 0 || j == 2) {
                            rowHistories[x][y] = true;
                        }
                        if (j == 1 || j == 3){
                            columnHistories[x][y] = true;
                        }

                    }
                }
            }
        }

        printResult(rowHistories, columnHistories);

    }
}
