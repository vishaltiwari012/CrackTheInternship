class Solution {
    public int strStr(String s, String t) {
        int m = s.length(), n = t.length();
        for (int i = 0; i < m-n+1; i++) {
            String sub = s.substring(i, i+n);
            if (sub.equals(t)) return i;
        }
        return -1;
    }
}