import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // O(N)
        if (!wordSet.contains(endWord)) return 0; // O(1)

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); // O(1)
        int level = 1;

        while (!queue.isEmpty()) { // 최대 O(N) 반복
            int size = queue.size(); // O(1)
            
            for (int i = 0; i < size; i++) { // 최대 O(N) 반복
                String word = queue.poll(); // O(1)

                for (int j = 0; j < word.length(); j++) { // O(L) (L = 단어 길이)
                    char[] wordArray = word.toCharArray(); // O(L)
                    
                    for (char c = 'a'; c <= 'z'; c++) { // O(26)
                        if (wordArray[j] == c) continue; // O(1)
                        
                        wordArray[j] = c;
                        String newWord = new String(wordArray); // O(L)

                        if (newWord.equals(endWord)) return level + 1; // O(L)
                        
                        if (wordSet.contains(newWord)) { // O(1)
                            queue.offer(newWord); // O(1)
                            wordSet.remove(newWord); // O(1)
                        }
                    }
                }
            }
            level++; 
        }
        return 0;
    }
}