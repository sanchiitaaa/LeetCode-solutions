class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;

        for (int candy : candies) {
            high = Math.max(high, candy);
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long count = 0;

            for (int candy : candies) {
                count += candy / mid;
            }

            if (count >= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}