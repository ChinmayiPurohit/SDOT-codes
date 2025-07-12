import java.util.*;
import java.lang.*;
import java.io.*;


class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(",");
        int[] sequence= new int[input.length];
        for(int i=0;i<input.length;i++)
        {
            sequence[i] = Integer.parseInt(input[i]);
        }

        int ans=findlongestseqlen(sequence);
        System.out.println(ans);
		// your code goes here
	}

    public static int findlongestseqlen(int[] sequence)
    {
        if(sequence == null || sequence.length == 0)
        return 0;

        int n = sequence.length;
        int[] dp= new int[n];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++)
        {
            for(int j=0; j<i;j++)
            {
                if(sequence[i] > sequence[j])
                dp[i]= Math.max(dp[i], dp[j]+1);
            }
        }
        int max=0;
        for(int m:dp)
        {
            if(m>max) max=m;
        }

        return max;
    }

}
