package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Title Word Break II
 * @Description Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 * @author Potato
 *
 */
public class T140 {
	Set<String> dict;
	Map<String, List<String>> cache;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String []s={"cat","cats","and","sand","dog"};
        T140 t140=new T140();
        t140.wordBreak("catsanddog", Arrays.asList(s)).forEach(System.out::println);
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        dict=new HashSet<String>();
        for (String string : wordDict) {
			dict.add(string);
		}
        cache=new HashMap<String, List<String>>();
        
        return DFS(s);
    }
	public List<String> DFS(String s){
		if(cache.containsKey(s))
			return cache.get(s);
		List<String> res=new LinkedList<String>();
		if(s.isEmpty()){
			res.add("");
			return res;
		}
		for(int i=1;i<=s.length();i++){
			String word=s.substring(0, i);
			String rest=s.substring(i);
			if(dict.contains(word)){
				List<String> restList=DFS(rest);
				for (String string : restList) {
					res.add(word+(string.isEmpty()?"":" ")+string);
				}
			}
		}
		cache.put(s, res);
		return res;
	}

}
