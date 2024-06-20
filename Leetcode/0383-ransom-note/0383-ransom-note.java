class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counters = new int[26];

        char[] ransomChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();

        if (ransomChars.length > magazineChars.length) return false;

        for (int i = 0; i < ransomChars.length; i++) {
            counters[ransomChars[i] - 'a']++;
        }

        for (int i = 0; i < magazineChars.length; i++) {
            counters[magazineChars[i] - 'a']--;
        }

        for (int num : counters) {
            if (num > 0) return false;
        }

        return true;
    }
}
