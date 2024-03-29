import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Display extends JFrame implements ActionListener
{
    
    private JLabel displayheading;
    private JTextArea output;
    private JButton display,back;
    
    Container con=null;

    Display()
    {

        super("Display Record");
        con = getContentPane();
        con.setLayout(null);
        Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Color blue = new Color(30,144,255);
        Font font = new Font("Verdana", Font.BOLD, 16);

        displayheading=new JLabel("The records are:");
        displayheading.setBounds(200, 2, 700,150);
        displayheading.setFont(font);
        displayheading.setForeground(Color.BLACK);

        output=new JTextArea();
        output.setBounds(20, 150, 1400,400);
        output.setFont(font);
        output.setForeground(Color.BLACK);
        output.setEditable(false);

        display = new JButton("Display");
		display.setBounds(400,600,150,40);
		display.addActionListener(this);
        display.setFont(font);
        Color pul = new Color(0,0,255);
        Border bored = BorderFactory.createLineBorder(pul,5);
        display.setBorder(bored);
        display.setForeground(Color.BLACK);
        display.setBackground(blue);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.BLACK);
        back.setBackground(blue);

        con.add(displayheading);
		con.add(output);
        con.add(display);
        con.add(back);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==display)
        {
			try
            {
                String name = "", empid ="", yoe = "", branch = "", salary= "", nob="", email="",rating="",comments="", r;

                File temp = new File("temp.txt");
				Boolean createNewFile1 = temp.createNewFile();
                BufferedWriter pw = new BufferedWriter(new FileWriter("temp.txt"));
                String b = "NAME\t|EmpID\t|YOE\t|BRANCH\t|Salary\t|NOB\t|Email\t\t|rating\t|COMMENTS";
                pw.write(b); 
                pw.write("\n");

                BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
                while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split("\\|");
		        	name=result[0];
		        	empid=result[1];
		        	yoe= result[2];
		        	branch=result[3];
		        	salary=result[4];
		        	nob=result[5];
                    email=result[6];
                    rating=result[7];
                    comments=result[8];
                    if(name.equals("999"))
                        break;
                    String bb = name  + "\t|" + empid + "\t|" + yoe + "\t|" + branch + "\t|" + salary + "\t|" + nob + "\t|" + email + "\t|" + rating + "\t|" + comments;
                    pw.write(bb);
                    pw.write("\n");
		        }
                br.close();
                pw.close();
                File file = new File("temp.txt");
                BufferedReader br1 = new BufferedReader(new FileReader(file));
                output.read(br1,null);
                br1.close(); 
                output.requestFocus();
                file.delete();  
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        if(ae.getSource()==back)
        {
            try
            {
                this.dispose();
                Home h=new Home();
                h.setSize(2300,790);
                h.setVisible(true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
        Display dis=new Display();
		dis.setSize(2300,790);
		dis.setVisible(true);
    }   
}
