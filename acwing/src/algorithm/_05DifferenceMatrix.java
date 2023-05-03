package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/9 19:59
 **/

import java.io.IOException;
import java.util.*;

/*
798. 差分矩阵
 */
public class _05DifferenceMatrix {
    public static void main(String[] args) throws IOException{
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        int[][] arr = new int[n+10][m+10];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i][j] = in.nextInt();
            }
        }

        // 构造arr矩阵的差分矩阵diff
        int[][] diff = new int[n+10][m+10];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                insert(diff,i,j,i,j,arr[i][j]);
            }
        }

        while(q-- != 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            insert(diff,x1,y1,x2,y2,in.nextInt());
        }

        // 计算差分矩阵的前缀和
        int[][] sum = new int[n+10][m+10];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + diff[i][j];
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }


    }

    // 构造，计算差分矩阵的模板
    public static void insert(int[][] diff,int x1,int y1,int x2,int y2,int c){
        diff[x1][y1] += c;
        diff[x1][y2+1] -= c;
        diff[x2+1][y1] -= c;
        diff[x2+1][y2+1] += c;
    }
}