package com.jun.study.leetcode.adsearch;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {

    public List<String> minMutation(String start, String end, String[] bank) {
        char[] right = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int len = 1;
        Deque<String> path = new LinkedList<>();
        path.addLast(start);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> levelSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (int j = 0; j < right.length; j++) {
                        char old = chs[i];
                        chs[i] = right[j];
                        String target = String.valueOf(chs);
                        path.addLast(target);
                        if (end.equals(target)) {
                            len++;
                            return (List)path;
                        }
                        path.removeLast();
                        if (!visited.contains(target) && bankSet.contains(target)) {
                            levelSet.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = levelSet;
            len++;

        }
        return null;

    }

    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
        List<String> result = minimumGeneticMutation.minMutation(start, end, bank);
        if (result == null) {
            System.out.println("can not find");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
