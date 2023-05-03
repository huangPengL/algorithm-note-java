package algorithm;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/20 22:12
 */
import java.util.*;
import java.io.*;

public class _08DiscretizationIntervalSum {
    public static void main(String[] args) throws IOException{
        // 输入
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> set = new HashSet<>();
        int[][] add = new int[n][2];
        int[][] query = new int[m][2];

        // 提前读入添加操作和查询操作
        for(int i=0;i<n;i++){
            add[i][0] = in.nextInt();
            add[i][1] = in.nextInt();
            set.add(add[i][0]);
        }
        for(int i=0;i<m;i++){
            query[i][0] = in.nextInt();
            query[i][1] = in.nextInt();
            set.add(query[i][0]);
            set.add(query[i][1]);
        }

        // 构建离散化数组并进行排序
        int arrLen = set.size();
        int[] arr = new int[arrLen];
        int index = 0;
        for(int num: set)  arr[index++] = num;
        Arrays.sort(arr);

        // 在差分数组中执行添加值操作
        int[] diff = new int[arrLen];
        for(int i=0;i<n;i++){
            int k = find(arr,add[i][0]);
            diff[k] += add[i][1];
        }

        // 计算前缀和数组
        int[] sum = new int[arrLen];
        sum[0] = diff[0];
        for(int i=1;i<arrLen;i++){
            sum[i] = sum[i-1] + diff[i];
        }

        // 执行查询操作，输出答案
        for(int i=0;i<m;i++){
            int l = find(arr,query[i][0]);
            int r = find(arr,query[i][1]);

            if(l == 0){ // 避免溢出
                System.out.println(sum[r]);
                continue;
            }
            System.out.println(sum[r]-sum[l-1]);
        }
    }

    // 找到arr中大于等于target数字的下表
    public static int find(int[] arr,int target){
        int l = 0,r = arr.length-1;
        while(l < r){
            int mid = l+((r-l)>>1);
            if(arr[mid] >= target){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}
