package com.huiyu.utils;

public class GetSortNum {
	
   public int getSortNum(String word){
    int sortNum=0;
	         if(word.equals("begin")){
	   			sortNum= 1;
	   		}
	   		else if(word.equals("if")){
	   			sortNum= 2;
	   		}
	   		else if(word.equals("then")){
	   			sortNum= 3;
	   		}
	   		else if(word.equals("while")){
	   			sortNum= 4;
	   		}
	   		else if(word.equals("do")){
	   			sortNum= 5;
	   		}
	   		else if(word.equals("end")){
	   			sortNum= 6;
	   		}
	   		else if(word.equals("ID")){
	   			sortNum= 10;
	   		}
	   		else if(word.equals("NUM")){
	   			sortNum= 11;
	   		}
	   		else if(word.equals("+")){
	   			sortNum= 13;
	   		}
	   		else if(word.equals("-")){
	   			sortNum= 14;
	   		}
	   		
	   		else if(word.equals("*")){
	   			sortNum= 15;
	   		}
	   		else if(word.equals("/")){
	   			sortNum= 16;
	   		}
	   		else if(word.equals("=")){
	   			sortNum= 17;
	   		}
	   		else if(word.equals(">")){
	   			sortNum= 18;
	   		}
	   		else if(word.equals("<")){
	   			sortNum= 20;
	   		}
	   		else if(word.equals("<>")){
	   			sortNum= 21;
	   		}
	   		else if(word.equals("<=")){
	   			sortNum= 22;
	   		}
	   		else if(word.equals(":=")){
	   			sortNum= 23;
	   		}
	   		else if(word.equals(">=")){
	   			sortNum= 24;
	   		}
	   		else if(word.equals(":")){
	   			sortNum= 25;
	   		}
	   		else if(word.equals(";")){
	   			sortNum= 26;
	   		}
	   		else if(word.equals("(")){
	   			sortNum= 27;
	   		}
	   		else if(word.equals(")")){
	   			sortNum= 28;
	   		}
	   		else if(word.equals("#")){
	   			sortNum= 29;
	   		}
	   		else{
	   			sortNum= -1;
	   		}
	   		
	   
	  return sortNum;
	}
}