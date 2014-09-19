/**
 * 
 */
package Puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Dany
 *
 *
 *A Palindrome phrase is a string starting at the beginning of a word and ending at the end of a word that contains the same alphanumeric characters both from left to right and right to left. Given lines of text, find the largest palindrome phrase in each line.
Clarifications

    An alphanumeric character is a character that is a number or a letter (punctuation and white space do not count).
    For comparing letters, case should be ignored (for example, “Race Car” would be considered a palindrome phrase).
    The beginning of a word is an alphanumeric character that is:
        preceded by a non-alphanumeric character, or
        is the first character in the line.
    The end of a word is an alphanumeric character that is:
        followed by a non-alphanumeric character, or
        is the last character in the line.
    The length of the palindrome phrase is measured by the count of the alphanumeric characters it contains (the ignored punctuation, whitespace, etc. do not count toward its length).

Input description/format

Multiple lines of text, each potentially containing a palindrome phrase.
Output description/format

One line for each line of input. Each line should be the substring that is the longest palindrome phrase found in the source line (this should be in the original casing and include any ignored characters). If no palindrome phrase is found, leave a blank line.
Example input

Dee saw a seed.
Unicode has some weird stuff in it. Do not, bob to ? nod.

Example output

Dee saw a seed
Do not, bob to ? nod
 */
public class LargestPalindrome {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		String inLine="Unicode has some weird stuff in it. Do not, bob to ? nod._";
		inLine = inLine.replaceAll("[^a-zA-Z0-9]", "");
		inLine=inLine.toLowerCase();
		//System.out.println(inLine);
		

		new LargestPalindrome().getInputAndProcess();
	}
	
	public void getInputAndProcess() throws FileNotFoundException
	{
		File file=new File("/users/dany/downloads/input.txt");
		Scanner scanner=new Scanner(file);
		String inLine="";
		String newLine="";
		String largePalindrome="";
		while(scanner.hasNext())
		{
			inLine=scanner.nextLine();
			newLine = inLine.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			largePalindrome=findmaxPolindrome(newLine);
			
			System.out.println(largePalindrome);
			
		}
		
	}
	
	public static String findmaxPolindrome(String str)
	{
		int len=str.length();
		if(len<2)
			return str;
		
		int wordLength=0, maxWordLength=0;
		char current;
		int maxStart=0,maxEnd=0;
		String res="";
		int k,l;
		for(int i=2;i<len;i++)
		{
			current=str.charAt(i);
			if(current==str.charAt(i-1)) //even length
			{
				k=i-1;
				l=i;
				while(str.charAt(k)==str.charAt(l) && l!=len-1 && k>0)
				{
					l++;
					k--;
				}
				
				wordLength=l-k;
				if(wordLength>maxWordLength)
				{
					maxWordLength=wordLength;
					maxStart=k;
					maxEnd=l;
							
				}
				
			}else if(current==str.charAt(i-2)) //odd length
			{
				k=i-2;
				l=i;
				while(str.charAt(k)==str.charAt(l) && l!=len-1 && k>0)
				{
					l++;
					k--;
				}
				
				wordLength=l-k;
				if(wordLength>maxWordLength)
				{
					maxWordLength=wordLength;
					maxStart=k;
					maxEnd=l;
							
				}
				
			}
		}
		
		for(int m=maxStart;m<=maxEnd;m++)
		{
			res+=str.charAt(m);
		}
		
		return res;
	}

}
