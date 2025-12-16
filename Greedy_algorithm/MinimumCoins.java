package Greedy_algorithm;

    class Solution {
    public int findMin(int n) {
        // code here
        int coin=10;
        int count=0;
        while(n>0)
        {
            /*count+=(n/coin);
            n=n%coin;
            coin=coin/2;*/
            while(n>=coin)
            {
                n-=coin;
                count++;
            }
            coin=coin/2;
        }
        return count;
    }
}


