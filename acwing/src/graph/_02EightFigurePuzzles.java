package graph;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/14 22:07
 */
import java.util.*;
import java.io.*;


/*
    【思路】：
        不断模拟当前状态转移到下一个状态，直到转移到最终的答案
    【状态表示】：
        使用一维的字符数组存储,如："123x46758"

    【状态转移】:
        对于当前状态 "123x46758", 其二维表示为：
        1 2 3
        x 4 6
        7 5 8
        模拟x上下左右移动，然后再转换成一维表示

    【实现】：
        1 Queue<String> 存储当前待处理的状态
        2 Map<String, Integer> 存储当前状态距离初始状态的步数

*/


/*
    【思路】：
        不断模拟当前状态转移到下一个状态，直到转移到最终的答案
    【状态表示】：
        使用一维的字符数组存储,如："123x46758"

    【状态转移】:
        对于当前状态 "123x46758", 其二维表示为：
        1 2 3
        x 4 6
        7 5 8
        模拟x上下左右移动，然后再转换成一维表示

    【实现】：
        1 Queue<String> 存储当前待处理的状态
        2 Map<String, Integer> 存储当前状态距离初始状态的步数

*/
public class _02EightFigurePuzzles {
    private static Map<String, String> parent = new HashMap<>();
    private static int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    private static String end = "12345678x";

    public static int bfs(String start){


        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        queue.offer(start);
        dist.put(start, 0);
        parent.put(start, "root");

        while(!queue.isEmpty()){
            String curStr = queue.poll();
            char[] cur = curStr.toCharArray();

            int curDist = dist.get(curStr);
            int index = getX(cur);

            int x = index / 3;
            int y = index % 3;

            // 查找下一个转移的状态
            for(int[] direction: directions){
                int nx = x + direction[0];
                int ny = y + direction[1];
                int nIndex = nx * 3 + ny;

                // 如果下一个状态合法
                if(nx>=0 && ny>=0 && nx<3 && ny<3){
                    swap(cur, index, nIndex);

                    String next = new String(cur);
                    // 如果下一个状态没走过
                    if(!dist.containsKey(next)){
                        queue.offer(next);
                        dist.put(next, curDist+1);
                        parent.put(next, new String(curStr));
                    }

                    // 如果找到了结果，那么返回最短距离
                    if(next.equals(end)){
                        return dist.get(end);
                    }
                    swap(cur, index, nIndex);           // 状态回溯
                }
            }
        }

        return -1;
    }

    public static int getX(char[] cur){
        for(int i=0;i<9;i++){
            if(cur[i] == 'x'){
                return i;
            }
        }
        return -1;
    }

    public static void swap(char[] cur, int i, int j){
        char temp = cur[i];
        cur[i] = cur[j];
        cur[j] = temp;
    }

    // 输出转移过程
    public static void printStep(){
        String cur = end;
        while(!cur.equals("root")){
            for(int i=0;i<cur.length();i++){
                System.out.print(cur.charAt(i)+" ");
                if((i + 1) % 3 == 0){
                    System.out.println();
                }
            }
            System.out.println();
            cur = parent.get(cur);
        }
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");

        char[] startCh = new char[9];
        int index = 0;
        for(int i=0;i<ss.length;i++){
            if(ss[i].length() == 0)    continue;
            startCh[index++] = ss[i].charAt(0);
        }
        String start = new String(startCh);

        // bfs
        int minStep = bfs(start);
        System.out.println(minStep+"\n");
        if(minStep!=-1){
            printStep();
        }
    }
}
