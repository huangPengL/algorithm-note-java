package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/15 14:20
 **/
import java.io.*;

/*
AcWing 787. 归并排序
 */
public class _02mergeSort{
    private static int[] temp;
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        temp = new int[n];
        String[] ss = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(ss[i]);
        }

        //
        mergeSort(arr,0,n-1);

        //输出
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        br.close();
    }
    public static void mergeSort(int[] arr, int l,int r){
        if(l >= r)  return;

        int mid = l + ((r-l)>>1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);

        merge(arr,l,mid,r);
    }

    public static void merge(int[] arr,int l,int mid,int r){
        int i = l;
        int j = mid+1;

        int index = 0;
        while(i < mid+1 && j < r+1){
            temp[index++] = arr[i]<=arr[j]?arr[i++]:arr[j++];
        }

        while(i < mid+1)    temp[index++] = arr[i++];
        while(j < r+1)      temp[index++] = arr[j++];


        for(i = l,index = 0;i<=r;i++,index++){
            arr[i] = temp[index];
        }
    }
}
