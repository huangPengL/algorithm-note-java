package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/24 23:31
 */

import java.util.*;
import java.io.*;

public class _08SPFA {
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


        // spfa
        int ans = spfa(graph);
        if(ans == -INF){
            System.out.println("impossible");
        }
        else{
            System.out.println(ans);
        }
    }

    public static int spfa(List<Map<Integer, Integer>> graph){
        int n = graph.size()-1;
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(dist, INF);

        // 1 初始化dist[1] = 0
        dist[1] = 0;
        queue.offer(1);
        visited[1] = true;

        // 2
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = false;

            // 如果更新了某一条边，那就把这个被更新的点加入队列，因为他最有可能更新其他节点。
            for(Integer next: graph.get(cur).keySet()){
                int nextVal = graph.get(cur).get(next);
                if(dist[next] > dist[cur] + nextVal){
                    dist[next] = dist[cur] + nextVal;

                    if(!visited[next]){
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }


        return dist[n] == INF?-INF:dist[n];
    }
}

