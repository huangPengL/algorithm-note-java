package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/22 16:43
 */

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/22 15:51
 */

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/19 22:11
 */
import java.util.*;
import java.io.*;

public class _07BellmanFord {
    private static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException{

        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int k = Integer.parseInt(ss[2]);

        int[][] edge = new int[m][3];
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            edge[i][0] = Integer.parseInt(ss2[0]);
            edge[i][1] = Integer.parseInt(ss2[1]);
            edge[i][2] = Integer.parseInt(ss2[2]);
        }

        // Bellman_ford
        bellman_ford(edge,n ,k);
    }

    public static void bellman_ford(int[][] edge,int n, int k){
        int m = edge.length;
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        //
        for(int i=0;i<k;i++){
            // 备份一个dist数组，避免发生最短距离串联
            int[] copyDist = Arrays.copyOf(dist, n+1);

            // 松弛操作
            for(int j=0;j<m;j++){
                int from = edge[j][0];
                int to = edge[j][1];
                int val = edge[j][2];

                // 用备份的dist数组来更新最短距离
                if(dist[to] > copyDist[from] + val){
                    dist[to] = copyDist[from] + val;
                }
            }
        }

        // Ps: 由于添加了限制条件：最多经过 k 条边的最短距离。

        // 判断是否没有答案
        /*
            在下面代码中，是否能到达n号点的判断中需要进行if(dist[n] > INF/2)判断，而并非是if(dist[n] == INF)判断，
            原因是INF是一个确定的值，并非真正的无穷大，会随着其他数值而受到影响，
            dist[n]大于某个与INF相同数量级的数即可
        */
        if(dist[n] > INF / 2){
            System.out.println("impossible");
        }
        else{
            System.out.println(dist[n]);
        }
    }
}


