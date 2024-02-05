import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int[] asc = new int[N];
		int[] desc = new int[N];
		
		
		for (int i = N-1; i >= 0; i--) {
			asc[i] = 1;
			desc[i] = 1;
			for (int j = N-1; j >i; j--) {
				
				// 오름차순 수열
				if(numbers[i] >numbers[j]) {
					asc[i] = Math.max(asc[i], asc[j] + 1);
				}
				
				// 내림차순 수열
				if(numbers[i] < numbers[j]) {
					desc[i] = Math.max(desc[i], desc[j]+1);
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		if(N ==0) {
			result = 0;
		}else {
			for (int i = 0; i < N; i++) {
				result = Math.max(result, asc[i] + desc[i] - 1);
			}			
		}
		System.out.println(result);
		
	}

}
