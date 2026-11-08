class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int idle = (maxFreq - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxFreq - 1, freq[i]);
        }

        return tasks.length + Math.max(0, idle);
    }
}