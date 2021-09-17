import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:  GenerateParenthesis
 * @Description: 22. 括号生成
 * @link: https://leetcode-cn.com/problems/generate-parentheses/
 * @author: liuezhong
 * @date:   2021/9/17 下午11:14    
*/ 

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
    public void generate(List<String> result, String str, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n) {
            generate(result, str +"(", left + 1, right, n);
        }
        if (right < left) {
            generate(result, str +")", left, right + 1, n);
        }
    }
}
