class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        generate(s, 0);
        return res;
    }

    public void generate(String s, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start, i)) {
                temp.add(s.substring(start, i + 1));
                generate(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}