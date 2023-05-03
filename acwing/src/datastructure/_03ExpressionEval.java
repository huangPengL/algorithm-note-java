package datastructure;
import java.util.*;
import java.io.*;

public class _03ExpressionEval {

    // 出栈一个运算符，出栈两个数字，进行计算将结果入栈
    public static void operate(Deque<Character> stackOpp, Deque<Integer> stackNum){
        int num2 = stackNum.pollLast();
        int num1 = stackNum.pollLast();
        char opp = stackOpp.pollLast();

        if(opp == '+') stackNum.offerLast(num1 + num2);
        else if(opp == '-') stackNum.offerLast(num1 - num2);
        else if(opp == '*') stackNum.offerLast(num1 * num2);
        else if(opp == '/') stackNum.offerLast(num1 / num2);
    }

    public static boolean isDigits(char c){
        if(c >= '0' && c <= '9')    return true;
        return false;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int n = str.length;

        // 定义运算符的优先级
        Map<Character, Integer> oppPriority = new HashMap<>();
        oppPriority.put('+', 1);
        oppPriority.put('-', 1);
        oppPriority.put('*', 2);
        oppPriority.put('/', 2);

        //
        Deque<Integer> stackNum = new LinkedList<>();
        Deque<Character> stackOpp = new LinkedList<>();

        // 中缀表达式求值
        for(int i=0;i<n;i++){
            // 如果遇到数字，则将数字取出来放入栈中
            if(isDigits(str[i])){
                int num = 0;
                int j = i;
                while(j < n && isDigits(str[j])){
                    num = num * 10 + str[j++]-'0';
                }

                stackNum.offerLast(num);
                i = j-1;
            }

            // 遇到左括号入栈
            else if(str[i] == '('){
                stackOpp.offerLast(str[i]);
            }
            // 遇到右括号，将栈中的运算符一一弹出并且运算，直到遇到左括号
            else if(str[i] == ')'){
                while(stackOpp.peekLast() != '('){
                    operate(stackOpp, stackNum);
                }

                stackOpp.pollLast();        // 出栈左括号（
            }
            // 遇到运算符，将其优先级与栈顶运算符的优先级进行对比
            // 如果低于或者等于栈顶的运算符，则让栈顶的运算符进行计算,然后将当前运算符入栈
            // 如果高于栈顶的运算符，则当前运算符入栈
            else{
                while(!stackOpp.isEmpty() && stackOpp.peekLast() != '(' && oppPriority.get(stackOpp.peekLast()) >= oppPriority.get(str[i])){
                    operate(stackOpp,stackNum);
                }
                stackOpp.offerLast(str[i]);
            }
        }

        // 将栈中的剩下的运算符进行操作
        while(!stackOpp.isEmpty()){
            operate(stackOpp,stackNum);
        }

        // 输出答案
        System.out.println(stackNum.peekLast());
    }
}