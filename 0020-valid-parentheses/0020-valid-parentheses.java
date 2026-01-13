class Solution {
    public boolean isValid(String s) {

               if (s == null || s.length() < 1) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {

                // FIX 1: correct empty check
                if (stack.isEmpty()) return false;

                char top = stack.peek();

                // FIX 2: parentheses for clarity
                if ((top == '(' && ch == ')') ||
                    (top == '[' && ch == ']') ||
                    (top == '{' && ch == '}')) {
                    stack.pop();
                } else {
                    // FIX 3: mismatch handling
                    return false;
                }
            }
        }

        return stack.isEmpty();
        
    }
}