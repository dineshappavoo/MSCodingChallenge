/**
 * 
 */
package Puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dany
 *
 */
public class FindThePath {

	/**
	 * @param args
	 */
	static boolean[][] route;//=new boolean[][];
	static int rowLength;
	static int colLength;
	public static void main(String[] args) throws FileNotFoundException {

		new FindThePath().getInput();
		
	}
	
	public void getInput() throws FileNotFoundException
	{
		File file=new File("/users/dany/downloads/input.txt");
		Scanner scanner=new Scanner(file);
		char[][] inString;
		String pathString="";
		ArrayList<String> listString=new ArrayList<String>();
		pathString=scanner.nextLine();
		while(scanner.hasNext())
		{
			listString.add(scanner.nextLine());				
		}	
		
		rowLength=listString.size();
		colLength=listString.get(0).length();
		inString=new char[rowLength][colLength];
		route=new boolean[rowLength][colLength];
		
		for(int i=0;i<rowLength;i++)
		{
			String currentString=listString.get(i);
			for(int j=0;j<colLength;j++)
			{
				inString[i][j]=currentString.charAt(j);
			}
		}		
		findMaxSkiing1(pathString, inString, rowLength-1, colLength-1, false, pathString.length()-2);
		
		
		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<colLength;j++)
			{
				//System.out.println(route[i][j]);
			}
		}
		
		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<colLength;j++)
			{
				//System.out.println(inString[i][j]);
			}
		}
		
		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<colLength;j++)
			{
				if(route[i][j]||(i==0&&j==0))
				{
				System.out.print(inString[i][j]);
				}else
				{
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
	
	

	//public boolean findPath(String original,int[][] inArray,)
	
	public void findMaxSkiing1(String original, char[][] inString, int i, int j, boolean isReached,int strPos)
	{
		//System.out.println("Present Value: "+inString[i][j]);
		int rowLen=inString.length;
		int colLen=inString[0].length;
		route[i][j]=true;
		if(i==0&&j==0)
		{
			System.exit(0);
		}
		if(!((i>=0)&&(i<rowLen)&&(j>=0)&&(j<colLen)))
		{
			return;
		}		
		//left traversal
		if(j-1>=0)
		{
			
		if((j>=0)&&(j<colLen)  &&  (inString[i][j-1]==original.charAt(strPos))  &&  (route[i][j-1]!=true))
		{
			if(strPos==0)
			{
				isReached=true;
				return;
			}
			//System.out.println("Inside left");
			findMaxSkiing1(original,inString, i, j-1,isReached,strPos-1);
			route[i][j-1]=false;
		}
		}
		
		
		//right traversal
		if(j+1<colLen)
		{
			
		if((j>=0)&&(j<colLen)&&(inString[i][j+1]==original.charAt(strPos))  &&  (route[i][j+1]!=true))
		{
			if(strPos==0)
			{
				isReached=true;
				return;
			}
			//System.out.println("Inside right");
			findMaxSkiing1(original,inString, i, j+1,isReached,strPos-1);
			route[i][j+1]=false;

		
		}
		}
		//top traversal
		if(i-1>=0)
		{
			
		if((i>=0)&&(i<rowLen)&& (inString[i-1][j]==original.charAt(strPos))  &&  (route[i-1][j]!=true))
		{
			if(strPos==0)
			{
				isReached=true;
				return;
			}
			//System.out.println("Inside top");
			findMaxSkiing1(original,inString, i-1, j,isReached,strPos-1);
			route[i-1][j]=false;


		}
		}
		//bottom traversal
		if(i+1<rowLen)
		{
			
		if((i>=0)&&(i<rowLen)&&(inString[i+1][j]==original.charAt(strPos))  &&  (route[i+1][j]!=true))
		{
			if(strPos==0)
			{
				isReached=true;
				return;
			}
			//System.out.println("Inside bottom");
			findMaxSkiing1(original,inString, i+1, j,isReached,strPos-1);
			route[i+1][j]=false;


			}
		}	

	}

}
