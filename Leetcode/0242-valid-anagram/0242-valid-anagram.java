class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (sArr[i] != tArr[i]) return false;
        }

        return true;
    }
}