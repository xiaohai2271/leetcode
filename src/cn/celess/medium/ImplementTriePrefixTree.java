package cn.celess.medium;

import cn.celess.utils.*;

import java.util.Arrays;

public class ImplementTriePrefixTree {

    //@lc:start
    class Trie {
        Trie[] next;
        boolean isEnd = false;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            int index = word.charAt(0) - 'a';
            if (next[index] == null) next[index] = new Trie();
            if (word.length() == 1) {
                next[index].isEnd = true;
                return;
            }
            next[index].insert(word.substring(1));
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word.length() == 0) {
                return isEnd;
            }
            Trie node = next[word.charAt(0) - 'a'];
            if (node == null) {
                return false;
            }
            return node.search(word.substring(1));
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) {
                return true;
            }
            Trie node = next[prefix.charAt(0) - 'a'];
            return node != null && node.startsWith(prefix.substring(1));
        }
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    //@lc:end

    class TrieToString extends Trie {
        public TrieToString() {
        }

        public TrieToString(Trie t) {
            super.next = t.next;
            super.isEnd = t.isEnd;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < next.length; i++) {
                if (next[i] != null) {
                    stringBuilder.append((char) ('a' + i)).append(new TrieToString(next[i]));
                }
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        TrieToString trie = new ImplementTriePrefixTree().new TrieToString();
        Assert assertion = Assert.getInstance();
        trie.insert("apple");
        System.out.println("trie.insert(\"apple\"):===> " + (trie).toString());
        System.out.println("trie.startsWith(\"apple\"): " + trie.startsWith("apple"));
        System.out.println("trie.startsWith(\"app\"): " + trie.startsWith("app"));
        System.out.println("trie.startsWith(\"abc\"): " + trie.startsWith("abc"));

        System.out.println();

        System.out.println("trie.search(\"apple\"): " + trie.search("apple"));
        System.out.println("trie.search(\"app\"): " + trie.search("app"));
        System.out.println("trie.search(\"applee\"): " + trie.search("applee"));


        System.out.println("============================================================");
        TrieToString trie2 = new ImplementTriePrefixTree().new TrieToString();
        trie2.insert("app");
        trie2.insert("apple");
        trie2.insert("beer");
        trie2.insert("add");
        trie2.insert("jam");
        trie2.insert("rental");
        assertion.print("search(\"apps\")").expect(false).actual(trie2.search("apps"));
        assertion.print("search(\"app\")").expect(true).actual(trie2.search("app"));
        assertion.print("search(\"ad\")").expect(false).actual(trie2.search("ad"));
        assertion.print("search(\"applepie\")").expect(false).actual(trie2.search("applepie"));
        assertion.print("search(\"rest\")").expect(false).actual(trie2.search("rest"));
        assertion.print("search(\"jan\")").expect(false).actual(trie2.search("jan"));
        assertion.print("search(\"rent\")").expect(false).actual(trie2.search("rent"));
        assertion.print("search(\"beer\")").expect(true).actual(trie2.search("beer"));
        assertion.print("search(\"jam\")").expect(true).actual(trie2.search("jam"));

        assertion.print("startsWith(\"apps\")").expect(false).actual(trie2.startsWith("apps"));
        assertion.print("startsWith(\"app\")").expect(true).actual(trie2.startsWith("app"));
        assertion.print("startsWith(\"ad\")").expect(true).actual(trie2.startsWith("ad"));
        assertion.print("startsWith(\"applepie\")").expect(false).actual(trie2.startsWith("applepie"));
        assertion.print("startsWith(\"rest\")").expect(false).actual(trie2.startsWith("rest"));
        assertion.print("startsWith(\"jan\")").expect(false).actual(trie2.startsWith("jan"));
        assertion.print("startsWith(\"rent\")").expect(true).actual(trie2.startsWith("rent"));
        assertion.print("startsWith(\"beer\")").expect(true).actual(trie2.startsWith("beer"));
        assertion.print("startsWith(\"jam\")").expect(true).actual(trie2.startsWith("jam"));

        trie2.insert("ab");
        trie2.insert("abc");
        trie2.insert("abcd");

        assertion.print("startsWith(\"ab\")").expect(true).actual(trie2.startsWith("ab"));
        assertion.print("startsWith(\"abc\")").expect(true).actual(trie2.startsWith("abc"));
        assertion.print("startsWith(\"abcd\")").expect(true).actual(trie2.startsWith("abcd"));

        System.out.println(trie2.toString());
    }
}
