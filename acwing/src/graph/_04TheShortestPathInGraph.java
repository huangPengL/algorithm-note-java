package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/15 19:44
 */
import java.util.*;
import java.io.*;

public class _04TheShortestPathInGraph {

    public static int bfs(List<List<Integer>> graph, int n){

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        dist[1] = 0;
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){

            int cur = queue.poll();

            for(Integer next: graph.get(cur)){
                if(!visited[next]){
                    dist[next] = 1 + dist[cur];
                    queue.offer(next);
                    visited[next] = true;
                }
            }

        }
        return dist[n];
    }
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");

        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(ss2[0])).add(Integer.parseInt(ss2[1]));
        }

        System.out.println(bfs(graph, n));
    }
}