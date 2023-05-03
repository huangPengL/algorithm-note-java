package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/1 18:33
 */
import java.util.*;
import java.io.*;


/*
    拉链法
*/
public class _11HashZip {
    static int N = 100003;
    static int[] map;       // map[i]表示哈希表第i个位置的链表地址
    static int[] e;         // e[k] 表示地址为k的链表节点的值
    static int[] ne;        // ne[k] 表示地址为k的链表节点的下一个位置的地址
    static int idx;         // 顺序“开辟”链表结点地址

    // 初始化
    public static void initMap(){
        map = new int[N];
        e = new int[N];
        ne = new int[N];
        idx = 0;

        // 给哈希表所有位置的链表置为空
        Arrays.fill(map,-1);
    }

    // 哈希函数
    public static int hashFun(int num){
        return (num%N+N)%N;
    }

    // 头插法
    public static void insertMap(int num){
        int realNum = hashFun(num);

        // 将新节点插入到拉链中
        e[idx] = num;
        ne[idx] = map[realNum];
        map[realNum] = idx;

        idx++;
    }
    public static boolean queryMap(int num){
        int realNum = hashFun(num);

        for(int i=map[realNum];i!=-1;i=ne[i]){
            if(e[i] == num) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        initMap();

        StringBuilder ans = new StringBuilder();
        while(n-- != 0){
            String[] ss = br.readLine().split(" ");
            char c = ss[0].charAt(0);
            int num = Integer.parseInt(ss[1]);
            if(c == 'I'){
                insertMap(num);
            }
            else if(c == 'Q'){
                if(queryMap(num)){
                    ans.append("Yes\n");
                }
                else{
                    ans.append("No\n");
                }
            }
        }

        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans.toString());
    }
}