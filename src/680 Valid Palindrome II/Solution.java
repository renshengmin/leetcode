class Solution {
    public boolean validPalindrome(String s) {
        return validPalindromeHelper(s, 0, s.length() - 1, 0);
    }

    public boolean validPalindromeHelper(String s, int start, int end, int skip) {
        if(skip > 1) {
            return false;
        }
        if (start >= end) {
            return true;
        }  
        if(s.charAt(start) != s.charAt(end)) {
            return validPalindromeHelper(s, start + 1, end, skip + 1) || validPalindromeHelper(s, start, end - 1, skip + 1);
        } else {
            return validPalindromeHelper(s, start + 1, end - 1, skip);
        }
    }
}
