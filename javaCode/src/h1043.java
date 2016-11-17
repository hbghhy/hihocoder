import java.util.Scanner;

/**
 * Created by hbghh on 2016/11/17.
 */
public class h1043 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] need = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            need[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        int[] dp = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (need[i] <= j) {
                    dp[j] = Math.max(dp[j - need[i]] + value[i], dp[j]);
                }
            }
        }
        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
