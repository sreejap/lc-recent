// https://leetcode.com/problems/longest-arithmetic-subsequence
/**
* Time & Space Complexity:
* Time: O(n²) (all pairs of elements)
* Space: O(n²) worst case (every index could have many differences)
* Array of HashMaps syntax:
  * `HashMap<Integer, Integer>[] dp = new HashMap[nums.length];`  // ✅ Correct
  * Do NOT write `new HashMap<>()[nums.length]` — this is invalid.
* Do not re-initialize `dp[right]` inside the inner loop:
  * Initialize once per outer loop iteration, not for each left.
  * Re-initializing wipes out previously computed sequences.
* Use `dp[left]` to extend sequences, not `dp[right]` yet.
* Nested loop direction:
  * Outer loop = `right` → current index being processed.
  * Inner loop = `left` → all previous indices.
  * Ensures sequences ending at `left` are fully computed before extending to `right`.
**/
class Solution {
    public int longestArithSeqLength(int[] nums) {
        // this is DP question
        
        int maxLength = 0;
        HashMap <Integer,Integer>[] dp = new HashMap[nums.length]; // get this syntax correct
        // dp[i] - HashMap for that ending index position, each diff -> len tells us how long
        // the arithmetic subsequence is, if it ends at index i in nums, and has the common difference - diff
        for (int right = 0; right < nums.length; right++) {
            dp [right] = new HashMap <>();
            for (int left =0; left < right; left++){
                int diff = nums [right] - nums [left];               
                
                dp[right].put(diff,dp[left].getOrDefault(diff,1)+1);
                
                
                maxLength = Math.max(maxLength, dp[right].get(diff));
            }
        }
        
        return maxLength;
    }
}
