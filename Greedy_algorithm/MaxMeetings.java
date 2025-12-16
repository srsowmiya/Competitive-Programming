package Greedy_algorithm;

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n=start.length;
        int[][] meetings=new int[n][2];
        for(int i=0;i<n;i++)
        {
            meetings[i][0]=start[i];
            meetings[i][1]=end[i];
        }
        Arrays.sort(meetings,(a,b)-> a[1]-b[1]);
        int total=0;
        int lastEnd=-1;
        for(int i=0;i<n;i++)
        {
            if(meetings[i][0]>lastEnd)
            {
                total+=1;
                lastEnd=meetings[i][1];
            }
        }
        return total;
    }
}

