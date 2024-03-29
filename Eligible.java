import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Eligible extends JFrame implements ActionListener
{
    
    private JLabel eligibleheading,eligibleheading1,eligibleheading2,eligibleheading3;
    private JTextArea output;
    private JButton display,back;
    
    Container con=null;

    Eligible()
    {
        super("Apraisal Eligibility");
        con = getContentPane();
        con.setLayout(null);
        Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);
        Color blue = new Color(30,144,255);
        eligibleheading=new JLabel("APRAISAL ELIGIBILITY");
        eligibleheading.setBounds(550, 5, 700,20);
        eligibleheading.setFont(font);
        eligibleheading.setForeground(Color.BLACK);

        eligibleheading1=new JLabel("10% - CTC < 10 LPA and Number of Complaints < 8");
        eligibleheading1.setBounds(200, 50, 700,20);
        eligibleheading1.setFont(font);
        eligibleheading1.setForeground(Color.BLACK);

        eligibleheading2=new JLabel("20% - CTC < 10 LPA and Number of Complaints < 3");
        eligibleheading2.setBounds(200, 75, 700,20);
        eligibleheading2.setFont(font);
        eligibleheading2.setForeground(Color.BLACK);

        eligibleheading3=new JLabel("30% - CTC < 10 LPA and Number of Complaints = 0");
        eligibleheading3.setBounds(200, 100, 700,20);
        eligibleheading3.setFont(font);
        eligibleheading3.setForeground(Color.BLACK);


        output=new JTextArea();
        output.setBounds(100, 150, 1150,400);
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
        display.setBackground(Color.WHITE);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.BLACK);
        


        con.add(eligibleheading);
        con.add(eligibleheading1);
        con.add(eligibleheading2);
        con.add(eligibleheading3);
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
                

                System.out.println("Eligibilty Checked adn Displayed");
		        String name, salary1, nob1, r,b,e="";
		        double salary, nob;
		        
                File temp = new File("temp.txt");
				Boolean createNewFile1 = temp.createNewFile();
                BufferedWriter pw = new BufferedWriter(new FileWriter(temp));

                BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
		        while((r = br.readLine()) != null )
		        {
		        	String[] result = r.split("\\|"); 
		        	name=result[0];
		        	salary1=result[4];
		        	nob1=result[5];
		        	salary = Double.parseDouble(salary1);
		        	nob = Double.parseDouble(nob1);
		        	if(salary!=999)
		        	{
		        		if(salary >= 10 && nob ==0)
		        	    {
                            b = name + " : " + "30% Appraisal";
                            pw.write(b+"\n");

		        	    }
		        	    else if(salary >= 10 && nob>=3 && nob<=4)
		        	    {
		        	    	b = name + " : " + "20%";
                            pw.write(b+"\n");
		        	    }
		        	    else if(salary >= 10 && nob > 4)
		        	    {
		        	    	b = name + " : " + "10%";
                           
                            pw.write(b+"\n");
		        	    }
		        	    else
		        	    {
		        	    	b = name + " : " + "Not Eligible for Appraisal";
                            pw.write(b+"\n\n");
		        	    }
		        	}	
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
                //System.out.println("error is" +e);
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
        Eligible eli=new Eligible();
		eli.setSize(2300,790);
		eli.setVisible(true);
    }   

}