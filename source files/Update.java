import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class Update
{
	public String[] getUpdate( Date d)throws IOException
		{
			int i=0,j=0;
			int m=d.getDate();
			int n=d.getMonth()+1;
			String[] st=new String[7];
			String temp;
			FileInputStream f=new FileInputStream("FDB/fileDB"+n+".txt");
			DataInputStream dis=new DataInputStream(f);
			BufferedReader in=new BufferedReader(new InputStreamReader(dis));
			FileInputStream f1=new FileInputStream("FDB/fileDB"+(n+1)+".txt");
			DataInputStream dis1=new DataInputStream(f1);
			BufferedReader out=new BufferedReader(new InputStreamReader(dis1));
			while(i!=m-1)
			{
				in.readLine();
				i++;
			}
			String mon=new String();
			while(j<7)
			{
				mon=getMonth(n);
				temp=in.readLine();
				st[j]=mon +"  "+ temp;
				if(temp==null)
				{
					mon=getMonth(n+1);
					st[j]=mon +"  "+ out.readLine();
				}
				j++;
			}
			in.close();
			out.close();
			return st;
		}

	public String getMonth(int m)
		{
			String s=new String();
			switch(m)
			{
				case 1: s="January";
					break;
				case 2: s= "February";
					break;
				case 3: s= "March";
					break;

				case 4: s= "April";
					break;
				case 5: s= "May";
					break;
				case 6: s= "June";
					break;

				case 7: s= "July";
					break;
				case 8: s= "August";
					break;
				case 9: s= "September";
					break;

				case 10: s= "October";
					break;
				case 11: s= "November";
					break;
				case 12: s= "December";
					break;
				default: s= null;
					
			}
			return s;
		}
}