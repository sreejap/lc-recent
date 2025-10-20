// https://leetcode.com/problems/permutation-in-string
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        for (int i=0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            
            if (s1.indexOf(ch)!=-1) {
                int end = i + len1;
                if (end <= len2) {
                    String sub = s2.substring(i, end);
                    char [] chars1 = s1.toCharArray();
                    char [] chars2 = sub.toCharArray();

                    Arrays.sort(chars1);
                    Arrays.sort(chars2);

                    if (Arrays.equals(chars1,chars2)) {
                        return true;
                    }
                }
            }
        }
        
        return false;        
    }
}
