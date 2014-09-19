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
 *You are a Network Admin for your company and your day-to-day activity includes interacting with IP addresses and network subnets. Today, you will focus only on the IPv4 protocol. You have a situation for which you need to determine if a given IP address belongs to a subnet. To do so, you must compare the candidate IP address with the range of the subnet. Consider an example subnet that begins at 10.0.0.1 and ends at 11.199.88.254. For this subnet, 10.43.59.96 is within range, while 111.19.12.154 is outside of the range. Note that your input may also contain invalid IP addresses such as 12500.58.18. Any IP address that is incorrectly formatted, is less than 0.0.0.0, or is greater than 255.255.255.255 is an invalid IP address.

In summary, your task is to determine whether an IP address is within range, out side of range, or invalid.
Input description/format

Each line of the input will contain 3 IP Addresses, separated by spaces:

    The first IP address represents the first valid IP address of the subnet.
    The second IP address represents the
    last valid IP address of the subnet.
    The 3rd IP address is the address to validate.

Output description/format

For each line of input, output the result in one of the following 3 ways (case sensitive):

    InRange
    InValid
    OutRange

Example input

10.0.0.1 11.199.88.254 1000.43.59.96
10.0.0.1 11.199.88.254 10.43.59.96
10.0.0.1 11.199.88.254 111.19.12.154

Example output

InValid
InRange
OutRange
 *
 *
 */
public class ValidateIP {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		new ValidateIP().getInputAndProcess();
	}

	public void getInputAndProcess() throws FileNotFoundException
	{
		File file=new File("/users/dany/downloads/input.txt");
		Scanner scanner=new Scanner(file);
		String inLine="";
		while(scanner.hasNext())
		{
			inLine=scanner.nextLine();	
			String[] startRangeArr = inLine.split("[\\ \\s]+");

			System.out.println(validateIP(startRangeArr[0], startRangeArr[1], startRangeArr[2]));

		}	

	}

	public String validateIP(String startRange, String endRange, String inRange)
	{
		String[] startRangeArr = startRange.split("[\\.\\s]+");
		String[] endRangeArr = endRange.split("[\\.\\s]+");
		String[] inRangeArr = inRange.split("[\\.\\s]+");

		int startRangeBit,endRangeBit,inRangeBit;
		for(int i=0;i<4;i++)
		{
			startRangeBit=Integer.parseInt(startRangeArr[i]);
			endRangeBit=Integer.parseInt(endRangeArr[i]);
			inRangeBit=Integer.parseInt(inRangeArr[i]);


			if(startRangeBit<0||startRangeBit>255||endRangeBit<0||endRangeBit>255||inRangeBit<0||inRangeBit>255)
			{
				return "InValid";
			}else if((inRangeBit>=startRangeBit)&&(inRangeBit<=endRangeBit))
			{
				return "InRange";
			}else if((inRangeBit<startRangeBit)||(inRangeBit>endRangeBit))
			{
				return "OutRange";
			}

		}
		return "";
	}

}
