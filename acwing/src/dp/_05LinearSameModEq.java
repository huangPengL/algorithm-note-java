package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/5/17 12:08
 */
import java.io.*;

public class _05LinearSameModEq {

    public static int x = -1;
    public static int y = -1;
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            int m = Integer.parseInt(ss[2]);

            int gcd = exgcd(a, m);
            if(b % gcd != 0){
                System.out.println("impossible");
            }
            else{
                System.out.println((long)x * ((long)b/gcd) % m);
            }
        }
    }

    public static int exgcd(int a, int b){
        if(b == 0){
            x = 1;
            y = 0;
            return a;
        }

        int ans = exgcd(b, a % b);

        int temp = x;
        x = y;
        y = temp - (a / b) * y;

        return ans;
    }
}
