package com.jun.study.leetcode.google.day23;

import java.util.HashMap;
import java.util.Map;

/**
 * medium
 * https://leetcode.com/problems/find-and-replace-in-string/
 *
 * Question:
 * Got this question
 *
 * Given a patch with list of replacements, apply the patch
 *
 * Replacement{
 * int offset; starting offset of the change
 * String previousString; - string present from starting offset
 * String newString - this string should replace previous string
 * }
 *
 * Patch{
 * List replacements
 * void apply(String org){
 * // Write code to apply the replacements
 * }
 * }
 *
 * We need to check for valid of the replacement. like if the previousString is actually the same at the offset mentioned in the org string.
 * Sort the replacement wrt to offset so that they ar eall in order
 *
 * After that I just used brute force and applied stringbuilder replace.
 *
 * Interviewer said try thinking of String Buffer or having a buffer to have the replacements.
 *
 * I did tno understand this. Can anyone else opine here?
 */
public class FindAndReplaceInString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = sources.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int beginIndex = indices[i];
            String source = sources[i];
            int sublen = source.length();
            if (beginIndex + sublen > s.length()) {
                break;
            }
            String indexString = s.substring(beginIndex, beginIndex + sublen);
            if (source.equals(indexString)) {
                map.put(beginIndex, i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(i)) {
                builder.append(targets[map.get(i)]);
                i+=sources[map.get(i)].length()-1;
            } else {
                builder.append(s.charAt(i));
            }

        }

        return builder.toString();

    }



}
