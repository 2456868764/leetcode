package com.jun.study.leetcode.array;

import java.util.*;

class Main {

    public static String ArrayChallenge(String[] strArr) {
        // code goes here
        Map<String, Set<String>> childMap = new HashMap<>();
        Map<String, Set<String>> parentMap = new HashMap<>();
        for(int i=0; i<strArr.length;i++){
            String str = strArr[i];
            str.replace("(", "");
            str.replace(")", "");
            String[] ad = str.split(",");
            String child = ad[0];
            String parent = ad[1];
            Set<String> childList = childMap.get(parent);
            if (childList == null) {
                childList = new HashSet<>();
            }
            childList.add(child);
            childMap.put(parent, childList);
            Set<String> parentLis = parentMap.get(child);
            if (parentLis == null) {
                parentLis = new HashSet<>();
            }
            parentLis.add(parent);
            parentMap.put(child, parentLis);

        }
        for (Map.Entry child : childMap.entrySet()) {
            String parent = (String)child.getKey();
            Set<String> childSet = (Set<String>)child.getValue();
            if (childSet.size() > 2) {
                return "false";
            }

            for (String c : childSet) {
                Set<String> pset = parentMap.get(c);
                if (pset == null) {
                    return "false";
                }
                if (pset.size() > 1) {
                    return "false";
                }
                if (!pset.contains(parent)) {
                    return "false";
                }
            }


        }
        return "true";

    }

    public static void main (String[] args) {
        String[] a = new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        System.out.println("a" + ArrayChallenge(a));
//        // keep this function call here
//        Scanner s = new Scanner(System.in);
//        System.out.print(ArrayChallenge(s.nextLine()));
    }

}