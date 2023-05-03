package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/5 21:00
 */
import java.io.*;

public class _01CompleteBags {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        int[] w = new int[n+1];          // 第i件物品的重量为w[i]
        int[] v = new int[n+1];          // 第i件物品的价值为v[i]
        int[][] dp = new int[n+1][m+1];  // dp[i][j]表示考虑前i件物品且重量不超过j的最大价值

        for(int i=1;i<=n;i++){
            String[] ss2 = br.readLine().split(" ");
            w[i] = Integer.parseInt(ss2[0]);
            v[i] = Integer.parseInt(ss2[1]);
        }

        // 初始化dp, 将第一行第一列初始化为0

        // dp
        /*
            首先，我们知道求解dp[i][j]：
            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v, dp[i-1][j-2w]+2v, dp[i-1][j-3w]+3v...)

            然后，观察背包容量为j-w的情况（因为在这个情况下考虑了第i个物品选多少个）：
            dp[i][j-w] = Math.max(dp[i][j-w], dp[i-1][j-w], dp[i-1][j-2w]+v, dp[i-1][j-3w]+2v...)

            惊奇的发现：
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w]+v)
        */
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = dp[i-1][j];
                if(j-w[i] >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-w[i]] + v[i]);
            }
        }
        System.out.println(dp[n][m]);
    }
}
