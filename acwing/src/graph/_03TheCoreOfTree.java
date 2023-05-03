package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/14 20:54
 */
import java.util.*;
import java.io.*;

public class _03TheCoreOfTree {
    private static int ans = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 建图(无向图)
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String[] ss = br.readLine().split(" ");
            graph.get(Integer.parseInt(ss[0])).add(Integer.parseInt(ss[1]));
            graph.get(Integer.parseInt(ss[1])).add(Integer.parseInt(ss[0]));
        }

        // dfs求答案
        dfs(1, n, new boolean[n+1], graph);

        System.out.println(ans);
    }

    public static int dfs(int cur, int n, boolean[] visited,  List<List<Integer>> graph){
        visited[cur] = true;

        int curAns = 0;
        int curSize = 1;
        for(Integer next: graph.get(cur)){
            if(!visited[next]){
                int childSize = dfs(next, n, visited, graph);
                curAns = Math.max(curAns, childSize);       // 对于当前节点的点数，求其子树数量的最大值
                curSize += childSize;
            }
        }

        curAns = Math.max(curAns, n-curSize);       // 对于当前节点的点数，与其父树相比取最大值
        ans = Math.min(ans, curAns);
        return curSize;
    }
}