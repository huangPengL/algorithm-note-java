package graph;import java.util.*;
import java.io.*;

/*

【spfa判断负环的原理】：
在原图的基础上新建一个虚拟源点，从该点向其他所有点连一条权值为0的有向边。那么原图有负环等价于新图有负环。
此时在新图上做spfa，将虚拟源点加入队列中。然后进行spfa的第一次迭代，这时会将所有点的距离更新并将所有点插入队列中。
执行到这一步，就等价于视频中的做法了。
那么视频中的做法可以找到负环，等价于这次spfa可以找到负环，等价于新图有负环，等价于原图有负环。得证。
1、dist[x] 记录虚拟源点到x的最短距离
2、cnt[x] 记录当前x点到虚拟源点最短路的边数，初始每个点到虚拟源点的距离为0，只要他能再走n步，即cnt[x] >= n，
则表示该图中一定存在负环，由于从虚拟源点到x至少经过n条边时，
则说明图中至少有n + 1个点，表示一定有点是重复使用
3、若dist[j] > dist[t] + w[i],则表示从t点走到j点能够让权值变少，因此进行对该点j进行更新，并且对应cnt[j] = cnt[t] + 1,往前走一步

*/
public class _09SPFAJudgeNegativeLoop {
    public static boolean spfaJudgeNegativeLoop(List<Map<Integer, Integer>> graph){
        int n = graph.size()-1;

        // 所有点到虚拟源点的距离（起始值为0）
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        // 当前节点i到虚拟源点的最短路的边数（起始值为0）
        int[] cnt = new int[n+1];


        // 将所有点入队，即认为将虚拟源点周围的点加入更新节点队列，让这些点更新其他节点
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.offer(i);
            visited[i] = true;
        }


        //spfa
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = false;

            for(Integer next: graph.get(cur).keySet()){
                int val = graph.get(cur).get(next);

                if(dist[next] > dist[cur] + val){
                    dist[next] = dist[cur] + val;
                    cnt[next] = cnt[cur] + 1;           // 更新next节点到虚拟源点的距离

                    if(cnt[next] >= n)  return true;
                    if(!visited[next]){
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)   graph.add(new HashMap<>());

        for(int i=0;i<m;i++){
            String[] ss2 = br.readLine().split(" ");
            int from = Integer.parseInt(ss2[0]);
            int to = Integer.parseInt(ss2[1]);
            int val = Integer.parseInt(ss2[2]);

            if(graph.get(from).containsKey(to) && graph.get(from).get(to) >= val)   continue;

            graph.get(from).put(to, val);
        }

        boolean flag = spfaJudgeNegativeLoop(graph);
        if(flag){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}