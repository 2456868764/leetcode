package com.jun.study.leetcode.google.day26;

/**
 * medium https://leetcode.com/problems/shortest-way-to-form-string/
 * https://leetcode.ca/all/1055.html
 */
public class ShortestWayToFormString {

    public int solution(String source, String target) {
        int count = 0;
        int targetLen = target.length();
        int sourceLen = source.length();
        int startIndex = 0;
        while (startIndex < targetLen) {
            startIndex = logestSubSequence(source, target, startIndex);
            if (startIndex < 0) {
                return -1;
            } else {
                count++;
            }
        }
        return count;

    }

    private int logestSubSequence(String source, String target, int startIndex) {
        int sourceLen = source.length();
        int targetLen = target.length();
        int targetIndex = startIndex, sourceIndex = 0;
        while (sourceIndex < sourceLen && targetIndex < targetLen) {
            char c1 = source.charAt(sourceIndex);
            char c2 = target.charAt(targetIndex);
            if (c1 == c2) {
                targetIndex++;
            }
            sourceIndex++;
        }
        if (targetIndex == startIndex) {
            return -1;
        } else {
            return targetIndex;
        }
    }
}
