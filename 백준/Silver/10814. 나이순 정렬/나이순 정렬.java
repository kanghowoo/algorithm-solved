import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class User implements Comparable<User>{
        int age;
        String name;
        int idx;

        public User(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

        @Override
        public int compareTo(User o) {
            if (age == o.age) {
                return idx - o.idx;
            }
            return age - o.age;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        User[] users = new User[N];
        for (int i = 0; i < N; i++) {
            users[i] = new User(sc.nextInt(), sc.next(), i);
        }

        Arrays.sort(users);

        for (int i = 0; i < N; i++) {
            System.out.println(users[i].age + " " + users[i].name);
        }

    }
}
