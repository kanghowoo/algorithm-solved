import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Stack stack = new Stack();
		
		String[] str1 = scanner.nextLine().split("\\-");
		
		String[] str2;
		
		
		int result = 0;
		
		for(int i=0; i<str1.length; i++) {
			int subNum = 0;
			str2 = str1[i].split("\\+");
			
			for(int j=0; j<str2.length; j++) {
				subNum += Integer.parseInt(str2[j]);
			}
			
			if(i==0) subNum *= -1;
			
			
			result += subNum*-1;
			//System.out.println("result:"+result);
			
		}
		
		System.out.println(result);
		
	}

}