package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/2 23:51
 */
import java.io.*;

/*
    【思路1】：转化为完全背包问题 将n用1,2,3,4,5,6...的和来表示，求方式个数
        dp[i][j]集合： 对于前i个数字，选取其中若干之和恰好为j的集合
        dp[i][j]属性： 对于前i个数字，选取其中若干之和恰好为j的次数
        dp[i][j]转移O(n^2 * logn)：
            - 考虑对于当前数字i有以下情况：选0、1、2、k次。 i*k <= j
            - dp[i][j] += sum(dp[i-1][j-i*k])
        dp[i][j]优化：
            - 我们可以推导出来
                dp[i][j] = dp[i-1][j] + dp[i-1][j-i] + dp[i-1][j-2*i]......
            - dp[i][j-i] = dp[i-1][j-i] + dp[i-1][j-2*i]......
            - dp[i][j] = dp[i-1][j] + dp[i][j-i];

*/
public class _04DivInteger {
    public static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp初始化
        int[][] dp = new int[1001][n+1];
        for(int j=0;j<=n;j++){
            dp[1][j] = 1;
        }
        for(int i=1;i<=1000;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=1000;i++){       // 模拟数字i
            for(int j=1;j<=n;j++){      // 模拟背包容量
                // // 模拟当前数字i选几次
                // for(int k=0;i*k<=j;k++){
                //     dp[i][j] = (dp[i][j] + dp[i-1][j-i*k]) % MOD;
                // }
                if(j-i>=0)
                    dp[i][j] = (dp[i-1][j] + dp[i][j-i]) % MOD;
                else{
                    dp[i][j] = dp[i-1][j] % MOD;
                }
            }
        }
        System.out.println(dp[1000][n]);
    }
}
