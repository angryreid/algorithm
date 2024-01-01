package emma.strings;

public class _II_151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int len = 0;
        int cur = 0;
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? (cur - 1) : cur;
        if (len <= 0) return null;
        reverse(chars, 0, len);
        int preSpaceIdx = -1;
        for (int i = 0; i < len; i++) {
            if(chars[i] != ' ') continue;
            reverse(chars, preSpaceIdx + 1, i);
            preSpaceIdx = i; // The provided Java code is intended to reverse the words in a string. However, there is a mistake in the code. The line preSpaceIdx = 1; should be preSpaceIdx = i; because we want to update preSpaceIdx to the current index i, not 1.
        }
        reverse(chars, preSpaceIdx + 1, len);
        return new String(chars, 0, len);
    }

    private void reverse(char[] chars, int l, int r) { // [l, r)
        r--;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        _II_151_Reverse_Words_in_a_String solution = new _II_151_Reverse_Words_in_a_String();
        System.out.println(solution.reverseWords("  hello world!  "));
    }
}
