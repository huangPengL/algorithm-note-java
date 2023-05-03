package greedy;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/3 13:37
 */
import java.util.*;
import java.io.*;

public class _01MaxNotIntersectInterval {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split(" ");

            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }


        // 按照右端点排序
        Arrays.sort(arr, (a,b)->a[1]-b[1]);
        int ans = 0;
        int cur = -1;
        for(int i=0,j=1;i<n;){
            ans++;
            cur = arr[i][1];
            while(j < n && arr[j][0] <= cur){
                j++;
            }
            i = j;
        }
        System.out.println(ans);
    }
}
