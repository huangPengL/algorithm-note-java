package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/17 20:14
 */
import java.io.*;

/*
    si = abedc
    sj = acbd

        a c b d
    a   1 1 1 1
    b   1 1 2 2
    e   1 1 2 2
    d   1 1 2 3
    c   1 2 2 3
*/
public class _02LCS {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");

        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        String si = br.readLine();
        String sj = br.readLine();


        // dp
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(sj.charAt(j-1) == si.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}