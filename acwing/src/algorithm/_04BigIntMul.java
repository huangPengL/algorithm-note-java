package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/17 15:56
 **/
import java.util.*;
import java.math.*;
import java.io.*;

public class _04BigIntMul {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder a = new StringBuilder(br.readLine()).reverse();
        int b = Integer.parseInt(br.readLine());

        StringBuilder c =  mul(a,b);

        // 输出
        for(int i=0;i<c.length();i++){
            System.out.print(c.charAt(i));
        }

        br.close();
    }

    // 大数a乘以小数b
    public static StringBuilder mul(StringBuilder a,int b){
        if(b == 0)  return new StringBuilder("0");
        List<Boolean> list = new ArrayList<>();

        StringBuilder c = new StringBuilder();
        int t = 0;
        for(int i=0;i<a.length();i++){
            t = (a.charAt(i)-'0')*b+t;
            c.append(t % 10);
            t = t / 10;
        }

        // 若还有进位则将其添加在结果中
        // !!!以下注释的写法是错误的!!!
        // if(t != 0)  c.append(t);
        while(t != 0){
            c.append(t%10);
            t = t/10;
        }

        // 逆转c
        return c.reverse();
    }
}
