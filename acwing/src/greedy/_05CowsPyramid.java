package greedy;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/14 17:54
 */
import java.util.*;
import java.io.*;

public class _05CowsPyramid {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] cows = new int[n][2];
        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split(" ");
            cows[i][0] = Integer.parseInt(ss[0]);
            cows[i][1] = Integer.parseInt(ss[1]);
        }

        // 排序
        Arrays.sort(cows, (a,b)->a[0]+a[1]-b[0]-b[1]);

        long ans = -cows[0][1];
        long sum = 0;
        for(int i=1;i<n;i++){
            sum += cows[i-1][0];
            ans = Math.max(ans, sum-cows[i][1]);
        }
        System.out.println(ans);
    }
}
