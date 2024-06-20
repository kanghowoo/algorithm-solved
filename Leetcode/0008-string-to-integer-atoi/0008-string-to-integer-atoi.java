class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        
        int result = 0;

        boolean isNegative = false;
        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                isNegative = true;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
        }

        while (index < s.length()) {
            if (!Character.isDigit(s.charAt(index))) break;
            int digit = s.charAt(index) - '0';

            //overflow 되기 전 체크 (result가 214748365라고 가정)
            //result    = 214748365 
            //MAX_VAVUE = 2147483647
            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && (digit > Integer.MAX_VALUE % 10))) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = (result * 10) + digit;
            index++;
        }

        return isNegative ? -result : result;
    }
}
