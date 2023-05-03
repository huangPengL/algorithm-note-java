package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/15 23:14
 */
import java.io.*;

public class _02NumTriangle {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split(" ");
            for(int j=0;j<ss.length;j++){
                arr[i][j] = Integer.parseInt(ss[j]);
            }
        }

        // DP
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<i+1;j++){
                if(j == i){
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                }
            }
        }

        int ans = dp[n-1][0];
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[n-1][i]);
        }
        System.out.println(ans);
    }
}
