public class MinBottles{
  public static int minBottles(int target)
  {
    int[] bottles={2,3,5,7,11};
    int[] dp= new int[target +1];
    for(int i=0;i<=target; i++)
      {
        dp[i]=Integer.MAX_VALUE;
      }
    dp[0]=0;
    for(int i=1;i<=target;i++)
      {
        for(int bottle: bottles)
          {
            if(i - bottle >=0 && dp[i - bottle] != Integer.MAX_VALUE)
            {
              dp[i]= Math.min(dp[i], dp[i - bottle] +1);
            }
          }
      }
    return dp[target] == Integer.MAX_VALUE ?-1 : dp[target];
  }
  public static void main(String[] args)
  {
    int targetVolume=10;
    int result = minBottles(targetVolume);
    if(result !=-1)
    {
      System.out.println("Min bottles for "+targetVolume + "L :"+result);
    }
    else
    {
      System.out.println("No Combination Exists for this Quantity");
    }
  }
}
