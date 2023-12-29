import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int C = scanner.nextInt();

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        Integer[] freqs = map.keySet().toArray(Integer[]::new);

        Arrays.sort(freqs, (o1, o2) -> map.get(o2) - map.get(o1));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int freq : freqs) {
            int cnt = map.get(freq);
            for (int i = 0; i < cnt; i++) {
                bw.write(freq+ " ");
            }
        }
        bw.write("\n");
        bw.flush();
    }
}
