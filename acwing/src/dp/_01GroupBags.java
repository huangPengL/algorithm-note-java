package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/9 13:17
 */
import java.io.*;

public class _01GroupBags {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);

        int[][] w = new int[n+1][101];        // w[i][j] 表示第i组的第j个物品的重量
        int[][] v = new int[n+1][101];
        int[] s = new int[n+1];
        for(int i=1;i<=n;i++){
            s[i] = Integer.parseInt(br.readLine());
            for(int j=1;j<=s[i];j++){
                String[] ss2 = br.readLine().split(" ");
                int curw = Integer.parseInt(ss2[0]);
                int curv = Integer.parseInt(ss2[1]);
                w[i][j] = curw;
                v[i][j] = curv;
            }
        }

        // dp
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = dp[i-1][j];  // 当前背包容量为j时，暂时不选第i组物品
                for(int k=1;k<=s[i];k++){
                    if(j-w[i][k] >= 0){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i][k]] + v[i][k]);
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
