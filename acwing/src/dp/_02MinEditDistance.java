package dp;

import java.io.*;

/*
    状态集合：dp[i][j]表示A串前i个变成B串前j个的操作方式
    状态属性：min。 将 A 变为 B 至少需要进行多少次操作
    状态转移：
        - 删除A串第i个字符 dp[i-1][j]+1
        - 给A串添加B串第j个字符 dp[i][j-1]+1
        - 修改A串第i个字符为B串第j个字符 dp[i-1][j-1] + 1
        - 不变 dp[i-1][j-1]

*/
public class _02MinEditDistance {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String strA = br.readLine();
        int m = Integer.parseInt(br.readLine().trim());
        String strB = br.readLine();


        // dp初始化
        int[][] dp = new int[n+1][m+1];
        for(int j=0;j<=m;j++){
            dp[0][j] = j;       // 空串变成B串需要的最少操作次数
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = i;       // A串变成空字符串需要的最少操作次数
        }

        // dp
        for(int i=1;i<=n;i++){          // 模拟A串的最后一个字符
            for(int j=1;j<=m;j++){      // 模拟B串的最后一个字符

                // 删除A串第i个字符
                dp[i][j] = dp[i-1][j]+1;

                // 给A串添加B串第j个字符
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);

                // 不变 / 修改A串第i个字符为B串第j个字符
                if(strA.charAt(i-1) == strB.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}