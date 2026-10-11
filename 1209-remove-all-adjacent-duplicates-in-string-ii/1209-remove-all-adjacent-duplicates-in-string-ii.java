class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder str = new StringBuilder();
        int[] count = new int[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            str.append(ch);
            top++;

            if (top > 0 && str.charAt(top - 1) == ch) {
                count[top] = count[top - 1] + 1;
            } else {
                count[top] = 1;
            }

            if (count[top] == k) {
                str.delete(top - k + 1, top + 1);
                top -= k;
            }
        }

        return str.toString();
    }
}