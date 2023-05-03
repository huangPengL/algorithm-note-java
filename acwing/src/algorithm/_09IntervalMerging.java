package algorithm;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/21 22:01
 */
import java.util.*;

public class _09IntervalMerging {
    public static void main(String[] args){

        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        // 按照左端点进行排序
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        int l = arr[0][0];
        int r = arr[0][1];
        int count = 0;
        for(int i=1;i<n;i++){
            // 若当前区间和前一个合并区间具有被包含，交集关系则合并两个区间
            if(arr[i][0] <= r){
                r = Math.max(r,arr[i][1]);
            }
            else{
                l = arr[i][0];
                r = arr[i][1];
                count++;
            }
        }
        count++;
        System.out.println(count);

    }
}