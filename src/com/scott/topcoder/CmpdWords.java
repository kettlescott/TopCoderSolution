package com.scott.topcoder;

public class CmpdWords {

	
	private static class Node{
		char c ;
		Node [] subNodes = new Node [256];
		boolean isFull;
		int times ;
		
		public Node (char c){
			this.c = c ;
		}
	}
	
	
	private static class Trie{
		private Node root ;
		
		public Trie(){
			root = new Node(' ');
		}
		
	    public int addWord(String word){
	    	 Node current = root;
	    	 for(int i = 0 ;i < word.length() ;++i){
	    		 if (current.subNodes[word.charAt(i)] == null){
	    			 current.subNodes[word.charAt(i)] = new Node(word.charAt(i));
	    		 }
	    		 current = current.subNodes[word.charAt(i)];
	    	 }
	    	 current.isFull = true;
	    	 current.times++;
	    	 return current.times;
	     }
	     		
	}
	
	public static void main(String[] args) {
		String [] array ={"abc","bca","bab","a"};
		CmpdWords cmp = new CmpdWords();
        System.out.println(cmp.ambiguous(array));

		
    }
	
	public int ambiguous(String[] dictionary){
		Trie t = new Trie();
		int total = 0;
		for (int i =0; i<dictionary.length ;++i){
			if (t.addWord(dictionary[i])>1){
				total++;
			}
			for (int j =0; j<dictionary.length ;++j){
				if (i!=j){
					if (t.addWord(dictionary[i]+dictionary[j])>1){
						total++;
					}
				}				
			}
		}
		return total;
	 }

	

}
