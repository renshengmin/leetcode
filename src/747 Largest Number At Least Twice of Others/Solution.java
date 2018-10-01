class Solution {
    public int dominantIndex(int[] nums) {
        if(null == nums || nums.length == 0) {
            return -1;
        }
        int retIdx = 0;
        int first = -1;
        int second = -1; 
        for (int i=0; i<nums.length; i++) {
            if(nums[i] > first) {
                second = first;
                first = nums[i];
                retIdx = i;
            } else if(nums[i] > second) {
                second = nums[i];
            }
        }
        return first >= second * 2 ? retIdx : -1;
    }
}
