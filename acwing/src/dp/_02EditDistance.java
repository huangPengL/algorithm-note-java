package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/18 23:57
 */
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
public class _02EditDistance {
    public static int getDistance(String strA, String strB){
        int n = strA.length();
        int m = strB.length();

        // 初始化dp
        int[][] dp = new int[n+1][m+1];
        for(int j=0;j<=m;j++)
            dp[0][j] = j;       // 空串变成B串需要的最少操作次数
        for(int i=0;i<=n;i++)
            dp[i][0] = i;       // A串变成空字符串需要的最少操作次数

        // dp
        for(int i=1;i<=n;i++){          // 模拟A串的最后一个字符
            for(int j=1;j<=m;j++){      // 模拟B串的最后一个字符
                // 删除A串第i个字符
                dp[i][j] = dp[i-1][j]+1;
                // 给A串添加B串第j个字符
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                // 不变 / 修改A串第i个字符为B串第j个字符
                if(strA.charAt(i-1) == strB.charAt(j-1))
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                else
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        String[] strs = new String[n];
        for(int i=0;i<n;i++)    strs[i] = br.readLine();

        String[] queryStr = new String[m];
        int[] queryLimit = new int[m];
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            queryStr[i] = ss2[0];
            queryLimit[i] = Integer.parseInt(ss2[1]);
        }

        // DP
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<m;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                String A = strs[j];         // for-loop所有原始串A，计算A变成B的最短编辑距离
                String B = queryStr[i];     // 查询串B
                int limit = queryLimit[i];
                if(getDistance(A, B) <= limit)
                    count++;
            }
            ans.append(count).append("\n");
        }
        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans);
    }
}