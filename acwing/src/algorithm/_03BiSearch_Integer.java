package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/15 15:43
 **/
import java.io.*;

/*
AcWing 789. 数的范围
 */
public class _03BiSearch_Integer{
    public static void main(String[] args) throws IOException{

        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);

        int[] arr = new int[n];
        String[] s2 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s2[i]);
        }

        // 输出
        for(int i=0;i<q;i++){
            int curq = Integer.parseInt(br.readLine());

            int leftIndex = checkLeft(arr,curq);
            if(leftIndex == -1){
                System.out.println("-1 -1");
                continue;
            }
            int rightIndex = checkRight(arr,curq);
            System.out.println(leftIndex + " " + rightIndex);
        }
        br.close();
    }
    // 二分模板1
    public static int checkLeft(int[] arr,int target){
        int l = 0;
        int r = arr.length-1;

        while(l < r){
            // 第三步：确定二分答案的位置
            int mid = (l+r)/2;
            // 第一步：保证某个区间一定有答案target
            if(arr[mid] >= target){
                // 第二步：确定窗口缩小的方向
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return arr[r] == target ? r : -1;
    }
    // 二分模板2
    public static int checkRight(int[] arr,int target){
        int l = 0;
        int r = arr.length-1;

        while(l < r){
            int mid = (l+r+1)/2;
            if(arr[mid] <= target){
                l = mid;
            }
            else{
                r = mid - 1;
            }
        }
        return arr[l] == target ? l : -1;
    }
}
