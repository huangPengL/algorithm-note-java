package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/25 20:49
 */
import java.io.*;

public class _07KMP{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());
        String p = br.readLine();

        // 预处理next数组
        int[] next = new int[n];
        for(int right=1,left=0; right<n; right++){
            // 若left指针不在第一个位置，并且left和right指向的元素不相等，那么left指针回退
            while(left > 0 && s.charAt(left) != s.charAt(right)){
                left = next[left-1];
            }
            // 如果退出循环后，发现了left和right指向的元素相等，那么left指针后移一位准备给next数组赋值
            if(s.charAt(left) == s.charAt(right)){
                left++;
            }
            next[right] = left;
        }

        //KMP
        StringBuilder sb = new StringBuilder();
        for(int i=0,j=0;i<m;i++){
            // 如果匹配失败就回退，直到回退到某一步匹配成功或者回退到开头
            while(j > 0 && p.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            // 如当前匹配成功则j++
            if(p.charAt(i) == s.charAt(j)){
                j++;
            }
            // 所有字符匹配成功，则j回退
            if(j == n){
                // System.out.print(i-n+1+" ");
                sb.append(i-n+1).append(" ");
                j = next[j-1];
            }
        }

        System.out.println(sb.toString());
    }
}