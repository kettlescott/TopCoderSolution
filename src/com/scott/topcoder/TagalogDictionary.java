package com.scott.topcoder;

import java.util.ArrayList;




public class TagalogDictionary {


    private static class Node{
    	String key;
    	boolean isFull;
    	Node [] subNodes = new Node [20];
    	
    	
    	public Node(String key){
    		this.key = key;
    	}
    }
    
    
    private static class Trie{
    	
    	private Node root ;
    	public Trie(){
    		root = new Node("");
    	}
    	
    	public void addWord(String word){
    		Node current = root;
    		char [] chs = word.toCharArray();
    		int chOfNum = 0;
    		String val = "";
    		for (int i = 0;i<chs.length; ++i){    			
    			if (i<chs.length-1&&(chs[i]=='n'&&chs[i+1]=='g')){
    				chOfNum	= 11;
    				val = "ng";
    				++i;
    			}else{
    				
    				chOfNum = getNumOfChar(chs[i]);
    				val = chs[i]+"";
    			}
    			
    			if (current.subNodes[chOfNum]==null){
    				current.subNodes[chOfNum] = new Node(val);
    			}
    			current = current.subNodes[chOfNum];
    		}
    		current.isFull = true;
    	}
    	
    	
    	private void sort(Node node,String pre,ArrayList<String> queue){
    		if (node ==null){
    			return ;
    		}
    		if (node.isFull){
    			queue.add(pre+node.key);	
    		}
    		for (int i = 0 ; i<20;++i){
    			if (node.subNodes[i]!=null){
    				sort(node.subNodes[i],pre+node.key,queue);					
    			}			
    		}		
    	}
    	
    
    	public ArrayList<String> sortWordList(){
    		ArrayList<String> list = new ArrayList<String>();
    		sort(root,"",list);   
    		return list;	
    	}
    	
    	
    	public int getNumOfChar(char c){
    		switch (c){
    		   case 'a':
    		    return 0;
    		   case 'b':
       		    return 1;
    		   case 'k':
       		    return 2;
    		   case 'd':
       		    return 3;
    		   case 'e':
       		    return 4;
    		   case 'g':
       		    return 5;
    		   case 'h':
       		    return 6;
    		   case 'i':
       		    return 7;
    		   case 'l':
          		return 8;
    		   case 'm':
          		return 9;
    		   case 'n':
          		return 10;
    		   case 'o':
          	    return 12;
    		   case 'p':
          		return 13;
    		   case 'r':
          		return 14;
    		   case 's':
          		return 15;
    		   case 't':
          		return 16;
    		   case 'u':
          		return 17;
    		   case 'w':
        		return 18;
    		   case 'y':
        		return 19;
        	   default :
        		   return -1;		
    		}
    	}
    	
    	
    }
	
	
	public static void main(String[] args) {
      String [] wordList ={"abakada","alpabet","tagalog","ako"};

      TagalogDictionary t =new TagalogDictionary();
      t.sortWords(wordList);

	}
	
	
	
	
	
	public String[] sortWords(String[] words){
		Trie t = new Trie();
		for (int i = 0 ;i<words.length ;++i){
			t.addWord(words[i]);
		}
		
		ArrayList<String> list =t.sortWordList();
		return (String[])list.toArray();
	}

}
