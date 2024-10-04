import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        // Map friend names to indices
        Map<String, Integer> nameToIndex = new HashMap<>();
        for(int i = 0; i < n; i++) {
            nameToIndex.put(friends[i], i);
        }
        
        // Initialize gift counts
        int[][] giftCount = new int[n][n]; // giftCount[i][j]: i gave to j
        int[] totalGiven = new int[n];
        int[] totalReceived = new int[n];
        
        // Process gift history
        for(String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];
            int gi = nameToIndex.get(giver);
            int ri = nameToIndex.get(receiver);
            giftCount[gi][ri]++;
            totalGiven[gi]++;
            totalReceived[ri]++;
        }
        
        // Calculate gift indices
        int[] giftIndex = new int[n];
        for(int i = 0; i < n; i++) {
            giftIndex[i] = totalGiven[i] - totalReceived[i];
        }
        
        // Initialize next month's received gifts
        int[] nextMonthReceived = new int[n];
        
        // Iterate over all pairs
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int giftsItoJ = giftCount[i][j];
                int giftsJtoI = giftCount[j][i];
                
                if(giftsItoJ > giftsJtoI) {
                    // i gave more to j, so j receives a gift
                    nextMonthReceived[i]++;
                } else if(giftsJtoI > giftsItoJ) {
                    // j gave more to i, so i receives a gift
                    nextMonthReceived[j]++;
                } else {
                    // No history or equal gifts, compare gift indices
                    if(giftIndex[i] > giftIndex[j]) {
                        nextMonthReceived[i]++;
                    } else if(giftIndex[j] > giftIndex[i]) {
                        nextMonthReceived[j]++;
                    }
                }
            }
        }
        
        // Find the maximum number of gifts received
        int maxGifts = 0;
        for(int count : nextMonthReceived) {
            if(count > maxGifts) {
                maxGifts = count;
            }
        }
        
        return maxGifts;
    }
}
