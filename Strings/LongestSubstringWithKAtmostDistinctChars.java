// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int left = 0;
        int maxLen = 0;

        Map <Character,Integer> charCounts = new HashMap <>();
        for (int right=0; right < len; right++) {
            char c = s.charAt(right);
            int count = charCounts.getOrDefault(c,0);
            charCounts.put(c, count+1);

            while (charCounts.size() > k) {
                char leftChar = s.charAt(left);
                int leftCharCount = charCounts.get(leftChar);
                charCounts.put(leftChar,leftCharCount-1);
                if (charCounts.get(leftChar) == 0) {
                    charCounts.remove (leftChar);
                }
                left++;
            }
            
            maxLen = Math.max (maxLen, right - left +1);
        }
        return maxLen;
    }
}
