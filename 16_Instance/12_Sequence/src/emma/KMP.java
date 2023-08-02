package emma;

public class KMP {

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

        int[] next = next(pattern);

        while (pi < plen && ti - pi <= tlen - plen) { // ti - pi <= tlen - plen 保证了不会越界
            if (pi < 0 || textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                pi = next[pi];
            }
        }
        return pi == plen ? ti - pi : -1; // pi == plen 说明匹配到了
    }

/**
 * @param text    主串
 * @param pattern 模式串
 * @return
 */
    private static int[] next(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < chars.length - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
