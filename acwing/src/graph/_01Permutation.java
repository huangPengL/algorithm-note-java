package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/12 22:03
 */
import java.io.*;

public class _01Permutation {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] path = new int[n];
        boolean[] visited = new boolean[n+1];
        dfs(0, path, visited, n);

    }

    public static void dfs(int curIndex, int[] path, boolean[] visited, int n){
        if(curIndex == n){
            for(int i=0;i<n;i++){
                if(i != 0){
                    System.out.print(" ");
                }
                System.out.print(path[i]);
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                path[curIndex] = i;
                visited[i] = true;
                dfs(curIndex+1, path, visited, n);
                visited[i] = false;
            }
        }
    }
}
