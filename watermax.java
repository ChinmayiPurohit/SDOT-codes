class Main
{
    public static int maxwater(int[] height){
        int left=0,right=height.length-1;
        int maxw=0;

        while(left<right)
        {
            int minheight=Math.min(height[left],height[right]);
            int width=right-left;
            maxw=Math.max(maxw,minheight*width);


            if(height[left]<height[right]) left++;
            
            else right--;
        }
        return maxw;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] heights=new int[n];
        for(int i=0;i<n;i++){
            heights[i]=s.nextInt();
        }
        int ans=maxwater(heights);
        System.out.println(ans);
        s.close();
    }
}
