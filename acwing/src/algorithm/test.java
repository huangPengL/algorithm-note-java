package algorithm;


/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/5/3 16:03
 */
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class test {
    private static int n;
    private static int m;
    private static int[][] graph;
    private static int ans = -0x3f3f3f3f;
    private static int[][] directions = new int[][]{{0, 1},{0, 2},{0, 3},{1, 0}, {2, 0}, {3, 0}};
    private static int[][] cache;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new int[n][m];
        cache = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cache[i][j] = Integer.MIN_VALUE;
                graph[i][j] = scan.nextInt();
            }
        }

        System.out.println(dfs(0, 0));
        scan.close();
    }

    public static int dfs(int x, int y){
        if(x == n-1 && y == m-1){
            return graph[x][y];
        }
        if(cache[x][y] != Integer.MIN_VALUE){
            return cache[x][y];
        }

        int curMax = Integer.MIN_VALUE;
        for(int[] direction: directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                curMax = Math.max(curMax, graph[x][y] + dfs(nx, ny));
            }
        }
        cache[x][y] = curMax;
        return curMax;
    }
}