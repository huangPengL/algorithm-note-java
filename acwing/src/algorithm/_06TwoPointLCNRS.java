package algorithm;

import java.util.*;

/**
    【最长连续不重复子序列】
    根据某些限制和性质，把暴力的O(n^2)降低到O(n)
 */
public class _06TwoPointLCNRS {
    public static void main(String[] args){
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n+10];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        int[] bucket = new int[100010];
        int ans = 1;
        // 双指针处理
        for(int i=0,j=0;i<n;i++){
            bucket[arr[i]]++;
            while(bucket[arr[i]] > 1){
                bucket[arr[j]]--;
                j++;
            }
            ans = Math.max(ans,i-j+1);
        }

        System.out.println(ans);
    }
}