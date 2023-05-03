package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/17 16:51
 **/

/*
    AcWing 795. 前缀和
    (1)元素：1-n,存储在arr[1-n]中
    (2)计算前缀和：sum[i] = sum[i-1] + arr[i];
    (3)前缀和有什么用？可以快速计算某一个区间的和
        - 计算[i,j]的和 sum[j]-sum[i-1]
        - 计算[i,j)的和 sum[j-1] - sum[i-1]
        - 计算(i,j)的和 sum[j-1] - sum[i]

 */
import java.util.*;
public class _05SumOfPrefixes {
    public static void main(String[] arges){

        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();

        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = in.nextInt();
        }

        // 计算前缀和
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1] + arr[i];
        }

        // 输出
        while((q--) != 0){
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(sum[r]-sum[l-1]);
        }

    }
}
