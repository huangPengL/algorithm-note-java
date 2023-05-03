package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/4 17:02
 */
import java.util.*;
import java.io.*;

public class _10SetNim {
    public static int[] dp = new int[10001];
    public static int SG(int num, int[] nums){
        if(dp[num] != -1){
            return dp[num];
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(num >= nums[i])
                set.add(SG(num - nums[i], nums));
        }

        for(int i=0;;i++){
            if(!set.contains(i)){
                dp[num] = i;
                break;
            }
        }
        return dp[num];
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] ss1 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(ss1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] ss2 = br.readLine().split(" ");

        // 计算每一个集合的SG值，并且异或起来
        int ans = 0;
        Arrays.fill(dp, -1);
        for(int i=0;i<m;i++){
            ans ^= SG(Integer.parseInt(ss2[i]), nums);
        }

        if(ans == 0)    System.out.println("No");
        else    System.out.println("Yes");

    }
}
