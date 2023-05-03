package algorithm;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/21 23:26
 */
import java.util.*;
import java.io.*;

public class _02GetReversePair {
    public static void main(String[] args) throws IOException{
        // 输入
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)    arr[i] = in.nextInt();

        // 求逆序对
        System.out.println(getReversePair(arr,0,n-1));
    }

    public static long getReversePair(int[] arr,int l,int r){
        if(l >= r){
            return 0;
        }

        int mid = l + ((r-l)>>1);
        long ans = 0;
        ans += getReversePair(arr,l,mid) + getReversePair(arr,mid+1,r);
        ans += merge(arr,l,mid,r);
        return ans;
    }
    public static long merge(int[] arr,int l,int mid,int r){

        int i = l,j = mid+1;

        int index = 0;
        int[] temp = new int[r-l+1];
        long sum = 0;
        while(i<=mid && j<=r){
            if(arr[i] > arr[j]){
                temp[index++] = arr[j++];
                sum += (long)mid-(long)i+1;
            }
            else{
                temp[index++] = arr[i++];
            }
        }

        while(i<=mid)   temp[index++] = arr[i++];
        while(j<=r)     temp[index++] = arr[j++];

        index = 0;
        for(int k=l;k<=r;k++){
            arr[k] = temp[index++];
        }

        return sum;
    }
}
