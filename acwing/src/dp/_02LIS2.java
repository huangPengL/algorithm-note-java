package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/17 19:28
 */
import java.io.*;

public class _02LIS2 {
    public static int biSearch(int[] queue, int target, int len){
        int l = 0;
        int r = len-1;
        while(l < r){
            int mid = l + ((r-l)>>1);
            if(queue[mid] >= target){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(ss[i]);

        // 初始化，如果数组只有一个元素，那这个元素组成LIS
        int[] queue = new int[n];
        queue[0] = arr[0];

        // 枚举数组第i个元素，找出第一个大于等于这个元素的位置（这个元素组成的LIS长度）
        int len = 1;
        for(int i=1;i<n;i++){
            if(arr[i] > queue[len-1]){
                queue[len++] = arr[i];
            }
            else{
                int index = biSearch(queue, arr[i], len);
                queue[index] = arr[i];
            }
        }

        System.out.println(len);
    }
}