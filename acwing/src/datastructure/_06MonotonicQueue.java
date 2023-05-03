package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/23 20:37
 */
import java.util.*;
import java.io.*;

public class _06MonotonicQueue {
    public static void main(String[] args) throws IOException{
        // 输入（使用Scanner读入会超时）
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        String[] ss2 = br.readLine().split(" ");

        int n = Integer.parseInt(ss1[0]);
        int k = Integer.parseInt(ss1[1]);

        int[] arr = new int[n];
        for(int i=0;i<n;i++)    arr[i] = Integer.parseInt(ss2[i]);


        // 维护一个单调递增的队列
        Deque<Integer> queueIncr = new LinkedList<>();
        // 维护一个单调递减的队列
        Deque<Integer> queueDecr = new LinkedList<>();
        int[] ans1 = new int[n-k+1];
        int[] ans2 = new int[n-k+1];
        int index = 0;
        for(int i=0;i<n;i++){

            // 维护两个单调队列
            while(!queueIncr.isEmpty() && arr[i] <= arr[queueIncr.peekLast()]){
                queueIncr.pollLast();
            }
            queueIncr.offerLast(i);

            while(!queueDecr.isEmpty() && arr[i] >= arr[queueDecr.peekLast()]){
                queueDecr.pollLast();
            }
            queueDecr.offerLast(i);

            // 输出结果之前判断不满足要求的队头是否滑出了窗口
            if(!queueIncr.isEmpty() && queueIncr.peekFirst() < i-k+1){
                queueIncr.pollFirst();
            }
            if(!queueDecr.isEmpty() && queueDecr.peekFirst() < i-k+1){
                queueDecr.pollFirst();
            }

            if(i >= k-1){
                ans1[index] = arr[queueIncr.peekFirst()];
                ans2[index] = arr[queueDecr.peekFirst()];
                index++;
            }
        }


        for(int i=0;i<index;i++){
            System.out.print(ans1[i]+" ");
        }
        System.out.println();
        for(int i=0;i<index;i++){
            System.out.print(ans2[i]+" ");
        }
    }
}
