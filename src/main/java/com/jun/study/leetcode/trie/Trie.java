package com.jun.study.leetcode.trie;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 */

public class Trie {
    private final static Integer R = 26;
    private Trie[] nodes;
    private boolean isEnd;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }

    public Trie() {
        nodes = new Trie[R];
        isEnd = false;
    }

    public Trie get(Character character) {
        return nodes[character - 'a'];
    }

    public Trie put(Character character, Trie trie) {
        nodes[character - 'a'] = trie;
        return trie;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (node.get(ch) == null) {
                node = node.put(ch, new Trie());
            } else {
                node = node.get(ch);
            }
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            node = node.get(ch);
            if (node == null) {
                return false;
            }

        }
        return node.isEnd();
    }

    public boolean startWith(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            node = node.get(ch);
            if (node == null) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean ok = trie.search("apple");
        System.out.println("ok = " + ok);
    }


}
