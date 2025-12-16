package Greedy_algorithm;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five_dollar=0;
        int ten_dollar=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
            {
                five_dollar+=1;
            }
            else if(bills[i]==10)
            {
                if(five_dollar>0)
                {
                    five_dollar-=1;
                    ten_dollar+=1;
                }
                else
                    return false;
            }
            else{
                if(ten_dollar>0 && five_dollar>0)
                {
                    ten_dollar-=1;
                    five_dollar-=1;
                }
                else if(five_dollar>=3)
                {
                    five_dollar-=3;
                }
                else
                    return false;

            }
        }
        return true;
    }
}