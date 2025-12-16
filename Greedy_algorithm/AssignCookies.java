package Greedy_algorithm;

import java.util.Arrays;

public class AssignCookies {
    class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i=0;
        int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length)
        {
            if(s[j]>=g[i])
            {
                i++;
                //j++;
            }
            j++;
        }
        return i;
    }
}
}
