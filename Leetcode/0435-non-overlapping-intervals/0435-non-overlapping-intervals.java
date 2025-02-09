import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int count = 0;
        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (cur[1] > next[0]) {
                count++;
                cur[1] = Math.min(cur[1], next[1]);
            } else {
                cur[1] = next[1];
            }

            System.out.println("cur[0] : " + cur[0] + " cur[1] : " + cur[1] + " count: " + count);
        }

        return count;

    }
}