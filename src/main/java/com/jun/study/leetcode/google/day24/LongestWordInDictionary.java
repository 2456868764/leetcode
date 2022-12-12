package com.jun.study.leetcode.google.day24;

/**
 * medium https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class LongestWordInDictionary {
    private String result;
    private Trie root;
    public String longestWord(String[] words) {
        result = "";
        root = new Trie();
        for (String word : words) {
            root.insert(word);
        }
        DFSearchTrie(root);
        return result;

    }

    private void DFSearchTrie(Trie root) {
        //terminate
        if (root == null) {
            return;
        }

        if (root.word != null) {
            if (root.word.length() > result.length()) {
                result = root.word;
            } else {
                if (root.word.length() == result.length() && root.word.compareTo(result) < 0) {
                    result = root.word;
                }

            }
        }

        //sub problem

        //drive deep level
        for (Trie child : root.children) {
            if (child != null && child.word != null) {
                DFSearchTrie(child);
            }
        }
        //restore
    }


    class Trie {
        Trie[] children = new Trie[26];
        String word;
        Trie() {

        }

        public void insert(String word) {
            Trie node = this;
            for (Character ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new Trie();
                    node = node.children[ch - 'a'];
                } else {
                    node = node.children[ch - 'a'];
                }

            }
            node.word = word;

        }
    }

    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String result = longestWordInDictionary.longestWord(words);
        System.out.println("result = " + result);
    }
}
