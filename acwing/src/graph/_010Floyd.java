package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/26 18:36
 */
import java.util.*;
import java.io.*;

public class _010Floyd {
    private static final int INF = 0x3f3f3f3f;

    public static void floyd(int[][] graph){
        int n = graph.length - 1;
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int k = Integer.parseInt(ss[2]);


        // 建图
        int[][] graph = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            int from = Integer.parseInt(ss2[0]);
            int to = Integer.parseInt(ss2[1]);
            int val = Integer.parseInt(ss2[2]);

            graph[from][to] = Math.min(graph[from][to], val);
        }

        // 求最短距离
        floyd(graph);

        // 输出答案
        for(int i=0;i<k;i++){
            String[] ss2 = br.readLine().split(" ");
            int from = Integer.parseInt(ss2[0]);
            int to = Integer.parseInt(ss2[1]);

            int ans = graph[from][to];
            if(ans > INF / 2)
                System.out.println("impossible");
            else
                System.out.println(ans);
        }
    }
}
