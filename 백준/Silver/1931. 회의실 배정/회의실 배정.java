import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node implements Comparable<Node>{
	
	private int start;
	private int end;
	
	public Node(int start,int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getEnd() {
		return end;
	}
	public int getStart() {
		return start;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public int compareTo(Node o) {
		if(this.getEnd() < o.getEnd()) {
			return -1;
		}else if(this.getEnd() == o.getEnd() && this.getStart() < o.getStart()) {
			return -1;
		}else if(this.getEnd() == o.getEnd() && this.getStart() > o.getStart()) {
			return 1;
		}else if(this.getEnd() > o.getEnd()){
			return 1;
		}
		return 0;
	}
}

public class Main {

	public static ArrayList<Node> arr = new ArrayList<Node>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		for(int i=0; i<n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			arr.add(new Node(a,b));
			
		}
		
		Collections.sort(arr); // 종료시간 오름차순
		
		int num = -1;
		int count = 0;
		for(int i=0; i<n; i++) {
			// 다음 시작이 이전 종료보다 클때

			if(arr.get(i).getStart() >= num) {
				num = arr.get(i).getEnd();
				count += 1;
			}

		}
		
		System.out.println(count);

	}

}