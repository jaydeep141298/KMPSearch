package Leetcode.hard;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void calculateLps(String pattern,int[] lps){
        lps[0] = 0;
        int lent = 0;
        int i = 1;
        while(i < pattern.length()){
            char ch1 = pattern.charAt(lent);
            char ch2 = pattern.charAt(i);
            if(ch1 == ch2){
                lent++;
                lps[i] = lent;
                i++;
            }else{
                if(lent == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    lent = lps[lent-1];
                }
            }
        }
    }
    public static void allFoundPatternIndexes(String text, String pattern, int[] lps){

        int textIndex = 0;
        int patternIndex = 0;
        char ch1,ch2;

        while(textIndex < text.length()){
            System.out.println("textIndex = " + textIndex);
            System.out.println("PatternIndex = " + patternIndex);
          ch1 = text.charAt(textIndex);
          ch2 = pattern.charAt(patternIndex);
          if(ch1 == ch2){
              System.out.println("Both are same");
              if(patternIndex == (pattern.length() - 1)){
                  System.out.println(textIndex);
                  textIndex++;
                  patternIndex = lps[pattern.length()-1];
              }else{
                 textIndex++;
                 patternIndex++;
              }
          }else{
              if(patternIndex == 0){
                  textIndex++;
              }else{
                  patternIndex = lps[patternIndex-1];
              }
          }


        }


    }

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        String text = scan.next();
        String pattern = scan.next();
        ///////////////////////////////
        int[] lps = new int[pattern.length()] ;
        Arrays.fill(lps,0);
        //Arrays.toString(lps);
        calculateLps(pattern,lps);
        System.out.println(Arrays.toString(lps));
        allFoundPatternIndexes(text,pattern,lps);
    }
}
