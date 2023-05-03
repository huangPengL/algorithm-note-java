package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/9 12:47
 */
import java.io.*;
/*
    【多重背包：朴素解法】
*/
public class _01MultBagsNormalData {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        int[] w = new int[n+1];          // 第i件物品的重量为w[i]
        int[] v = new int[n+1];          // 第i件物品的价值为v[i]
        int[] s = new int[n+1];          // 第i件物品的数量为s[i]
        int[][] dp = new int[n+1][m+1];  // dp[i][j]表示考虑前i件物品且重量不超过j的最大价值

        for(int i=1;i<=n;i++){
            String[] ss2 = br.readLine().split(" ");
            w[i] = Integer.parseInt(ss2[0]);
            v[i] = Integer.parseInt(ss2[1]);
            s[i] = Integer.parseInt(ss2[2]);
        }

        // 初始化dp, 将第一行第一列初始化为0

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=0;k<=s[i] && k*w[i]<=j;k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k*w[i]]+k*v[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
