package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class T127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T127 t127=new T127();
		List<String> wordList=new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(t127.ladderLength("hit", "cog", wordList));
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty())
        	return 0;
        if(!wordList.contains(endWord))
        	return 0;
        Set<String> dict=new HashSet<String>();
        for (String string : wordList) {
			dict.add(string);
		}
        Queue<String> queue=new LinkedList<String>();
        Set<String> set=new HashSet<String>();
        queue.offer(beginWord);
        set.add(beginWord);
        int length=0;
        while(!queue.isEmpty()){
        	length++;
        	int size=queue.size();
        	for(int i=0;i<size;i++){
        		String word=queue.poll();
        		for(int j=0;j<word.length();j++){
        			for(char k='a';k<='z';k++){
        				if(k==word.charAt(j)) continue;
        				StringBuilder sb=new StringBuilder(word);  
                        sb.setCharAt(j, k);
        				String rw=sb.toString();
        				if(rw.equals(endWord))
        					return length+1;
        				if(dict.contains(rw) && !set.contains(rw))
        				{
        					queue.offer(rw);
        					set.add(rw);
        				}
        			}
        		}
        	}
        }
        return 0;
    }

}
