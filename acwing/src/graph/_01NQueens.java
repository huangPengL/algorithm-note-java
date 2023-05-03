package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/12 22:03
 */
import java.util.*;
import java.io.*;

public class _01NQueens {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] path = new char[n][n];
        for(int i=0;i<n;i++)    Arrays.fill(path[i], '.');
        boolean[] col = new boolean[n];
        boolean[] dg = new boolean[2*n];    // ↗对角线
        boolean[] udg = new boolean[2*n];   // ↖对角线
        dfs(0, n, path, col, dg, udg);

    }

    // cur表示考虑在当前行放置皇后Q
    public static void dfs(int cur, int n, char[][] path, boolean[] col, boolean[] dg, boolean[] udg){
        if(cur == n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(path[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int j=0;j<n;j++){
            if(!col[j] && !dg[cur+j] && !udg[cur+n-j]){        // 如果当前列，当前的两条对角线都没有放皇后，则放置皇后

                col[j] = true;
                dg[cur+j] = true;
                udg[cur+n-j] = true;
                path[cur][j] = 'Q';

                dfs(cur+1, n, path, col, dg, udg);

                col[j] = false;
                dg[cur+j] = false;
                udg[cur+n-j] = false;
                path[cur][j] = '.';

            }
        }
    }
}
