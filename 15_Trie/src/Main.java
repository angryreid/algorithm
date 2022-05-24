import emma.trie.MyTrie;
import emma.trie.Trie;

public class Main {

    public static void testAdd() {
        Trie<String> trie = new MyTrie<>();
        trie.add("a", "a");
        trie.add("ab", "ab");
        trie.add("abc", "abc");
        trie.add("abcd", "abcd-9876");
        trie.add("abcdc87654", "abcd-9876");
        System.out.println(trie.get("a"));
        System.out.println(trie.get("abcd"));
        System.out.println(trie.startsWith("abcdc"));
        System.out.println(trie.startsWith("babcdc"));
        System.out.println(trie.size());
        System.out.println(trie.contains("ab"));
    }
    public static void main(String[] args) {
        testAdd();
    }
}
