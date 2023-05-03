package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/9 12:46
 */
import java.io.*;
/*
    【多重背包：二进制优化】
    （1）将第i个物品的数量s拆分成logs份物品i'。i'的重量和价值是原来第i个物品的倍数。
        例如：将重量为5，价值为8，数量为9的物品拆分成4份物品：
            w:5 v:8 s:1
            w:5*2 v:8*2 s:2
            w:5*4 v:8*4 s:4
            w:5*2 v:8*2 s:2
    （2）然后用01背包的方式解决
*/
public class _01MultBagsBigData {

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);

        // 拆分物品
        int[] w = new int[n*15];
        int[] v = new int[n*15];
        int cnt = 1;
        for(int i=1;i<=n;i++){
            String[] ss2 = br.readLine().split(" ");
            int curw = Integer.parseInt(ss2[0]);
            int curv = Integer.parseInt(ss2[1]);
            int curs = Integer.parseInt(ss2[2]);

            int p = 1;
            while(curs >= p){
                w[cnt] = curw*p;
                v[cnt] = curv*p;
                cnt++;
                curs -= p;
                p = p * 2;
            }
            if(curs != 0){
                w[cnt] = curw*curs;
                v[cnt] = curv*curs;
                curs = 0;
                cnt++;
            }
        }

        // 处理01背包问题
        int[][] dp = new int[cnt][m+1];
        for(int i=1;i<cnt;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = dp[i-1][j];
                if(j-w[i] >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]);
                }
            }
        }

        System.out.print(dp[cnt-1][m]);
    }
}
