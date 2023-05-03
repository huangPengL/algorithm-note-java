package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/5 17:25
 */
import java.util.*;
import java.io.*;

public class _013ColorJudgeBinaryGraph {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);

        // 建图
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new HashSet<>());
        }
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(ss2[0])).add(Integer.parseInt(ss2[1]));
        }

        // 染色法
        int[] visited = new int[n+2];
        for(int i=1;i<=n;i++){
            if(graph.get(i).size() != 0){
                if(visited[i] == 0 && !dfs(i, graph, 1, visited)){
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }

    public static boolean dfs(int cur, List<Set<Integer>> graph, int color, int[] visited){
        visited[cur] = color;
        for(Integer next: graph.get(cur)){
            if(visited[next] == 0 && !dfs(next, graph, -color, visited)){
                return false;
            }
            else if(visited[next] == color){
                return false;
            }
        }
        return true;
    }
}
