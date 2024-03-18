class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
 
        while(true){
            n++;

            int nextCount = Integer.bitCount(n);
            // n의 1의 갯수와 일치하는 수
            if(count == nextCount){
                answer = n;
                break;
            }
        }
        return answer;
    }
}