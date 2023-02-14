import java.io.*;
import java.util.*;

class vrcd{
public static void main(String[] args)
{
	String s=""; int i;
	try{
		File f = new File("vrc.txt");
		FileInputStream f1=new FileInputStream(f);
		byte []by=new byte[(int)f.length()];
		f1.read(by);
		s=new String(by);
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
			System.out.println("Received Data: "+s);
							int count=0;
				for(i=0;i<s.length();i++)
				{
					if(s.charAt(i)=='1')
					{
						count++;
					
					}
				}
				if(count%2==0)
				{
					s=s.substring(0,s.length()-1);
					System.out.println("the decoded data is :  "+s);
				}
				else
					System.out.println("message error!");
}
}
					