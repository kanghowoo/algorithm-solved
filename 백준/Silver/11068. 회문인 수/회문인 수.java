import java.util.*;

public class Main {

    public static boolean isPalindrome(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != nums.get(nums.size() -i -1)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> convertBase(int N, int base) {
        List<Integer> nums = new ArrayList<>();
        while (N > 0) {
            nums.add(N % base);
            N = N / base;
        }

        return nums;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        String[] answers = new String[T];
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();

            for (int j = 2; j <= 64; j++) {
                List<Integer> nums = convertBase(N, j);
                if (isPalindrome(nums)) {
                    answers[i] = "1";
                    break;
                }

                if (j == 64) answers[i] = "0";
            }

        }

        for (String answer : answers) {
            System.out.println(answer);
        }

    }
}
