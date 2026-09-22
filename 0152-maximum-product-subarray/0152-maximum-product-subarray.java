class Solution {
    public int maxProduct(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            int v1 = nums[i];
            int v2 = nums[i] * maxEnd;
            int v3 = nums[i] * minEnd;
            maxEnd = Math.max(v1, Math.max(v2, v3));
            minEnd = Math.min(v1, Math.min(v2, v3));
            res = Math.max(res, Math.max(maxEnd, minEnd));
        }
        return res;
    }
}