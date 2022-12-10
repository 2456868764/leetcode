package com.jun.study.leetcode.adsearch;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        //return ladderSearch(beginSet, endSet, wordSet);
        return ladderSearchBFS(beginWord, endWord, wordSet);
    }

    private int ladderSearchBFS(String beginWord, String endWord, Set<String> wordSet) {
        int len = 1;
        Deque<String> deque = new ArrayDeque<>();
        deque.push(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!deque.isEmpty()) {
            int currentSize = deque.size();
            for (int cc = 0; cc < currentSize; cc++) {
                String word = deque.poll();
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {

                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endWord.equals(target)) {
                            return len +1;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            deque.addLast(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }

                }
            }
            len++;

        }
        return 0;
    }
    private int ladderSearch(Set<String> beginSet, Set<String> endSet, Set<String> wordSet) {
        int len = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> temp = new HashSet<>();
            //generate next
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return len +1;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }

                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;

        }
        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        WordLadder wordLadder = new WordLadder();
        System.out.println("length=" + wordLadder.ladderLength(beginWord,endWord,wordList));

    }


}
