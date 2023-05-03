package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/3 12:47
 */
import java.util.*;
import java.io.*;

public class _08Sking {
    static int[][] dp;
    static int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public static int dfs(int[][] graph, int x,int y){
        if(dp[x][y] != -1){
            return dp[x][y];
        }

        int ans = 0;
        for(int[] direction: directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(nx>=0 && ny>=0 && nx<graph.length && ny<graph[0].length && graph[x][y] > graph[nx][ny]){
                ans = Math.max(ans, dfs(graph, nx, ny)+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int[][] graph = new int[n][m];
        for(int i=0;i<n;i++){
            String[] ss2 = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(ss2[j]);
            }
        }

        dp = new int[n][m];
        for(int i=0;i<n;i++)    Arrays.fill(dp[i], -1);

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, dfs(graph, i, j)+1);
            }
        }
        System.out.println(ans);
    }
}
