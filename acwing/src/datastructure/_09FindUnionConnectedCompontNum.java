package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/28 19:24
 */
import java.io.*;

public class _09FindUnionConnectedCompontNum {
    private static int[] parent;
    private static int[] size;

    public static void init(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public static int find(int num){
        if(parent[num] != num){
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }

    public static void merge(int num1,int num2){
        int root1 = find(num1);
        int root2 = find(num2);
        if(root1 != root2){
            parent[root1] = root2;
            size[root2] += size[root1];
        }
    }

    public static int getSize(int num){
        return size[find(num)];
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);

        init(n);

        StringBuilder ans = new StringBuilder();
        while(m-- != 0){
            String[] ss2 = br.readLine().split(" ");
            String operate = ss2[0];
            if(operate.equals("C")){
                int num1 = Integer.parseInt(ss2[1]);
                int num2 = Integer.parseInt(ss2[2]);
                merge(num1,num2);
            }
            else if(operate.equals("Q1")){
                int num1 = Integer.parseInt(ss2[1]);
                int num2 = Integer.parseInt(ss2[2]);
                if(find(num1) == find(num2)){
                    ans.append("Yes\n");
                }
                else{
                    ans.append("No\n");
                }
            }
            else if(operate.equals("Q2")){
                int num = Integer.parseInt(ss2[1]);
                ans.append(getSize(num)).append("\n");
            }
        }
        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans.toString());
    }
}