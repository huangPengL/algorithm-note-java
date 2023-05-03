package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/9 19:59
 **/
import java.io.*;

/*
AcWing 786. 第k个数
 */
public class _01QuickSelect {
    public static void main(String[] args) throws IOException{

        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int N = Integer.parseInt(ss1[0]);
        int k = Integer.parseInt(ss1[1]);

        String[] ss2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(ss2[i]);
        }

        //
        System.out.println(quickSort(arr,0,N-1,k));
        br.close();
    }

    public static int quickSort(int[] arr,int l,int r,int k){
        if(l == r)  return arr[l];

        int i = l-1;
        int j = r+1;
        int x = arr[l];
        while(i < j){
            while(arr[++i] < x);
            while(arr[--j] > x);

            if(i < j){
                swap(arr,i,j);
            }
        }

        int D1 = j-l+1;         // 计算划分好的左区间长度是多少
        // 若左区间长度大于等于k，那么第k个数字在左区间。否则在右区间
        if(D1 >= k)     return quickSort(arr,l,j,k);
            // 如果第k个数字在右区间，那么这第k个数字在排序好的右区间中为第k-D1个
        else            return quickSort(arr,j+1,r,k-D1);
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}