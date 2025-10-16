class Solution {
    public void rotate(int[] nums, int k) {
        // reverse all the elements
        // then reverse the first k
        // reverse the next k

        // edge cases

        if (nums.length <=1) {
            return ;
        }
        // handle the input
        k %= nums.length; // this will ensure that k is always within the bounds of the array length, so we don't end up trying to rotate more times than needed
        reverse (nums,0,nums.length-1);
        reverse (nums,0,k-1);
        reverse (nums,k,nums.length-1);        
    }

    public void reverse ( int [] nums, int start, int end) {
        // edge case, k could be mroe than length of n
        int i = start;
        int j = end;

        while (i < j) {
            int temp = nums [i];
            nums [i] = nums [j];
            nums [j] = temp;
            i++;
            j--;
        }
    }
}
