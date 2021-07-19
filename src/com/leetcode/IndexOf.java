package com.leetcode;

public class IndexOf {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("a", "a"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || haystack.equals(needle)) {
            return 0;
        }
        int i, j;
        for (i=0; i < haystack.length(); i++) {
            int temp = i;
            for (j=0; j < needle.length(); j++) {
                if (haystack.charAt(temp) == needle.charAt(j)) {
                 temp++;
                 if (temp >= haystack.length()) {
                     break;
                 }
                } else {
                    break;
                }

            }
            if (j == needle.length()) {
                return i;
            }

        }
        return -1;
    }
}
