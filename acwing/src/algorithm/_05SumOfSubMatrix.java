package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/18 21:10
 **/
import java.util.*;
import java.io.*;

public class _05SumOfSubMatrix {
    public static void main(String[] args) throws IOException{
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        int[][] arr = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i][j] = in.nextInt();
            }
        }

        // 计算二维前缀和，sum[i][j]表示左上角矩形(1,1)到(i,j)的和
        int[][] sum = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }

        // 求解
        while(q-- != 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
        }
    }
}
