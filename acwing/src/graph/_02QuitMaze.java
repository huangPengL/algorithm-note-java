package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/12 23:04
 */
import java.util.*;
import java.io.*;

public class _02QuitMaze {
    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1},{0, -1}};

    public static int bfs(int[][] graph, int n, int m){
        boolean[][] visited = new boolean[n+1][m+1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 1});
        visited[1][1] = true;
        int layer = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int[] cur = queue.poll();
                if(cur[0] == n && cur[1] == m){
                    return layer;
                }
                for(int[] direction: directions){
                    int nx = cur[0] + direction[0];
                    int ny = cur[1] + direction[1];
                    if(nx>=1 && ny>=1 && nx<=n && ny<=m && !visited[nx][ny] && graph[nx][ny] == 0){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            layer++;
        }
        return layer;
    }
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");

        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        int[][] graph = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            String[] ss2 = br.readLine().split(" ");
            for(int j=1;j<=m;j++){
                graph[i][j] = Integer.parseInt(ss2[j-1]);
            }
        }

        System.out.println(bfs(graph, n, m));
    }
}
