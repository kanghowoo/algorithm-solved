import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int result = 1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                String word = queue.poll();
                
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] wordArray = word.toCharArray();                        
                        
                        if (wordArray[j] == c) continue;

                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        if (newWord.equals(endWord)) return result + 1;

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }

            result++;
        }

        return 0;
    }
}