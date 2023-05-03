package algorithm;

/**
 * @Author: HPL
 * @Description: this is description of class
 * @DateTime: 2022/1/15 22:51
 **/
import java.io.*;
import java.math.*;

///*
//792. 高精度减法【方法一】
// */
//public class _04BigIntSub{
//    public static void main(String[] args) throws IOException{
//        // 输入
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringBuilder a = new StringBuilder(br.readLine()).reverse();
//        StringBuilder b = new StringBuilder(br.readLine()).reverse();
//
//        // 处理并输出
//        StringBuilder c;
//        // 如果a大于等于b，则直接计算a-b
//        if(cmp(a,b))        c = sub(a,b);
//            // 如果a小于b，则计算(b-a)然后前面加个负号
//        else{
//            c = sub(b,a);
//            System.out.print("-");
//        }
//
//        // 输出
//        for(int i=0;i<c.length();i++){
//            System.out.print(c.charAt(i));
//        }
//
//        br.close();
//    }
//
//    // 若a>=b返回true否则返回false
//    public static boolean cmp(StringBuilder a,StringBuilder b){
//        if(a.length()!=b.length())    return a.length()>b.length();
//        for(int i=a.length()-1;i>=0;i--){
//            if(a.charAt(i)!=b.charAt(i))    return a.charAt(i)>b.charAt(i);
//        }
//        return true;
//    }
//
//    // 计算a-b, 计算前需要保证a>=b
//    public static StringBuilder sub(StringBuilder a,StringBuilder b){
//        StringBuilder c = new StringBuilder();
//        int t = 0;
//        for(int i=0;i<a.length();i++){
//            //
//            if(i<b.length())    t = (a.charAt(i)-'0') - t - (b.charAt(i)-'0');
//            else                t = (a.charAt(i)-'0') - t;
//
//            //
//            if(t < 0){
//                c.append(t+10);
//                t = 1;
//            }
//            else{
//                c.append(t);
//                t = 0;
//            }
//        }
//
//        // 去除结果的前导0
//        StringBuilder ans = new StringBuilder();
//        int i = c.length()-1;
//        while(i >=0 && c.charAt(i) == '0')  i--;
//        while(i >=0 )   ans.append(c.charAt(i--));
//
//        // 特判a-b=0的情况
//        if(ans.length() == 0)   ans.append("0");
//        return ans;
//    }
//}

/*

792. 高精度减法【方法二】
 */

public class _04BigIntSub {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        System.out.println(a.subtract(b));
        br.close();
    }
}