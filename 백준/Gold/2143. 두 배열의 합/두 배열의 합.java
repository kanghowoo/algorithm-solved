import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int T,n,m;
    static int[] A, B;
    static int[] aSum, bSum;

    private static void getPrefixSum(int[] inputs, int[] sums) {
        int index = 0;

        for (int i = 0; i < inputs.length; i++) {
            int sum = 0;
            for (int j = i; j < inputs.length; j++) {
                sum += inputs[j];
                sums[index] = sum;
                index++;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        n = sc.nextInt();
        A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        m = sc.nextInt();
        B = new int[m];

        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        int aSize = n * (n + 1) / 2;
        int bSize = m * (m + 1) / 2;
        aSum = new int[aSize];
        bSum = new int[bSize];

        getPrefixSum(A, aSum);
        getPrefixSum(B, bSum);

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int left = 0;
        int right = bSize - 1;

        long count = 0;

        while (left < aSize && right > -1) {
            int aTemp = aSum[left];
            int bTemp = bSum[right];
            long sTemp = aTemp + bTemp;

            if (sTemp == T) {
                long aCount = 0, bCount = 0;

                while (left < aSize && aTemp == aSum[left]) {
                    left++;
                    aCount++;
                }

                while (right > -1 && bTemp == bSum[right]) {
                    right--;
                    bCount++;
                }

                count += aCount * bCount;

            } else if (sTemp > T) {
                right--;
            } else if (sTemp < T) {
                left++;
            }
        }

        System.out.println(count);
    }
}
