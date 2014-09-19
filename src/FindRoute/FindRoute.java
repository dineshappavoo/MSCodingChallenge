/**
 * 
 */
package FindRoute;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dany
 *You are faced with a stepping puzzle. You know the word needed to get from one side to the other safely, but you need to find the path.

Using a given word and 2D grid of letters, find a path from the top left to the bottom right of the grid. This path must only use adjacent spaces (no diagonals) and it can't use the same space twice. After you have found the path, change all other letters in the grid to periods (.) to let the rest of your friends cross safely.
Input description/format

The input will be the word to follow followed by a grid of characters.
Output description/format

The output will be the grid of characters with only the correct path remaining, each other letter in the grid will be replaced with a period (.)
Example input

SNICKERDOODLE
SNICKE
NRCRDO
IEKODS
CRDOLE

Example output

SNI...
..C...
.EKOD.
.RDOLE
 *
 *
 *
 */
public class FindRoute {

	/**
	 * @param args
	 */
	static char[][] in;
	static char[][] out;//=new boolean[][];
	static int rowLength;
	static int colLength;
	static String inString="";
	public static void main(String[] args) throws FileNotFoundException {


		new FindRoute().getInput();
	}

	public void getInput() throws FileNotFoundException
	{
		File file=new File("/users/dany/downloads/input.txt");
		Scanner scanner=new Scanner(file);
		ArrayList<String> listString=new ArrayList<String>();
		inString=scanner.nextLine();
		while(scanner.hasNext())
		{
			listString.add(scanner.nextLine());				
		}	

		rowLength=listString.size();
		colLength=listString.get(0).length();
		in=new char[rowLength][colLength];
		out=new char[rowLength][colLength];

		for(int i=0;i<rowLength;i++)
		{
			String currentString=listString.get(i);
			for(int j=0;j<colLength;j++)
			{
				in[i][j]=currentString.charAt(j);
			}
		}	

/*		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<colLength;j++)
			{

				System.out.print(in[i][j]);
			}
			System.out.println();
		}*/
		
		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<colLength;j++)
			{

				out[i][j] = '.';
			}
		}
		
		findRouteStr(rowLength-1, colLength-1, 0, 0, inString.length()-1);
	}

	public void findRouteStr(int i, int j, int pi, int pj,int index)
	{
		//System.out.println("Present Value: "+inString[i][j]);
		if(i==0&&j==0)
		{
			out[i][j] = in[i][j];
			for(int ii=0;ii<rowLength;ii++)
			{
				for(int ji=0;ji<colLength;ji++)
				{

					System.out.print(out[ii][ji]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(!((i>=0)&&(i<rowLength)&&(j>=0)&&(j<colLength)))
		{
			return;
		}		

		if  (in[i][j]==inString.charAt(index)) 
		{
			out[i][j]=inString.charAt(index);

			//left traversal
			if(j-1>=0)
			{

				if(!((i==pi)&&(j-1==pj))  && (out[i][j-1]=='.')  )
				{
					findRouteStr(i,j-1,i,j,index-1);
					out[i][j-1]='.';
				}
			}
			//right traversal
			if(j+1<colLength)
			{
				if(  !((i==pi)&&(j+1==pj))  && (out[i][j+1]=='.') )
				{
					findRouteStr(i, j+1,i,j, index-1);
					out[i][j+1]='.';
				}
			}
			//top traversal
			if(i-1>=0)
			{
				if(!((i-1==pi)&&(j==pj))  && (out[i-1][j]=='.')  )
				{
					findRouteStr(i-1, j, i, j,index-1);
					out[i-1][j]='.';
				}
			}
			//bottom traversal
			if(i+1<rowLength)
			{
				if(!((i+1==pi)&&(j==pj))  && (out[i+1][j]=='.')  ) 
				{
					findRouteStr(i+1, j,i,j,index-1);
					out[i+1][j]='.';
				}
			}

		}else
		{
			out[i][j]='.';
			return;
		}
	}
}
