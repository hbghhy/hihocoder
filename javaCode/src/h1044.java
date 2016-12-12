import java.util.Scanner;



/**
 * Created by hbghh on 2016/11/20.
 */
public class h1044 {
    static int count(int m){
        int ans=0;
        while (m!=0){
            m&=(m-1);
            ans++;
        }
        return ans;
    }


    static int next(int j,int q,int mask){
        if(count(j)<q){
            return ((j<<1)|1)&mask;
        }else {
            return (j<<1)&mask;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m,q;
        n = scanner.nextInt();
        m = scanner.nextInt();
        q=scanner.nextInt();
        int mask=(1<<m)-1;
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        int[][] dp=new int[n][mask+1];
        dp[0][0]=0;
        dp[0][1]=w[0];
        int ans=w[0];
        for(int i=1;i<m;i++){
            for(int j=0;j<(1<<i);j++){
                if(count(j)<q) {
                    int tmp = dp[i - 1][j] + w[i];
                    if(tmp>dp[i][(j << 1)|1])dp[i][(j << 1)|1] = tmp;
                    if(tmp>ans) ans=tmp;
                } else{
                    if(dp[i - 1][j]>dp[i][(j << 1)]) dp[i][(j << 1)] = dp[i - 1][j];
                    if(dp[i - 1][j]>ans) ans=dp[i - 1][j];
                }
            }
        }
        for(int i=m;i<n;i++){
            for(int j=0;j<=mask;j++){
                if(count((j<<1)&mask)<q) {
                    int tmp = dp[i - 1][j] + w[i];
                    if(dp[i][((j << 1) + 1)&mask]<tmp) dp[i][((j << 1) + 1)&mask]=tmp;
                    if(tmp>ans) ans=tmp;
                } else{
                    if(dp[i][((j << 1))&mask]<dp[i - 1][j]) dp[i][((j << 1))&mask] = dp[i - 1][j];
                    if(dp[i - 1][j]>ans) ans=dp[i - 1][j];
                }
            }
        }
        System.out.println(ans);
    }
}
