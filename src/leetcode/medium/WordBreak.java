package leetcode.medium;


import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {

    public static void main(String[] args) {
        String target = "leetcode";
        List<String> words = Arrays.asList("leet", "code", "2", "acd");

        System.out.println(wordbreak(target, words));


    }

    public static boolean wordbreak(String target, List<String> wordDict){
        if (target == null || target.length() == 0){
            return true;
        }
        int len = target.length();
        Boolean[] dp = new Boolean[len+1];
        dp[0] = true;

        for (int i = 1; i <= len; i++){
            dp[i] = false;
            for (int j = 0; j < i; j++){
                if (dp[j] && wordDict.contains(target.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];

    }
}