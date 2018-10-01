class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expect = (1 + n) * n / 2;
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        return expect - sum;
    }
}
