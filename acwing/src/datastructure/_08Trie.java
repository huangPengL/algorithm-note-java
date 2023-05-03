package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/26 23:19
 */
import java.io.*;

public class _08Trie {
    private static int[][] son = new int[100010][26];
    private static int[] cnt = new int[100010];  // cnt[idx] != 0 表示从根节点开始到第idx个插入的字母结尾所连成的字符串存在cnt[idx]次
    private static int idx = 0;                  // 用来表示第idx个插入的字母

    public static void insertTrie(String str){
        // 指针指向根节点
        int p = 0;
        for(int i=0;i<str.length();i++){
            int curCh = str.charAt(i)-'a';
            if(son[p][curCh] == 0)  son[p][curCh] = ++idx;
            p = son[p][curCh];
        }
        cnt[p]++;
    }

    public static int quertTrie(String str){
        // 指针指向根节点
        int p = 0;
        for(int i=0;i<str.length();i++){
            int curCh = str.charAt(i)-'a';
            if(son[p][curCh] == 0)  return 0;

            p = son[p][curCh];
        }
        return cnt[p];
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringBuilder ans = new StringBuilder();
        while(n-- != 0){
            String[] ss = br.readLine().split(" ");
            if(ss[0].equals("I")){
                insertTrie(ss[1]);
            }
            else{
                ans.append(quertTrie(ss[1])).append("\n");
            }
        }

        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans);
    }
}