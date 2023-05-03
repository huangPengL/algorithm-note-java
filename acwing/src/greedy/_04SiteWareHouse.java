package greedy;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/9 23:47
 */
import java.util.*;
import java.io.*;

public class _04SiteWareHouse {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String[] ss = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(ss[i]);
        }

        //
        Arrays.sort(arr);
        long ans = 0;
        for(int i=0;i<n;i++){
            ans += Math.abs(arr[i] - arr[n/2]);
        }
        System.out.println(ans);
    }
}
