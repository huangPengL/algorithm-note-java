package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/18 21:55
 **/
import java.util.*;
import java.io.*;

/*
797. 差分
 */

public class _05DifferenceArray {
    private static int N;
    public static void main(String[] args) throws IOException{
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        N = n+10;

        int[] a = new int[N];
        for(int i=1;i<=n;i++){
            a[i] = in.nextInt();
        }

        int[] b = new int[N];
        while(q-- != 0){
            int l = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            insertDiff(b,l,r,c);
        }

        for(int i=1;i<=n;i++){
            b[i] += b[i-1];
        }

        for(int i=1;i<=n;i++){
            a[i] += b[i];
        }


        for(int i=1;i<=n;i++){
            if(i != n)
                System.out.print(a[i]+" ");
            else
                System.out.print(a[i]);
        }
    }

    public static void insertDiff(int[] arr, int l, int r, int val){
        arr[l] += val;
        arr[r+1] -= val;
    }
}
