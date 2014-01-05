package com.scott.topcoder;

import java.util.HashSet;

public class JoinedString {

	
	private static class Node{
		char c ;
		Node [] subNodes = new Node [256];
		boolean isFull;
		
		public Node (char c){
			this.c = c ;
		}
	}
	
	
	private static class Trie{
		private Node root ;
		
		public Trie(){
			root = new Node(' ');
		}
		
	     public void addWord(String word){
	    	 Node current = root;
	    	 for(int i = 0 ;i < word.length() ;++i){
	    		 if (current.subNodes[word.charAt(i)] == null){
	    			 current.subNodes[word.charAt(i)] = new Node(word.charAt(i));
	    		 }
	    		 current = current.subNodes[word.charAt(i)];
	    	 }
	    	 current.isFull = true;
	     }
	     
	     public boolean isMatched(String word){
	    	 Node current = root;
	    	 for (int i = 0 ;i <word.length() ;++i){
	    		 if (current.subNodes[word.charAt(i)]!=null){
	    			 current = current.subNodes[word.charAt(i)];
	    		 }else{
	    			 return false;
	    		 }
	    	 }
	    	 
	    	return current.isFull;
	     }
		
	}
	
	
	public static void main(String[] args) {
		String [] wordList ={"aaaa", "aaa", "aa", "aaaa", "aaaaa"};
		JoinedString joined = new JoinedString();
		System.out.println(joined.differentCW(wordList));
		

	}
	
	public int differentCW(String [] words){
		Trie t = new Trie();
		HashSet<Integer> set = new HashSet<Integer>();
		int count = 1;
		t.addWord(words[0]);
		set.add(words[0].length());
		boolean flag = false;
		for (int i = 1 ; i<words.length ;++i){
			 if (!set.contains(words[i].length())){
				 t.addWord(words[i]);
				 set.add(words[i].length());
				 count++;
				 continue;
			 }
			if (!t.isMatched(words[i])){
				int j = 0;
				String key = "";
				while(j<words[i].length()){
					key += words[i].substring(j, j+1);
					if (t.isMatched(words[i].substring(j+1)+key)){
						flag = true;
						break;
					}
					j++;
				}
				
				if (!flag){
					t.addWord(words[i]);
					count++;
				}
				flag = false;
			}
		}
		
		return count++;
	}

}
