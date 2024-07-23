class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isOpening(ch)) {
                st.push(ch);
            }
            else {
                if(st.isEmpty()) return false;
                else if(!isMatching(st.peek(), ch)) {
                    return false;
                }
                else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

    public static boolean isOpening(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    public static boolean isMatching(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }
}