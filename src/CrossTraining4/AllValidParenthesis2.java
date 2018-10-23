package CrossTraining4;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllValidParenthesis2 {
    public static void main(String[] args) {
        AllValidParenthesis2 test = new AllValidParenthesis2();
        List<String> ret = test.validParentheses(1, 1, 0);
        for (String x : ret) {
            System.out.println(x);
        }
    }
    public List<String> validParentheses(int l, int m, int n) {
        List<String> ret = new ArrayList<>();
        if (l == 0 && n == 0 && m == 0) {
            return ret;
        }
        StringBuilder sol = new StringBuilder();
        int[] ls = new int[] {0, 0, 0}; //当前解中左括号的数量
        int[] limit = new int[] {l, m, n}; //一共多少个括号
        char[][] combination = new char[][] {{'(', ')'}, {'<', '>'}, {'{', '}'}}; //准备一个配对
        Deque<Character> stack = new LinkedList<>();  //记录当前可以加什么样的右括号
        dfs(ret, sol, ls, limit, combination, stack);
        return ret;
    }

    void dfs(List<String> ret, StringBuilder sol, int[] ls,
             int[] limit, char[][] combination, Deque<Character> stack) {
        if (sol.length() == 2 * (limit[0] + limit[1] + limit[2])) {
            ret.add(sol.toString()); //返回条件
            return;
        }

        //加左括号的条件： 没有加到上限
        for (int i = 0; i < 3; i++) {
            if (ls[i] < limit[i]) {
                sol.append(combination[i][0]);
                stack.push(combination[i][0]);
                ls[i] += 1;
                dfs(ret, sol, ls, limit, combination, stack);
                sol.deleteCharAt(sol.length() - 1);
                stack.pop();
                ls[i] -= 1;
            }
        }
        //加右括号的条件： 栈顶是对应的左括号
        if (stack.size() > 0) {
            for (int i = 0; i < 3; i++) {
                if (stack.peek() == combination[i][0]) {
                    sol.append(combination[i][1]);
                    stack.pop();
                    dfs(ret, sol, ls, limit, combination, stack);
                    sol.deleteCharAt(sol.length() - 1);
                    stack.push(combination[i][0]);
                }
            }
        }
    }
}
