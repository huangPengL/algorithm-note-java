package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/6 23:11
 */
import java.io.*;


/*
    并查集维护当前节点到根节点的距离dist：
    1 dist % 3 == 0 则和根节点同类
    2 dist % 3 == 1 则可以吃掉根节点的类别
    3 dist % 3 == 2 则可以被根节点吃掉的类别
*/
public class _09FoodChain {
    public static int[] parent = new int[50010];
    public static int[] dist = new int[50010];

    public static void init(){
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(parent[x] != x){
            int t = find(parent[x]);
            dist[x] += dist[parent[x]];
            parent[x] = t;
        }
        return parent[x];
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int k = Integer.parseInt(ss1[1]);

        // 初始化并查集
        init();


        // 读取每一句话，判断是真是假
        int ans = 0;
        for(int i=0;i<k;i++){
            String[] ss2 = br.readLine().split(" ");
            int type = Integer.parseInt(ss2[0]);
            int x = Integer.parseInt(ss2[1]);
            int y = Integer.parseInt(ss2[2]);

            // 当前的话中 X 或 Y 比 N 大，就是假话；
            if(x > n || y > n){
                ans++;
                continue;
            }

            // 找到x和y的根节点，顺便路径压缩
            int px = find(x);
            int py = find(y);

            if(type == 1){
                // 如果x和y在同一个集合
                if(px == py){
                    // 如果x和y不是同一个类型,那么这句话为假话
                    if((dist[x] - dist[y]) % 3 != 0){
                        ans++;
                    }
                }
                // 如果x和y在不同集合，说明这句话在此之前没出现过，无法判断为假话，则定为真话
                else{
                    parent[px] = py;                // 左边集合合并到右边集合中
                    dist[px] = dist[y] - dist[x];   // 更新左集合的根节点到右集合根节点的距离
                }
            }
            else{
                // 如果x和y在同一个集合
                if(px == py){
                    // 如果x和y不是同一个类型,那么这句话为假话
                    if((dist[x] - dist[y] - 1) % 3 != 0){
                        ans++;
                    }
                }
                // 如果x和y在不同集合，说明这句话在此之前没出现过，无法判断为假话，则定为真话
                else{
                    parent[px] = py;                // 左边集合合并到右边集合中
                    dist[px] = dist[y] + 1 - dist[x];   // 更新左集合的根节点到右集合根节点的距离
                }
            }

        }
        System.out.println(ans);
    }
}
