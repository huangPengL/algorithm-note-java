package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/5 21:33
 */
import java.util.*;
import java.io.*;

public class _014MaxMatchInBinaryGraph {
    public static int[] match = new int[510];
    public static boolean[] visited = new boolean[510];

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 存图（只需要存储u指向v的路径）
        String[] ss1 = br.readLine().split(" ");
        int n1 = Integer.parseInt(ss1[0]);
        int n2 = Integer.parseInt(ss1[1]);
        int m = Integer.parseInt(ss1[2]);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n1;i++)  graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(ss2[0])).add(Integer.parseInt(ss2[1]));
        }

        // 匈牙利算法
        int ans = 0;
        for(int i=1;i<=n1;i++){
            Arrays.fill(visited, false);
            if(find(i, graph)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    //这个函数的作用是用来判断,如果加入x来参与模拟配对,会不会使匹配数增多
    public static boolean find(int x, List<List<Integer>> graph){

        //遍历自己喜欢的女孩
        for(Integer next: graph.get(x)){

            //如果在这一轮模拟匹配中,这个女孩尚未被预定
            if(!visited[next]){
                //那x就预定这个女孩了
                visited[next] = true;

                //如果女孩j没有男朋友，或者她原来的男朋友能够预定其它喜欢的女孩。配对成功
                if(match[next]==0 || find(match[next], graph)){
                    match[next] = x;
                    return true;
                }
            }
        }
        return false;
    }
}