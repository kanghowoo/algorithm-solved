import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[][] employees = new String[N][2];

        for (int i = 0; i < N; i++) {
            employees[i][0] = sc.next();
            employees[i][1] = sc.next();
        }

        Arrays.sort(employees, (o1, o2) -> o2[0].compareTo(o1[0]));

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                if (employees[i][1].equals("enter")) {
                    System.out.println(employees[i][0]);
                }
                
                break;
            }
            if (!employees[i][0].equals(employees[i+1][0])) {
                if (employees[i][1].equals("enter")) {
                    System.out.println(employees[i][0]);
                }
            }
        }

    }
}
