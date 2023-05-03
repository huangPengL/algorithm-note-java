package greedy;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/7 18:01
 */
import java.util.*;
import java.io.*;

public class _01IntervalGrouping {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 读取区间
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(ss[0]);
            arr[i][1] = Integer.parseInt(ss[1]);
        }

        // 根据区间的左端点进行排序
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a-b);
        for(int i=0;i<n;i++){
            if(pq.isEmpty() || pq.peek() >= arr[i][0]){
                pq.offer(arr[i][1]);
            }
            else{
                pq.poll();
                pq.offer(arr[i][1]);
            }
        }
        System.out.println(pq.size());
    }
}
