import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Insert extends JFrame implements ActionListener 
{
    private  JLabel insertHeading,nameL,empidL,yoeL,branchL,salaryL,nobL,companyL,ctcL,commentsL;
    private  JTextField nameT,empidT,yoeT,branchT,salaryT,nobT,companyT,ctcT,commentsT;
    private  JButton insert,back;

    Container con=null;
    String name="", empid1="", yoe="", branch="", salary="", nob="",company="",ctc="",comments="";

    Insert()
    {
        super("Insert Record");
        con = getContentPane();
        con.setLayout(null);
		Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        insertHeading = new JLabel("INSERT EMPLOYEE DETAILS");
        insertHeading.setBounds(550,-50, 400,150);

        con.add(insertHeading);
		Color blue = new Color(30,144,255);
        Font font = new Font("Verdana", Font.BOLD, 16);
        insertHeading.setFont(font);
        insertHeading.setForeground(Color.WHITE);

        nameL=new JLabel("Enter Name:");
        nameL.setBounds(350,70,350,40);
        nameL.setFont(font);
        nameL.setForeground(Color.WHITE);
        nameT=new JTextField(200);
		nameT.setBounds(725,70,350,30);
        nameT.setFont(font);
        nameT.setForeground(Color.BLACK);

        empidL=new JLabel("Enter EmpID:");
		empidL.setBounds(350,130,350,40);
        empidL.setFont(font);
        empidL.setForeground(Color.WHITE);
		empidT=new JTextField(200);
		empidT.setBounds(725,130,350,30);
        empidT.setFont(font);
        empidT.setForeground(Color.BLACK);
        
        yoeL=new JLabel("Enter Years of Experience:");
		yoeL.setBounds(350,190,350,40);
        yoeL.setFont(font);
        yoeL.setForeground(Color.WHITE);
		yoeT=new JTextField(200);
		yoeT.setBounds(725,190,250,30);
        yoeT.setFont(font);
        yoeT.setForeground(Color.BLACK);

        salaryL=new JLabel("Enter Salary(Inhand):");
		salaryL.setBounds(350,310,350,40);
        salaryL.setFont(font);
        salaryL.setForeground(Color.WHITE);
		salaryT=new JTextField(200);
		salaryT.setBounds(725,310,250,30);
        salaryT.setFont(font);
        salaryT.setForeground(Color.BLACK);

		branchL=new JLabel("Enter Branch:");
		branchL.setBounds(350,250,150,40);
        branchL.setFont(font);
        branchL.setForeground(Color.WHITE);
		branchT=new JTextField(200);
		branchT.setBounds(725,250,250,30);
        branchT.setFont(font);
        branchT.setForeground(Color.BLACK);

        nobL=new JLabel("Enter Number of Complaints:");
		nobL.setBounds(350,370,300,40);
        nobL.setFont(font);
        nobL.setForeground(Color.WHITE);
		nobT=new JTextField(200);
		nobT.setBounds(725,370,250,30);
        nobT.setFont(font);
        nobT.setForeground(Color.BLACK);

		companyL=new JLabel("Enter Company Email:");
		companyL.setBounds(350,430,300,40);
        companyL.setFont(font);
        companyL.setForeground(Color.WHITE);
		companyT=new JTextField(200);
		companyT.setBounds(725,430,250,30);
        companyT.setFont(font);
        companyT.setForeground(Color.BLACK);

		ctcL=new JLabel("Enter Employee Rating:");
		ctcL.setBounds(350,490,300,40);
        ctcL.setFont(font);
        ctcL.setForeground(Color.WHITE);
		ctcT=new JTextField(200);
		ctcT.setBounds(725,490,250,30);
        ctcT.setFont(font);
        ctcT.setForeground(Color.BLACK);

		commentsL=new JLabel("Enter Comments:");
		commentsL.setBounds(350,550,300,40);
        commentsL.setFont(font);
        commentsL.setForeground(Color.WHITE);
		commentsT=new JTextField(200);
		commentsT.setBounds(725,550,250,30);
        commentsT.setFont(font);
        commentsT.setForeground(Color.BLACK);

        insert=new JButton("Insert");
		insert.setBounds(400,600,150,40);
		insert.addActionListener(this);
        insert.setFont(font);
        Color pul = new Color(0,0,255);
        Border bored = BorderFactory.createLineBorder(pul,5);
        insert.setBorder(bored);
        insert.setForeground(Color.WHITE);
        insert.setBackground(blue);

		back = new JButton("Go Back");
		back.setBounds(750,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.WHITE);
        back.setBackground(blue);

        con.add(nameL);
		con.add(nameT);
        con.add(empidL);
		con.add(empidT);
		con.add(yoeL);
		con.add(yoeT);
		con.add(branchL);
		con.add(branchT);
        con.add(salaryL);
		con.add(salaryT);
        con.add(nobL);
		con.add(nobT);
		con.add(companyL);
		con.add(companyT);
		con.add(ctcL);
		con.add(ctcT);
		con.add(commentsL);
		con.add(commentsT);
		con.add(insert);
		con.add(back);



		JLabel background;
		con.setSize(1000,600);
		con.setLayout(null);
       	ImageIcon img=new ImageIcon("background.png");
       	background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1400,900);
        add(background);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==insert)
        {
			try
			{
				String p = "999" + "|" + "999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" +"999" + "|"+"999" + "|"+"999" + "|"+"999" + "|" ;
				File data = new File("employee.txt");
				File data1 = new File("journal.txt");
				if(data.createNewFile() && data1.createNewFile())   
				{
					Boolean createNewFile = data.createNewFile();
					Boolean createNewFile1 = data1.createNewFile();
					// System.out.println("employee "+createNewFile);
					// System.out.println("journal "+createNewFile1);
					BufferedWriter pw = new BufferedWriter(new FileWriter(data));
					BufferedWriter pw1 = new BufferedWriter(new FileWriter(data1));
					pw.write(p);
					pw.write("\n");
					pw.close();
					pw1.write(p);
					pw1.write("\n");
					pw1.close();
				}

				String name = nameT.getText();
           		String empid1 = empidT.getText();
           		String yoe = yoeT.getText();
           		String branch = branchT.getText();
           		String salary = salaryT.getText();
           		String nob = nobT.getText();
				String company = companyT.getText();
				String ctc = ctcT.getText();
				String comments = commentsT.getText();

                int check=0,empid2=0,empid3=0;
				String empid="",r,sort,sort1="";
		        File file = new File("employee.txt");
		     	BufferedReader br=new BufferedReader(new FileReader(file));
			    while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split("\\|");
		        	empid=result[1];
		        	if(empid.equals(empid1))
		        	{	check=1;
		        		showMessageDialog(null, "A record already exists with empid: "+result[1]);
						break;
		        	}
		        }
		        br.close();
		        //if record already exists
		         if(check==1)
		         {
					showMessageDialog(null, "Record Updated!");
				 }
		        	String b = empid1 + "|" + yoe + "|"  + salary + "|" + nob + "|" + company + "|" +ctc + "|" + comments + "|";
		        	int len = b.length();
					File file2 = new File ("journal.txt");
		        	BufferedReader br2 = new BufferedReader(new FileReader(file2));
		        	empid3=Integer.parseInt(empid1);
		        	//sorting before insertion
					File temp1 = new File("temp.txt");
					Boolean createNewFile1 = temp1.createNewFile();
					BufferedWriter pw2 = new BufferedWriter(new FileWriter(temp1));
		        	String result1[]={};
					String yoe1,salary1,nob1,company1,ctc1,comments1;
		        	while((sort = br2.readLine()) != null)
		        	{
		        		result1 = sort.split("\\|");
		        		empid2=Integer.parseInt(result1[0]);
		        		yoe1 = result1[1];   
		        		salary1=result1[2];
		        		nob1=result1[3];
						company1=result1[4];
						ctc1=result1[5];
						comments1=result1[6];
		        		sort1 = empid2 + "|" + yoe1 + "|" + salary1 + "|" + nob1 + "|" + company1 + "|" +ctc1 + "|" + comments1 + "|";
		        		if(empid3<empid2)
		        		{
		        			pw2.write(b);
							pw2.write("\n");
		        			break;                                            
		        		}
		        		else if(empid3 == empid2)        
		        		{
		        			pw2.write(sort1); 
							pw2.write("\n");
		        			pw2.write(b); 
							pw2.write("\n");
		        			break;
		        		}
		        		pw2.write(sort1); 
						pw2.write("\n");
		        	}    
		        	if(sort!=null )
		        	{
		        		if(result1[0].equals("999"))
		        		{
		        			pw2.write(sort1);
							pw2.write("\n");
		        		}
		        		else
		        		{
		        			if(empid3>empid2)
		        			{
		        				pw2.write(b);
								pw2.write("\n");
		        				pw2.write(p);  
								pw2.write("\n");   
		        			}
		        			else if (empid3 == empid2)
		        			{
		        				while(!(result1[1].equals("999")))
		        				{
		        					sort = br2.readLine();
		        					result1 = sort.split("\\|");
		        					empid2=Integer.parseInt(result1[0]);
		        					yoe1 = result1[1];
		        					salary1=result1[2];
		        					nob1=result1[3];
									company1=result1[4];
									ctc1=result1[5];
									comments1=result1[6];
		        					sort1 = empid2 + "|" + yoe1 + "|" + salary1 + "|" + nob1 + "|" + company + "|" +ctc + "|" + comments + "|";
		        					pw2.write(sort1);
									pw2.write("\n");
		        				}
		        			}
		        			else
		        			{
		        				while(!result1[1].equals("999"))
		        				{
		        					pw2.write(sort1);
									pw2.write("\n");
		        					sort = br2.readLine();
		        					result1 = sort.split("\\|");
		        					empid2=Integer.parseInt(result1[0]);
		        					yoe1 = result1[1];
		        					salary1=result1[2];
		        					nob1=result1[3];
									company1=result1[4];
									ctc1=result1[5];
									comments1=result1[6];
		        					sort1 = empid2 + "|" + yoe1 + "|" + salary1 + "|" + nob1 + "|" + company + "|" +ctc + "|" + comments + "|";
		        				}
		        			}
		        			pw2.write(p);
							pw2.write("\n");
		        		}
		        	}
		        	pw2.flush();   
		        	pw2.close();
		        	br2.close();
		        	file2.delete();
		        	temp1.renameTo(file2);
					modify(name,empid1,yoe,branch,salary,nob,company,ctc,comments);
		        //}
		        //if record does not exist
		        if(check == 0)
		        {
		        	File file1 = new File("employee.txt");
		        	BufferedReader br1 = new BufferedReader(new FileReader(file1));
		        	b = name + "|" + empid1 + "|" + yoe + "|" + branch + "|" + salary + "|" + nob + "|" + company + "|" +ctc + "|" + comments + "|";
		        	len = b.length();
		        	empid3=Integer.parseInt(empid1);

		        	//sorting before insertion
					File temp = new File("temp.txt");
					Boolean createNewFile = temp.createNewFile();
					BufferedWriter pw1 = new BufferedWriter(new FileWriter(temp));
		        	String result[]={};
		        	while((sort = br1.readLine()) != null)
		        	{
		        		result = sort.split("\\|");
		        		empid2=Integer.parseInt(result[1]);
		        		if(empid3<empid2)
		        		{
		        			pw1.write(b);
							pw1.write("\n");
		        			break;
		        		}
		        		pw1.write(sort); 
						pw1.write("\n");
		        	}    

		        	if(sort!=null )
		        	{
		        		if(result[1].equals("999"))
		        		{
		        			pw1.write(sort);
							pw1.write("\n");
		        		}
		        		else
		        		{ 
		        			while(!result[1].equals("999"))
		        			{
		        				pw1.write(sort);
								pw1.write("\n");
		        				sort = br1.readLine();
		        				result = sort.split("\\|");
		        			}
		        			pw1.write(p);
							pw1.write("\n");
		        		}
		        	}
					showMessageDialog(null, "Record Added!");
		        	pw1.flush();   
		        	pw1.close();
		        	br1.close();

		        	file1.delete();
		        	temp.renameTo(file1);
                }

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


    public void modify(String name0, String empid0,String yoe0,String branch0, String salary0,String nob0, String company0, String ctc0, String comments0) throws FileNotFoundException,IOException,NullPointerException
	{	
		String empid="",r;

		File file = new File("employee.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		File temp = new File("temp.txt");
		Boolean createNewFile = temp.createNewFile();
		BufferedWriter pw = new BufferedWriter(new FileWriter(temp));

		while((r= br.readLine()) !=null)
		{	
			String[] result = r.split("\\|");
			empid=result[1];

			if(empid.equals(empid0))
			{
				String b = name0+"|"+empid0+"|"+yoe0+"|"+branch0+"|"+salary0+"|"+nob0+"|"+company0+"|"+ctc0+"|"+comments0+"|";
				int len = b.length();
				pw.write(b);
				pw.write("\n");
			}
			else
			{
				pw.write(r);
				pw.write("\n");
			}
		}
		pw.flush();
		pw.close();
		br.close();	

		file.delete();
		temp.renameTo(file);
	}



    public static void main(String args[])
    {
        Insert in = new Insert();
        in.setSize(2300,790);
        in.setVisible(true);
    }   
}   



