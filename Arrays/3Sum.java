
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // this is really good problem...

        Arrays.sort(nums);
        List <List<Integer>> res = new ArrayList <>();

        for (int i=0; i < nums.length && nums[i] <= 0; i++){
          // if the nums[i] is > 0, we can skip it because Array is sorted and we can't find the triplet that sums to 0
            if (i==0 || nums[i-1]!= nums[i]) {
                // if the nums[i] is same as previous value skip that 
                twoSumI(nums,i,res);
            }            
        }
        return res;        
    }

    public void twoSumI(int []nums, int i, List <List<Integer>> res) {
        int lo =i+1;
        int hi = nums.length-1;

        while (lo < hi) {
            int sum = nums[i] + nums [lo] + nums [hi];
            if (sum <0) {
                lo++;
            }else if (sum >0) {
                hi--;
            } else {
                List<Integer> al = new ArrayList <>();
                al.add(nums[i]);
                al.add(nums[lo++]);
                al.add(nums[hi--]);
                res.add(al);

                while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
            }

        }
        return;
    }
}
