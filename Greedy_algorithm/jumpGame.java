class Solution {
    public boolean canJump(int[] nums) {
       int max_index=0;
       for(int i=0;i<nums.length;i++)
       {
            if(i>max_index)
                return false;
            int limit=nums[i]+i;
            max_index=Math.max(limit,max_index);
       }
       return true;
    }
}
