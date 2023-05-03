package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/9 19:52
 **/
import java.io.*;

/*
AcWing 785. 快速排序

 */
public class _01QuickSort{
    public static void main(String[] args) throws IOException{

        //  System.in ->字节流，通过通过 InputStreamReader 变成字符流
        // 再通过 BufferedReader 变成字符缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 向数组读入元素
        String[] ss = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(ss[i]);
        }

        quickSort(arr,0,N-1);
        for(int i = 0; i < N; i++){
            System.out.print(arr[i]+" ");
        }

        br.close();
    }

    public static void quickSort(int[] arr,int l, int r){
        if(l >= r)   return;    // 有一个元素的时候不需要排序

        int i = l-1;            // 由于两个指针先移动再判断，因此初始化时应该偏移一个单位
        int j = r+1;

        int x = arr[l];         // 选取待分割的元素
        while(i < j){
            while(arr[++i] < x);
            while(arr[--j] > x);
            if(i < j){
                swap(arr,i,j);
            }
        }
        quickSort(arr,l,j);
        quickSort(arr,j+1,r);
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
