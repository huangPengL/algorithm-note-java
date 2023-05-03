package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/15 20:14
 */
import java.util.*;
import java.io.*;

public class _05TopologicalSort {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");

        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int[] inDegree = new int[n+1];

        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(ss2[0])).add(Integer.parseInt(ss2[1]));
            inDegree[Integer.parseInt(ss2[1])]++;
        }

        System.out.println(topologicalSort(graph, inDegree, n));
    }

    public static String topologicalSort(List<List<Integer>> graph, int[] inDegree, int n){
        Queue<Integer> queue = new LinkedList<>();

        // 入度为0的点入队
        for(int i=1;i<=n;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        // 将入度为0的点的临边进行删除
        StringBuilder ans = new StringBuilder();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans.append(cur).append(" ");

            for(Integer next: graph.get(cur)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }


        // 判断还有没有入度为0的点
        for(int i=1;i<=n;i++){
            if(inDegree[i] != 0){
                return "-1";
            }
        }
        return ans.toString();
    }
}
