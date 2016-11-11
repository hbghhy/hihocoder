import java.util.Scanner;

/**
 * Created by hanyuhuang on 2016/11/11.
 */
public class h1037 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int[][] dp=new int[2][];
        dp[0]=new int[n];
        dp[1]=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int now=scanner.nextInt();
                if(j==0){
                    dp[i&1][j]=dp[1-i&1][j]+now;
                }
                else{
                    dp[i&1][j]=Math.max(dp[1-i&1][j],dp[1-i&1][j-1])+now;
                }
                if(dp[i&1][j]>ans) {
                    ans=dp[i&1][j];
                }
            }
        }
        System.out.println(ans);
    }
}
