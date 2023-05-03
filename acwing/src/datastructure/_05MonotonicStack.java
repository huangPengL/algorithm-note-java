package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/23 17:46
 */
import java.util.*;
import java.io.*;

public class _05MonotonicStack {
    public static void main(String[] args) throws IOException{
        // 输入
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)    arr[i] = in.nextInt();

        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<n;i++){
            // 在栈中寻找比当前数字小的元素，在找的同时把比当前数字大的元素出栈
            while(!stack.isEmpty() && arr[i] <= stack.peekLast()){
                stack.pollLast();
            }

            // 如果翻遍了栈都没找到比当前数字小的元素，那么返回-1
            if(stack.isEmpty())
                System.out.print("-1 ");
            else
                System.out.print(stack.peekLast()+" ");

            // 当前元素入栈
            stack.offerLast(arr[i]);
        }
    }
}
