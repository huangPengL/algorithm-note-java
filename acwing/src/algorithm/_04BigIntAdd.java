package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/15 22:51
 **/
//import java.util.*;
//import java.io.*;
//
//
//public class _4BigIntAdd{
//    /*
//        791. 高精度加法【方法一】
//     */
//    public static void main(String[] args) throws IOException{
//        // 输入
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringBuilder a = new StringBuilder(br.readLine()).reverse();
//        StringBuilder b = new StringBuilder(br.readLine()).reverse();
//
//        // 处理并输出
//        StringBuilder c = add(a,b);
//        for(int i=c.length()-1;i>=0;i--){
//            System.out.print(c.charAt(i));
//        }
//        br.close();
//    }
//
//    public static StringBuilder add(StringBuilder a,StringBuilder b){
//        StringBuilder ans = new StringBuilder();
//
//        int count = 0;
//        for(int i=0;i<a.length() || i<b.length();i++){
//            if(i < a.length()){
//                count += a.charAt(i)-'0';
//            }
//            if(i < b.length()){
//                count += b.charAt(i)-'0';
//            }
//            ans.append(count%10);
//            count /= 10;
//        }
//        if(count != 0)
//            ans.append(count);
//        return ans;
//    }
//}

/*
    791. 高精度加法【方法二】
 */
import java.io.*;
import java.math.*;

public class _04BigIntAdd{
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        System.out.println(a.add(b));
        br.close();
    }
}
