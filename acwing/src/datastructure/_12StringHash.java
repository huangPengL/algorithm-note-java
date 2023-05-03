package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/1 23:18
 */
import java.io.*;

public class _12StringHash {
    static int N = 100010;
    static int P = 131;                     // 经验值取131
    static long[] hashSum = new long[N];    // 存储字符串s的前缀hash值
    static long[] p = new long[N];          // 存储p[i]表示131^i


    // 取得字符串s中某一段字串的hash值
    public static long getHash(int l, int r){
        long ans = hashSum[r] - hashSum[l-1] * p[r-l+1];
        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        String str = br.readLine();

        // 计算字符串前缀hash值
        p[0] = 1;
        for(int i=1;i<=n;i++){
            p[i] = p[i-1] * P;
            hashSum[i] = hashSum[i-1] * P + str.charAt(i-1);
        }

        // 查询
        StringBuilder ans = new StringBuilder();
        while(m-- != 0){
            String[] ss2 = br.readLine().split(" ");
            int l1 = Integer.parseInt(ss2[0]);
            int r1 = Integer.parseInt(ss2[1]);
            int l2 = Integer.parseInt(ss2[2]);
            int r2 = Integer.parseInt(ss2[3]);

            if(getHash(l1,r1) == getHash(l2,r2)){
                ans.append("Yes\n");
            }
            else{
                ans.append("No\n");
            }
        }

        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans.toString());
    }
}