package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/15 15:56
 **/
/*
AcWing 790. 数的三次方根
 */
import java.io.*;

public class _03BiSearch_Double {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());

        //
        double l = -100;
        double r = 100;

        while(r-l >= 1e-8){         // 比要求的精度小2位，避免出现精度不足的问题
            double mid = l + ((r-l))/2;
            if(mid*mid*mid >= n){
                r = mid;
            }
            else{
                l = mid;
            }
        }

        // 输出
        System.out.println(String.format("%.6f",r));
        br.close();
    }
}
