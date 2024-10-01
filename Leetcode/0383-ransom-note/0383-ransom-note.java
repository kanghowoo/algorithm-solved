class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;

        char[] ransomNoteCharArray = ransomNote.toCharArray();
        char[] magazineCharArray = magazine.toCharArray();

        Arrays.sort(ransomNoteCharArray);
        Arrays.sort(magazineCharArray);
        int[] counts = new int[26];

        for(char c : magazineCharArray) {
            counts[c - 'a']++;
        }

        for(char c : ransomNoteCharArray) {
            counts[c - 'a']--;
        }

        for(int num : counts) {
            if (num < 0) return false;
        }

        return true;
    }
}