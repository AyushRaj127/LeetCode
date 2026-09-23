class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int n=nums.size();
        long long total=accumulate(nums.begin(),nums.end(),0LL);
        if(total<x) return -1;
        if(total==x) return n;
        int i=0, j=0, sum=0, maxi=0;
        int target=total-x;
        while(j<n){
            sum+=nums[j];
            while(j>=i && sum>target){
                sum-=nums[i];
                i++;
            }
            if(sum==target) maxi=max(maxi,j-i+1);
            j++;
        }
        return maxi==0 ? -1 : n-maxi;
    }
};