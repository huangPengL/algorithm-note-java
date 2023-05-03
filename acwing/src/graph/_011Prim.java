package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/4/5 13:41
 */
import java.util.*;
import java.io.*;

public class _011Prim{
    private static int INF = 0X3F3F3F3F;

    public static int prim(int[][] graph){
        int n = graph.length-1;
        int[] dist = new int[n+1];              // dist[i]表示节点i距离当前最小生成树集合的最小距离
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[n+1];   // visited[i]为true表示节点i已经在最小生成树集合中

        int ans = 0;
        // 迭代n次，每次确定一个节点在最小生成树集合中
        for(int i=1;i<=n;i++){
            int t = -1;         // 候选节点

            // 在集合外的点中挑选一个距离当前集合最小的候选节点
            for(int j=1;j<=n;j++){
                if(!visited[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }

            // 如果没有找到候选节点，说明该图不连通，没有最小生成树
            if(i != 1 && dist[t] == INF) return INF;

            // 将候选节点放入集合
            visited[t] = true;

            // 记录答案（选第一个点的时候没有边所以无需记录答案；）
            if(i != 1){
                ans += dist[t];
            }

            // 用候选节点更新集合外的点
            for(int j=1;j<=n;j++){
                if(j == t)  continue;
                dist[j] = Math.min(dist[j], graph[t][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{

        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);

        // 建图(稠密图用邻接矩阵。最小生成树没有自环，若有重边则取最小的)
        int[][] graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++)   Arrays.fill(graph[i], INF);
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            int from = Integer.parseInt(ss2[0]);
            int to = Integer.parseInt(ss2[1]);
            int val = Integer.parseInt(ss2[2]);
            if(from == to)  continue;
            graph[from][to] = graph[to][from] = Math.min(graph[from][to], val);
        }

        // prim求最小生成树的路径和
        int ans = prim(graph);
        if(ans >= INF)
            System.out.println("impossible");
        else
            System.out.println(ans);
    }
}
