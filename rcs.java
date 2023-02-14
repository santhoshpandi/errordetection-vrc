import java.io.*;
import java.util.*;
class rcs{

public static void main(String[] args)
{
	Scanner in= new Scanner(System.in);
	
	System.out.println("enter the data to send");
		String s;
		s=in.nextLine();
		int flag=0,choice,i;
		System.out.println("1.VRC  2.LRC 3.EXIT\n enter your choice");
		choice=in.nextInt();
		
		switch(choice)
		{
			case 1:
			{
	
				int count=0;
				for(i=0;i<s.length();i++)
				{
					if(s.charAt(i)=='1')
					{
						count++;
					
					}
				}
				if(count%2==0)
					s=s+"0";
				else if(count%2==1)
					s=s+"1";
				else 
				{}
					
			System.out.println(s);
			 try{    
             FileOutputStream fout=new FileOutputStream("vrc.txt");
		     byte b[]=s.getBytes();			 
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
          
		System.out.println("Transmitted Data is : "+s);
			break;
				
			}
			
			case 2:
			{
				String[] s1=new String[(s.length()/8)+1];
				String parity="";
		
		int j=0;
		for(i=0;j<s.length()/8;i=i+8)
		{
			s1[j]=s.substring(i,i+8);
			System.out.println(s1[j]);
			j++;
			
		}
		if((s.length()%8)!=0)
		{
			flag=1;
			int a=8*(s.length()/8);
			int s2=s.length();
			s1[j]=s.substring(a,s.length());
			System.out.println(s1[j]);
			s=s.substring(0,a);
			a=s2-a;
			
			for(i=a;i<8;i++)
			{
				s1[j]="0"+s1[j];
			}
			s=s+s1[j];
		}
		parity=parityfind(s1,flag);
		System.out.println("pa " + parity);
		s=s+parity;
		System.out.println("send "+ s);
		 try{    
             FileOutputStream fout=new FileOutputStream("lrc.txt");
		     byte b[]=s.getBytes();			 
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
          
		System.out.println("Transmitted Data is : "+s);
		break;
				
				
			}
			
			case 3:
			{
				System.out.println("exited Successfully!");
				break;
			}
			
			
		}
		
		
		
}


static String parityfind(String[] s1,int flag)
{
	int m,i1,cnt=0,j;  String a="";
		if(flag==1)
			m=s1.length;
		else
			m=s1.length-1;
		
		for(j=0;j<8;j++)
		{
			for(i1=0;i1<m;i1++)
			{
				if(s1[i1].charAt(j)=='1')
					cnt++;
			}
			
			if(cnt%2==0)
				a=a+"0";
			else
				a=a+"1";
			cnt=0;
		}
		
		return a;
				
	
	
}

}


		


