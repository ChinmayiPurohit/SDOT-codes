import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public int rob(int[] nums)
    {
        final int n=nums.length;
        if(n==0)
        return 0;
        if(n==1)
        return nums[0];

        int []dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<n;i++)
        {
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc= new Scanner (System.in);
        String[] input=sc.nextLine().split(",");
        int n=input.length;
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=Integer.parseInt(input[i]);
        }
        Solution solution = new Solution();
        int maxrobbery=solution.rob(nums);
        System.out.println(maxrobbery);
	}
}
