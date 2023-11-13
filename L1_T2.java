// Description: Implement a program that checks whether a given word or phrase is a palindrome. A palindrome is a word or phrase that reads the same forwards and backward, ignoring spaces and punctuation.

import java.util.Scanner;

public class L1_T2 {

    public static boolean checkPalindrome(String str){
        StringBuilder sb=new StringBuilder(str);
        
        //Method 1
        for (int i=0;i<sb.length()/2;i++){
            int front=i;
            int rear=sb.length()-1-i;
            char frontChar=sb.charAt(front);

            sb.setCharAt(front, sb.charAt(rear));
            sb.setCharAt(rear, frontChar);
        }
        if(sb.toString().equals(str)){
            return true;
        }
        else{
            return false;
        }

        //method 2
        // String rev=sb.reverse().toString();
        // return rev.equals(str);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a word:- ");
        String str=sc.next();
        sc.close();
        if (checkPalindrome(str)){
            System.out.println(str+" is a palindrome");
        }
        else{System.out.println(str+" is not a palindrome");}
    }
}