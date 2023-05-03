package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/12 13:17
 */
import java.io.*;

public class _03GetEuler {

    // 利用公式求欧拉函数
    public static int getEuler(int n){
        int ans = n;
        for(int i=2;i<=n/i;i++){
            if(n % i == 0){
                ans = ans / i * (i-1);
                while(n % i == 0){
                    n /= i;
                }
            }
        }
        if(n > 1){
            ans = ans / n * (n-1);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- != 0){
            int num = Integer.parseInt(br.readLine());

            System.out.println(getEuler(num));
        }
    }
}