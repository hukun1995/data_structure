package data_structure.stack_queue_hash;

import data_structure.model.LinkedStack;
import data_structure.model.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 基于栈实现四则运算
 */
public class Arithmetic {

    /**
     * 获得优先级
     */
    private static int getPriority(char c){
        switch (c)
        {
            case '#':
                return 0;
            case '(':
                return 1;
            case '+':
            case '-':
                return 3;
            case '*':
            case '/':
                return 5;
            case ')':
                return 6;
            default:
                return -1;
        }
    }

    private static int compute(int a, int b, char c){
        switch (c)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return -1;
        }
    }

    /**
     * 中序表达式转后续表达式
     * @param lnrExpr 中序表达式
     * @return 后序表达式
     */
    public static List<Character> parseExpr(String lnrExpr){
        List<Character> lrnExprList = new ArrayList<>();
        Stack<Character> stack = new LinkedStack<>();
        for(char c: lnrExpr.toCharArray()){
            // 数字直接输出
            if(Character.isDigit(c)){
                lrnExprList.add(c);
                continue;
            }

            // 碰到左括号")"，压栈
            if(c == '('){
                stack.push(c);
                continue;
            }

            // 计算符
            // 碰到右括号")"，将栈中计算符输出, 遇到(，(出栈但不输出
            if(c == ')'){
                while (!stack.empty()){
                    char top = stack.pop();
                    if(top != '('){
                        lrnExprList.add(top);
                        continue;
                    }
                    break;
                }
                continue;
            }

            // 非右括号
            while (!stack.empty()){
                // 将栈中优先级 >= 当前计算符的输出, 遇到<的直接停止
                if(getPriority(stack.top()) >= getPriority(c)){
                    lrnExprList.add(stack.pop());
                    continue;
                }
                break;
            }
            // 将当前计算符压栈
            stack.push(c);
        }
        // 将剩余计算符输出
        while (!stack.empty()){
            lrnExprList.add(stack.pop());
        }


        return lrnExprList;
    }

    private static int char2int(char c){
        return c - '0';
    }

    /**
     * @param lnrExpr 中序表达式
     * @return 计算结果
     */
    public static int computeExpr(String lnrExpr){
        // 中序表达式 -> 后续表达式
        List<Character> lrnExprList = parseExpr(lnrExpr);
        Stack<Integer> stack = new LinkedStack<>();
        lrnExprList.forEach(c -> {
            // 数字直接压栈
            if(Character.isDigit(c)){
                stack.push(char2int(c));
                return;
            }
            // 碰到符号, 用n-2 符号 n-1, 并压栈
            int b = stack.pop();
            int a = stack.pop();
            stack.push(compute(a, b, c));
        });
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("result of: 3*(5-2)+6/3 is: " + computeExpr("3*(5-2)+6/3"));
    }

}
