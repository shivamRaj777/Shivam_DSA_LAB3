package com.greatlearning.matchingparenthesis.core;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the expression to check if its balanced or not:");
		String bracketExpression=sc.next();
		boolean result=isBracketIsBalanced(bracketExpression); //as we are checking hence we are using boolean datatype
		if(result==true) {
			System.out.println("The Entered String has Balanced Brackets ");
		}else {
			System.out.println("The Entered String do not contain  Balanced Brackets ");
		}
		

	}
	public static boolean isBracketIsBalanced(String bracketExpression) {
		
		Stack<Character>stack=new Stack<>();
		for(int i=0;i<bracketExpression.length();i++) {
			char character=bracketExpression.charAt(i);  //used for reading character from the string bracketexpression
			
			if(character=='(' || character== '{' || character=='[') {
				stack.push(character);
				continue;
			}
			if(stack.isEmpty()) {
				return false;
			}
			char c ;   //c contains either),},] then will pop but should have similar closing brackets so we have to look for those condition also
			switch(character) {  //here key is the character that we will pass in switch 
			case ')':
				c=stack.pop();
				if(c=='{' || c=='[') {
					return false;
				}
				break;
			case '}':
				c=stack.pop();
				if(c=='(' || c=='[') {
					return false;
				}
				break;
			case ']':
				c=stack.pop();
				if(c=='(' || c=='{') {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}

}
