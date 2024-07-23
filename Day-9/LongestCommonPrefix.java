class Solution {
    public String longestCommonPrefix(String[] str) {
        if(str == null || str.length == 0) return "";

        String commonPrefix = str[0];

        for(int i = 1; i < str.length; i++) {
            String curr = str[i];
            int j = 0;

            while(j < commonPrefix.length() && j < curr.length() && commonPrefix.charAt(j) == curr.charAt(j)) {
                j++;
            }
            commonPrefix = commonPrefix.substring(0, j);
        }
        return commonPrefix;
    }
}