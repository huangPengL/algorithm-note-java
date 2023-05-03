package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/4/6 17:19
 */
import java.io.*;

/*
    递推式：
    C(a)(b) = C(a-1)(b) + C(a-1)(b-1)
 */
public class _08Combination1 {
    private static int MOD = 1000000007;

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 预处理所有组合数（1≤b≤a≤2000， 总空间4000000）
        int[][] dp = new int[2001][2001];       // dp[a][b] 表示 Cab
        for(int i=0;i<=2000;i++){
            for(int j=0;j<=i;j++){
                if(j == 0)  dp[i][j] = 1;
                else        dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % MOD ;
            }
        }

        while(n != 0){
            String[] ss = br.readLine().split(" ");
            System.out.println(dp[Integer.parseInt(ss[0])][Integer.parseInt(ss[1])]);
            n--;
        }

    }
}
