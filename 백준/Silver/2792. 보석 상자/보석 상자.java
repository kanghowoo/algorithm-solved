import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] nums;
    static int N;
    static int M;
    
    private static int getCount(int mid) {
        int sum = 0;
        
        for (int i = 0; i < M; i++) {
            if (nums[i] % mid == 0) {
                sum += nums[i] / mid;
            } else {
                sum += (nums[i] / mid) + 1;
            }
        }
        
        return sum;
    }
    
    private static int lowerBound(int left, int right, int nStudent) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (getCount(mid) > nStudent) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return right;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[M];
        
        for (int i = 0; i < M; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        System.out.println(lowerBound(1, nums[M - 1], N));
    }
}
