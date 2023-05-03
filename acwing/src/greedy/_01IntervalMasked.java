package greedy;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/7 19:11
 */
import java.util.*;
import java.io.*;


/*
1 将所有区间按照左端点从小到大进行排序

2 从前往后枚举每个区间，在所有能覆盖start的区间中，选择右端点的最大区间，然后将start更新成右端点的最大值

*/
public class _01IntervalMasked {
    private static int INF = 0x3f3f3f3f;
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int start = Integer.parseInt(ss1[0]);
        int end = Integer.parseInt(ss1[1]);

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            String[] ss2 = br.readLine().split(" ");

            int a = Integer.parseInt(ss2[0]);
            int b = Integer.parseInt(ss2[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }


        // 按照左端点排序
        Arrays.sort(arr, (a,b)->a[0]-b[0]);

        // 从前往后枚举每个区间，在所有能覆盖start的区间中，选择右端点的最大区间，然后将start更新成右端点的最大值
        int ans = 0;
        int curStart = start;
        for(int j=0;j<n;){
            int rightMax = -INF;

            // 对于所有左端点比curStart小的区间，如果可以覆盖curStart那么记录其右端点
            while(j < n && arr[j][0] <= curStart){
                if(arr[j][1] >= curStart)
                    rightMax = Math.max(rightMax, arr[j][1]);
                j++;
            }

            // 如果对于所有左端点比curStart小的区间都找不到一个可以覆盖curStart的区间，那么就说明无解
            if(rightMax == -INF){
                System.out.println("-1");
                return;
            }

            // 否则，更新curStart
            curStart = rightMax;
            ans++;

            if(curStart >= end){
                break;
            }

        }

        if(curStart>=end){
            System.out.println(ans);
        }
        else{
            System.out.println("-1");
        }
    }
}
