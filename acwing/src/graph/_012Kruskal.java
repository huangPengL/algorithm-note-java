package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/4/5 14:26
 */
import java.util.*;
import java.io.*;

public class _012Kruskal {
    private static final int INF = 0X3F3F3F3F;
    private static int[] parent;
    private static int size;

    public static void initUnionFind(int n){
        parent = new int[n+1];
        size = n;

        for(int i=1;i<=n;i++)   parent[i] = i;
    }

    public static int find(int n){
        if(parent[n] != n){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public static void merge(int n1, int n2){
        int root1 = find(n1);
        int root2 = find(n2);
        if(root1 != root2){
            parent[root2] = root1;
            size--;
        }
    }

    public static int getCount(){
        return size;
    }

    public static int kruskal(PriorityQueue<int[]> pq, int n){
        // 初始化并查集
        initUnionFind(n);

        // Kruskal算法选取一条有效的边
        int ans = 0;
        while(!pq.isEmpty() && getCount() != 1){        // 找到最小生成树就退出来
            int[] cur = pq.poll();
            int from = cur[0];
            int to = cur[1];
            int val = cur[2];

            if(find(from) == find(to))  continue;
            merge(from, to);
            ans += val;
        }

        if(getCount() == 1){
            return ans;
        }
        return INF;
    }

    public static void main(String[] args) throws IOException{

        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);

        // 使用Kruskal无需建图
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            int from = Integer.parseInt(ss2[0]);
            int to = Integer.parseInt(ss2[1]);
            int val = Integer.parseInt(ss2[2]);
            if(from == to)  continue;
            pq.offer(new int[]{from, to, val});
        }

        // Kruskal求最小生成树的路径和
        int ans = kruskal(pq, n);
        if(ans == INF)
            System.out.println("impossible");
        else
            System.out.println(ans);
    }
}

