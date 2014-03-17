import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class BirthdayReminder
{
	public static void main(String[] args)throws IOException
	{
    		
		//Declarations
		final Frame frame = new Frame("BIRTHDAY REMINDER");
    		final Label close = new Label("close",Label.RIGHT);
		final Label head = new Label(" BIRTHDAY REMINDER ",Label.LEFT);
		final Label ub = new Label(" Upcoming Birthdays ",Label.LEFT);
		final Label tr=new Label(" Add/Edit Birthdays ",Label.LEFT);
		final Label dummy=new Label("",Label.LEFT);
		TextArea ta=new TextArea("",22,82,2);
		Color ly=new Color(244,248,120);
		Color v=new Color(168,31,171);
    		
		//setting properties and adding components
		frame.setUndecorated(true);
		frame.setSize(600,400);
    		frame.setVisible(true);
		frame.setBackground(ly);
		frame.add(ub);
    		frame.add(close);
		frame.add(head);
    		frame.add(ta);
		frame.add(tr);
		frame.add(dummy);
		frame.setBackground(ly);

		//positoning of frame relative to screen
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final Rectangle s = env.getMaximumWindowBounds();
    		final Dimension f = frame.getSize();
    		final int w = Math.max(s.width - f.width, 0);
    		final int h = Math.max(s.height - f.height, 0);
    		final int x = (int) (0.5 * w) + s.x;
    		final int y = (int) (0.5 * h) + s.y;
    		frame.setBounds(x, y, f.width, f.height);


		

		//setting positions of components
		close.setBounds(f.width - 50,10,40,15);
		head.setBounds(30,20,200,50);
		ub.setBounds(230,50,200,50);
		ta.setBounds(50,105,500,250);
		tr.setBounds(250,365,120,15);
		dummy.setBounds(250,300,25,6);

		//setting cursors for label buttons
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tr.setCursor(new Cursor(Cursor.HAND_CURSOR));

		//setting font and colours to the components 
		frame.setBackground(ly);
		close.setForeground(Color.red);
		close.setBackground(ly);
		close.setFont(new Font("Serif", Font.ITALIC, 12));
		head.setForeground(v);
		head.setBackground(ly);
		head.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,18));
		ub.setForeground(v);
		ub.setBackground(ly);
		ub.setFont(new Font("Serif",Font.ITALIC,14));
		ta.setForeground(v);
		ta.setBackground(ly);
		ta.setFont(new Font("Serif", Font.ITALIC, 15));
		ta.setEditable(false);
		tr.setForeground(Color.red);
		tr.setBackground(ly);
		tr.setFont(new Font("Serif",Font.ITALIC,12));


		//adding mouse events to close button
		close.addMouseListener(new MouseAdapter() 
			{
            			public void mouseClicked(MouseEvent e) {
					frame.dispose();
            			}
				public void mouseEntered(MouseEvent e) {
					close.setFont(new Font("Serif", Font.ITALIC, 14));

				}
				public void mouseExited(MouseEvent e) {
					close.setFont(new Font("Serif", Font.ITALIC, 12));
					
				}
        		});//end of adapter class definition

		//adding mouse events to add/edit birhdays button
		tr.addMouseListener(new MouseAdapter() 
			{
            			public void mouseClicked(MouseEvent e) {
					AddBirthday beast=new AddBirthday();
					//frame.dispose();
            			}
				public void mouseEntered(MouseEvent e) {
					tr.setFont(new Font("Serif", Font.ITALIC, 14));

				}
				public void mouseExited(MouseEvent e) {
					tr.setFont(new Font("Serif", Font.ITALIC, 12));
					
				}
        		});//end of adapter class definition
		
		

		



		//Reading birthdays and adding it to the text area
		Date d=new Date();		
		int q=0;
		String st[]=new String[7];
		Update u=new Update();
		st=u.getUpdate(d);	
		while(q<7)
		{	
			ta.append(st[q] );
			if(q!=6)
				ta.append("\n\n");
			q++;
		}//end of while
		frame.setBackground(ly);
  	}//end of main function
}//end of a class



