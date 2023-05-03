package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/22 15:51
 */

import java.util.*;
import java.io.*;

public class _06OptimDijkstraAdjacencyTable {
    private static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)   graph.add(new HashMap<>());
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            int from = Integer.parseInt(ss2[0]);
            int to = Integer.parseInt(ss2[1]);
            int val = Integer.parseInt(ss2[2]);

            // 避免自环
            if(from == to)  continue;
            // 避免重边
            if(graph.get(from).containsKey(to) && graph.get(from).get(to) <= val)   continue;
            graph.get(from).put(to, val);
        }


        // 堆优化版dijkstra
        System.out.println(dijkstra(graph));
    }

    public static int dijkstra(List<Map<Integer, Integer>> graph){
        int n = graph.size()-1;
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));

        Arrays.fill(dist, INF);

        // 1 初始化dist[1] = 0
        dist[1] = 0;
        pq.offer(new int[]{1, 0});

        //
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];

            // 若当前的节点已经确定为最短路径，那么就不继续更新临边的最短距离了
            if(visited[curNode])    continue;
            visited[curNode] = true;

            for(Integer next: graph.get(curNode).keySet()){
                int nextVal = graph.get(curNode).get(next);
                if(dist[next] > dist[curNode] + nextVal){
                    dist[next] = dist[curNode] + nextVal;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }


        return dist[n] == INF?-1:dist[n];
    }
}

