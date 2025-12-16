package Greedy_algorithm;

import java.util.Arrays;

public class ItemNode{
    double val;
    double wei;
    public ItemNode(double val,double wei)
    {
        this.val=val;
        this.wei=wei;
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n=val.length;
        ItemNode[] arr=new ItemNode[n];
        for(int i=0;i<n;i++)
            arr[i]=new ItemNode(val[i],wt[i]);
        Arrays.sort(arr,(a,b)-> Double.compare((b.val/b.wei),(a.val/a.wei)));
        double ans=0;
        int k=arr.length;
        int i=0;
        while(capacity>0 && i<k)
        {
            if(arr[i].wei<=capacity)
            {
                ans+=arr[i].val;
                capacity-=arr[i].wei;
            }
            else{
                ans+=(capacity/arr[i].wei)*arr[i].val;
                capacity=0;
            }
            i++;
        }
        return ans;
    }
} 
