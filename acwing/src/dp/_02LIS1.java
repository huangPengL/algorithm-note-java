package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/17 17:34
 */
import java.io.*;

// dp[i] 表示以第i个数字结尾的最长上升子序列
public class _02LIS1 {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(ss[i]);


        // 初始化 dp[i] = 1
        int[] dp = new int[n];
        for(int i=0;i<n;i++)    dp[i] = 1;

        // dp
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){   // 枚举前i个数字，若有数字小于第i个数字，则表示能组成一个上升子序列
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
