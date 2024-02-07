import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] front = new int[N];

        for (int i = 0; i < N; i++) {
            front[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    front[i] = Math.max(front[i], front[j] + 1);
                }
            }
        }

        int[] back = new int[N];
        
        for (int i = N - 1; i >= 0 ; i--) {
            back[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    back[i] = Math.max(back[i], back[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, front[i] + back[i] - 1);
        }

        System.out.println(max);

    }
}
