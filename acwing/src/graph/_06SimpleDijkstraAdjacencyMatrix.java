package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/19 22:17
 */
import java.util.*;
import java.io.*;

public class _06SimpleDijkstraAdjacencyMatrix {
    private static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        int[][] graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++)   Arrays.fill(graph[i], INF);
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            int from = Integer.parseInt(ss2[0]);
            int to = Integer.parseInt(ss2[1]);
            int val = Integer.parseInt(ss2[2]);

            // 避免自环
            if(from == to)  continue;
            // 避免重边
            graph[from][to] = Math.min(graph[from][to], val);
        }
        // 朴素dijkstra
        System.out.println(dijkstra(graph));
    }

    public static int dijkstra(int[][] graph){
        int n = graph.length-1;
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dist, INF);

        // 1 初始化dist[1] = 0
        dist[1] = 0;

        // 2 遍历n次, 每次在当前最短距离表dist中选择一个最小的未被确定为最短距离的点,作为当前最短距离点，然后更新临边的最短距离
        for(int i=1;i<=n;i++){
            //
            int curMinNode = -1;
            int curMinVal = INF;
            for(int j=1;j<=n;j++){
                if(!visited[j] && curMinVal > dist[j]){
                    curMinNode = j;
                    curMinVal = dist[j];
                }
            }
            if(curMinNode == -1)    break;

            // 更新dist表
            visited[curMinNode] = true;
            for(int j=1;j<=n;j++){
                dist[j] = Math.min(dist[j], dist[curMinNode] + graph[curMinNode][j]);
            }
        }

        return dist[n] == INF?-1:dist[n];
    }
}
