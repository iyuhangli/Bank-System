/**
 * This is about open a account's UI.
 * @author Yuhang LI
 */
package boundary;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import boundary.index.index;
import control.allcheck;
import control.openC;


public class openU extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	JPanel jpOpenAcc[];
	JLabel jlOpenAcc[],jlinfoNew;
	JTextField jtOpenAcc[];
	JButton submitOpenAcc,backOpenAcc;
	JRadioButton saverOpenAcc,currentOpenAcc,juniorOpenAcc;
	ButtonGroup buttGroup;
	int numberPlus;
	
	/**
	 * Create UI of open account.
	 */
	
	public openU() {
		this.setSize(460,400);
		this.setLayout(null);
		jlinfoNew=new JLabel("New a account");
		jlOpenAcc=new JLabel[6];
		jpOpenAcc=new JPanel[8];
		jtOpenAcc=new JTextField[5];
		jlinfoNew.setFont(new java.awt.Font("Times new roman",1,20));

		jlOpenAcc[0]=new JLabel("Name:");
		jlOpenAcc[1]=new JLabel("ID Number:");
		jlOpenAcc[2]=new JLabel("Mind! Your pin is:");
		jlOpenAcc[3]=new JLabel("Date of birth:");
		jlOpenAcc[4]=new JLabel("Your address:");
		jlOpenAcc[5]=new JLabel("Select the account type:");
		submitOpenAcc=new JButton("Submit");
		backOpenAcc=new JButton("Back");
		saverOpenAcc=new JRadioButton("Saver");
		currentOpenAcc=new JRadioButton("Current");
		juniorOpenAcc=new JRadioButton("Junior");

		for(int i=0;i<5;i++)
		{
			numberPlus=70;
			numberPlus+=i*40;
			jpOpenAcc[i]=new JPanel();
			jtOpenAcc[i]=new JTextField(10);
			jpOpenAcc[i].add(jlOpenAcc[i]);
			jpOpenAcc[i].add(jtOpenAcc[i]);
			jpOpenAcc[i].setBounds(110,numberPlus,200,30);
			this.add(jpOpenAcc[i]);
		}
		jpOpenAcc[2].setBounds(10,150,400,30);
		jtOpenAcc[2].setBackground(Color.LIGHT_GRAY);
		jtOpenAcc[2].setEditable(false);
		String randomnum=allcheck.randomGenerate();
		jtOpenAcc[2].setText(randomnum);

		buttGroup=new ButtonGroup();
		saverOpenAcc.addMouseListener(this);
		buttGroup.add(saverOpenAcc);
		currentOpenAcc.addMouseListener(this);
		buttGroup.add(currentOpenAcc);
		juniorOpenAcc.addMouseListener(this);
		buttGroup.add(juniorOpenAcc);
		jpOpenAcc[4]=new JPanel();
		jpOpenAcc[4].add(currentOpenAcc);
		jpOpenAcc[5]=new JPanel();
		jpOpenAcc[5].add(saverOpenAcc);
		jpOpenAcc[6]=new JPanel();
		jpOpenAcc[6].add(juniorOpenAcc);
		
		jlOpenAcc[5].setBounds(145,260,200,30);
		jlinfoNew.setBounds(160,20,300,40);
		jpOpenAcc[4].setBounds(110,282, 60, 30);
		jpOpenAcc[5].setBounds(180,282,60,30);
		jpOpenAcc[6].setBounds(240,282,60,30);
		submitOpenAcc.setBounds(90,320,100,30);
		backOpenAcc.setBounds(230,320,100,30);
		
		this.add(jlinfoNew);
		this.add(jlOpenAcc[5]);
		this.add(jpOpenAcc[4]);
		this.add(jpOpenAcc[5]);
		this.add(jpOpenAcc[6]);
		this.add(submitOpenAcc);
		this.add(backOpenAcc);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("Open account");
		submitOpenAcc.addActionListener(new openC(jtOpenAcc[0],jtOpenAcc[1],jtOpenAcc[2],jtOpenAcc[3],jtOpenAcc[4],saverOpenAcc,currentOpenAcc,juniorOpenAcc,this) {
		});
		backOpenAcc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				new customerU();
				dispose();
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
