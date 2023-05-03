package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/22 18:57
 */
import java.io.*;

/*
    【例子1】：
        index:  1 2 3 4
        value: [1 3 5 2]
        len = 2
            l = 1, r = 2, k = l~r-1 = 1~1
                dp[1][2] = dp[1][1] + dp[2][2] + 4 = 4
            l = 2, r = 3, k = l~r-1 = 2~2
                dp[2][3] = dp[2][2] + dp[3][3] + 8 = 8
            l = 3, r = 4, k = l~r-1 = 3~3
                dp[3][4] = dp[3][3] + dp[4][4] + 7 = 7
        len = 3
            l = 1, r = 3, k = 1~2
                k = 1: dp[1][3] = dp[1][1] + dp[2][3] + 9 = 17
                k = 2: dp[1][3] = dp[1][2] + dp[3][3] + 9 = 13
                dp[1][3] = argMin(dp[1][3]) = 13
            l = 2, r = 4, k = 2~3
                k = 2: dp[2][4] = dp[2][2] + dp[3][4] + 10 = 17
                k = 3: dp[2][4] = dp[2][3] + dp[4][4] + 10 = 18
                dp[2][4] = argMin(dp[2][3]) = 17
        len = 4
            l = 1, r = 4, k = 1~3
                k = 1: dp[1][4] = dp[1][1] + dp[2][4] + 11 = 28
                k = 2: dp[1][4] = dp[1][2] + dp[3][4] + 11 = 22
                k = 3: dp[1][4] = dp[1][3] + dp[4][4] + 11 = 24
                dp[1][4] = argMin(dp[1][4]) = 22

*/
public class _03StoneMerging {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");

        int[] arr = new int[n+1];
        int[] sum = new int[n+1];

        // 计算前缀和
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(ss[i-1]);
            sum[i] = arr[i] + sum[i-1];
        }

        // dp
        int[][] dp = new int[n+1][n+1];     // dp[i][j] 表示第i堆石子到第j堆石子的这若干堆连续石子进行合并的最小值

        // 1 枚举石子堆的个数
        for(int len=2;len<=n;len++){
            // 2 枚举区间的左端点和右端点，区间长度为石子堆的长度，计算这个区间进行石子合并的最小值
            for(int l=1,r=l+len-1;r<=n;l++,r++){
                // 3 枚举分割点(最后一次合并的石子堆)，计算左端点到分割点进行合并的最小值， 计算分割点到右端点进行合并的最小值
                dp[l][r] = 0x3f3f3f3f;
                for(int k=l;k<r;k++){
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k+1][r] + (sum[r] - sum[l-1]));
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}