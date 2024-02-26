import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr1 = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        
        int M = sc.nextInt();
        int[] arr2 = new int[M];

        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);

        int[] results = new int[M];

        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;

                if (arr1[mid] < arr2[i]) {
                    left = mid + 1;
                } else if (arr1[mid] > arr2[i]) {
                    right = mid - 1;
                } else {
                    results[i]++;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(results[i] + " ");
        }

        System.out.println(sb);

    }
}
