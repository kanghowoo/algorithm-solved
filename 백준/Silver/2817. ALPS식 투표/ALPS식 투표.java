import java.util.*;

class Chip {
    private String name;
    private double score;

    public Chip(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt(); //참가자수
        int N = sc.nextInt(); //스태프수

        List<Chip> chips = new ArrayList<>();

        boolean[] valid = new boolean[26];
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int votes = sc.nextInt();

            if ( X * 0.05 <= votes) {
                valid[name.charAt(0) - 65] = true;
            }
            for (int j = 0; j < 14; j++) {
                chips.add(new Chip(name, (double) votes / (j + 1)));
            }
        }

        chips.sort((o1, o2) -> {
            if (o1.getScore() - o2.getScore() < 0) {
                return 1;
            } else return -1;
        });

/*        for (Chip chip : chips) {
            System.out.println(chip.getName() + ": " + chip.getScore());
        }*/

        int[] results = new int[26];

        for (int i = 0; i < 14; i++) {
            results[chips.get(i).getName().charAt(0) - 65]++;
        }

        for (int i = 0; i < 26; i++) {
            if (valid[i]) {
                System.out.println((char)(i + 'A') + " " + results[i]);
            }
        }

    }
}
