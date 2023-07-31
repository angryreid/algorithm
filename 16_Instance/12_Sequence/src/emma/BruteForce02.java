package emma;

public class BruteForce02 {
    // return first index of pattern in text, otherwise -1
    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;
        int pi = 0, ti = 0;

       for (int i = 0; i < tlen - plen + 1; i++) {
           for (int j = 0; j < plen; j++) {
               if (textChars[i + j] != patternChars[j]) break;
               if (j == plen - 1) return i;
           }
       }
        return -1;
    }
}
