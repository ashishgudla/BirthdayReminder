import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class AddBirthday
{
	public AddBirthday()
	{
		final Frame f=new Frame("Add/Edit Birthdays");
		final Label c=new Label("Done");
		final Label a=new Label("Enter date :");
		final Label b=new Label("Enter month :");
		final Label e=new Label("Add/edit Names :");
		final Label dummy=new Label("");
		final TextField at=new TextField();
		final TextField bt=new TextField();
		final TextField et=new TextField();
		final Button b1=new Button("Get Names");
		final Button b2=new Button("Add/Edit Names");
		Color g=new Color(160,230,98);
		
		
		f.setUndecorated(true);
		f.setSize(400,200);
		f.setVisible(true);
		f.setBackground(g);
		f.setForeground(Color.red);
		f.setResizable(false);
		f.setBackground(g);
		
		f.add(c);
		f.add(a);
		f.add(b);
		f.add(e);
		f.add(at);
		f.add(bt);
		f.add(et);
		f.add(b1);
		f.add(b2);
		f.add(dummy);

		e.setVisible(false);
		et.setVisible(false);
		b2.setVisible(false);
		
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final Rectangle s = env.getMaximumWindowBounds();
    		final Dimension d = f.getSize();
    		final int w = Math.max(s.width - d.width, 0);
    		final int h = Math.max(s.height - d.height, 0);
    		final int x = (int) (0.5 * w) + s.x;
    		final int y = (int) (0.5 * h) + s.y;
    		f.setBounds(x, y, d.width, d.height);
		
		c.setCursor(new Cursor(Cursor.HAND_CURSOR));
		f.setBackground(g);
		c.setForeground(Color.red);
		c.setBackground(g);
		c.setFont(new Font("Serif", Font.ITALIC, 12));
		c.setBounds(350,10,32,10);
		
		a.setForeground(Color.red);
		a.setBackground(g);
		a.setFont(new Font("Serif", Font.ITALIC, 14));
		a.setBounds(50,50,90,25);
		
		b.setForeground(Color.red);
		b.setBackground(g);
		b.setFont(new Font("Serif", Font.ITALIC, 14));
		b.setBounds(210,50,100,25);
		
		e.setForeground(Color.red);
		e.setBackground(g);
		e.setFont(new Font("Serif", Font.ITALIC, 14));
		e.setBounds(50,100,100,25);
		dummy.setBounds(100,100,10,10);
		
		at.setBounds(140,50,40,25);
		bt.setBounds(310,50,40,25);
		et.setBounds(50,130,300,25);
	
		b1.setBounds(162,88,100,20);
		b2.setBounds(147,165,130,20);

		
		//adding mouse events to close button
		c.addMouseListener(new MouseAdapter() 
			{
            			public void mouseClicked(MouseEvent me) {
					f.dispose();
            			}
				public void mouseEntered(MouseEvent me) {
					c.setFont(new Font("Serif", Font.ITALIC, 14));

				}
				public void mouseExited(MouseEvent me) {
					c.setFont(new Font("Serif", Font.ITALIC, 12));
					
				}
        		});//end of adapter class definition


		//adding mouse events to b1 button
		b1.addMouseListener(new MouseAdapter() 
			{
            			public void mouseClicked(MouseEvent me) {
					int p,q;
					try
					{
						p=Integer.parseInt(at.getText());
						q=Integer.parseInt(bt.getText());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Invalid arguements specified","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(q>12 || q<1)
					{
						JOptionPane.showMessageDialog(null,"Invalid month specified","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(p>29)
					{
						if( (q==2 && (p==30 || p==31)) || (p==31 && (q==4 || q==6 || q==9 || q==11)) || (p>31))
						{
							JOptionPane.showMessageDialog(null,"Invalid date specified","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					e.setVisible(true);
					et.setVisible(true);
					b2.setVisible(true);
					at.setEditable(false);
					bt.setEditable(false);
					b1.setVisible(false);
					Update u=new Update();
					String t=u.getMonth(q);
					try
					{
						BufferedReader in=new BufferedReader(new FileReader("FDB/fileDB"+q+".txt"));
						int i=1;
						while(i<p)
						{
							in.readLine();
							i++;
						}
						et.setText(t +" "+in.readLine());
						in.close();
					}
					catch(Exception e){}	
					
            			}
				
        		});//end of adapter class definition

		//adding mouse events to b2 button
		b2.addMouseListener(new MouseAdapter() 
			{
            			public void mouseClicked(MouseEvent me) {

					int p=Integer.parseInt(at.getText());
					int q=Integer.parseInt(bt.getText());
					BufferedReader in;
					BufferedWriter out;
					String s=new String();
					try
					{
						in=new BufferedReader(new FileReader("FDB/fileDB"+q+".txt"));
						out=new BufferedWriter(new FileWriter("FDB/temp.txt",true));
					}
					catch(Exception e){ 
						JOptionPane.showMessageDialog(null,"1","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					String z=new String();
					s=et.getText();
					StringTokenizer st=new StringTokenizer(s,"-");
					s=st.nextToken();
					try{
					s=st.nextToken();}
					catch(Exception e){ s="";}
					int i=1,qt=0;
					try
					{
					while(i<p)
					{
						 z=in.readLine();
						qt=1;
						out.write(z);
						qt=2;
						out.newLine();
						qt=3;
						i++;
						qt=4;
					}
					out.write(""+i+"-"+s);
					qt=5;
					z=in.readLine();
					z=in.readLine();
					out.newLine();
					while(z!=null)
					{
						out.write(z);
						out.newLine();
						z=in.readLine();
					}
					in.close();
					out.close();
					qt=6;

					}
					catch(Exception e){

						JOptionPane.showMessageDialog(null,""+qt,"Error",JOptionPane.ERROR_MESSAGE);		
						 return;
					}
					
					File f1=new File("FDB/fileDB"+q+".txt");
					File f2=new File("FDB/temp.txt");
					boolean boo1=f1.delete();
					File f=new File("FDB/fileDB"+q+".txt");
					boolean boo2=f2.renameTo(f);
						
					e.setVisible(false);
					et.setVisible(false);
					b2.setVisible(false);
					at.setEditable(true);
					bt.setEditable(true);
					b1.setVisible(true);
            			}
				
        		});//end of adapter class definition
	
		f.setBackground(g);
		}
}
		