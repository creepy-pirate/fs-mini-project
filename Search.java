import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Search extends JFrame implements ActionListener
{
    
    private JLabel empidL;
    private JTextField empidT; 
    private JTextArea output;
    private JButton search,back;
    
    Container con=null;
    String empid="";

    Search()
    {
        super("Search Record");
        con = getContentPane();
        con.setLayout(null);
        Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);
        Color blue = new Color(30,144,255);
        empidL=new JLabel("Enter empid of record to be searched");
        empidL.setBounds(400, 50, 700,150);
        empidL.setFont(font);
        empidL.setForeground(Color.BLACK);
        
        empidT=new JTextField(200);
		empidT.setBounds(725,100,250,50);
        empidT.setFont(font);
        empidT.setForeground(Color.BLACK);

        output=new JTextArea();
        output.setBounds(20,200,1200,100);
        output.setFont(font);
        output.setForeground(Color.BLACK);
        output.setEditable(false);

        search = new JButton("Search");
		search.setBounds(400,600,150,40);
		search.addActionListener(this);
        search.setFont(font);
        Color pul = new Color(0,0,255);
        Border bored = BorderFactory.createLineBorder(pul,5);
        search.setBorder(bored);
        search.setForeground(Color.BLACK);
        search.setBackground(blue);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.BLACK);
        back.setBackground(blue);

        con.add(empidL);
		con.add(empidT);
        con.add(output);
        con.add(search);
        con.add(back);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==search)
        {
            String empid = empidT.getText();
			try
            {
                String name = "", empid1 ="", sem = "", branch = "", cgpa= "", nob="", company="",ctc="",comments="", r;
                BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
		        while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split("\\|");
		        	name=result[0];
		        	empid1=result[1];
		        	sem= result[2];
		        	branch=result[3];
		        	cgpa=result[4];
		        	nob=result[5];
                    company=result[6];
                    ctc=result[7];
                    comments=result[8];
		        	if(empid1.equals(empid))
		        	{
                        File temp = new File("temp.txt");
					    Boolean createNewFile1 = temp.createNewFile();
					    BufferedWriter pw = new BufferedWriter(new FileWriter(temp));
                        String b = "NAME\t|EMPID\t|YOE\t|BRANCH\t|SALARY\t|NOC\t|COMPANY\t|CTC\t|COMMENTS";
                        String bb = name  + "\t|" + empid1 + "\t|" + sem + "\t|" + branch + "\t|" + cgpa + "\t|" + nob + "\t|" + company + "\t|" + ctc + "\t|" + comments;
                        pw.write(b);
                        pw.write("\n");
                        pw.write(bb);
                        pw.write("\n");
                        pw.close();
                        br.close();
                        File file = new File("temp.txt");
                        BufferedReader br1 = new BufferedReader(new FileReader(file));
                        output.read(br1,null);
                        br1.close();  
                        output.requestFocus();
                        file.delete();
		        		return ;
		        	}
		        }
		        showMessageDialog(null , "Record not found");
		        br.close();
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
        Search ser=new Search();
		ser.setSize(2300,790);
		ser.setVisible(true);
    }
}

