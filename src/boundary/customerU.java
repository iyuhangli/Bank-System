/**
 * This is about customer (user)'s interface.
 * @author Yuhang LI
 */
package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;

public class customerU extends JFrame{
	private static final long serialVersionUID = 1L;
	JButton openAcc,closeAcc,checkBalance,depostMoney,withdrawMoney,exitToUp,notice;
	
	/**
	 * Create customer's interface.
	 */
	public customerU() {
		openAcc=new JButton("Open a account");
		closeAcc=new JButton("Close a account");
		checkBalance=new JButton("Check balance");
		depostMoney=new JButton("Depost");
		withdrawMoney=new JButton("Withdraw");
		notice=new JButton("Notice");
		exitToUp=new JButton("Back");

		openAcc.setBounds(100,50,200,30);
		closeAcc.setBounds(100,90,200,30);
		checkBalance.setBounds(100,130,200,30);
		depostMoney.setBounds(100,170,200,30);
		withdrawMoney.setBounds(100,210,200,30);
		notice.setBounds(100,250,200,30);
		exitToUp.setBounds(100,290,200,30);

		this.setSize(460,400);
		this.setLayout(null);
		this.add(openAcc);
		this.add(closeAcc);
		this.add(checkBalance);
		this.add(depostMoney);
		this.add(withdrawMoney);
		this.add(notice);
		this.add(exitToUp);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("Customer interface");
		openAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new openU();
				dispose();
			}
		});
		closeAcc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				new closeU();
				dispose();
			}
		});
		checkBalance.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new getBalanceU();
				dispose();
			}
		});
		depostMoney.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new depositU();
				dispose();
			}
		});
		withdrawMoney.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new withdrawU();
				dispose();
			}
		});
		notice.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new noticeU();
				dispose();
			}
		});
		exitToUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new index();
				dispose();
			}
		});
		
	}
}
