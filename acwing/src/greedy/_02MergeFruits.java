package greedy;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/9 22:42
 */
import java.util.*;
import java.io.*;

public class _02MergeFruits{
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] ss = br.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.offer(Integer.parseInt(ss[i]));
        }

        long ans = 0;
        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();
            ans += a + b;
            pq.offer(a+b);
        }
        System.out.println(ans);
    }
}
