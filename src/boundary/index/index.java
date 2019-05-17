/**
 * This a bank system that users can open, close, deposit, get banlance, withdraw, close account
 * admin can restart suspend account, and a system to clear all cheque. 
 * @author Yuhang LI
 */
package boundary.index;
import javax.swing.*;

import boundary.adminU;
import boundary.clearAllU;
import boundary.customerU;

import java.awt.event.*;
public class index extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel welcome;
	JButton jbut[],clearAll;
	JLabel jls1;
	
	/**
	 * Create index UI, the first interface.
	 */
	public index() {
		welcome=new JPanel();
		jbut=new JButton[2];
		jls1=new JLabel("Welcome");
		jbut[0]=new JButton("Customer");
		jbut[1]=new JButton("Admin");
		welcome.add(jls1);
		this.setSize(460,400);
		this.setLayout(null);
		jls1.setFont(new java.awt.Font("Times new roman",1,40));
		clearAll=new JButton("Clear all cheques");
		clearAll.setBounds(110,290,200,30);
		jbut[1].setBounds(110,220,200,30);
		jbut[0].setBounds(110,150,200,30);
		welcome.setBounds(125,60,160,50);
		this.add(welcome);
		this.add(jbut[0]);
		this.add(jbut[1]);
		this.add(clearAll);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("Bank system");
		jls1.setFont(new java.awt.Font("Times New Roman",1,18));
		

		
		jbut[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customerU();
				dispose();
			}
		});
		jbut[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminU();
				dispose();
			}
		});
		
		clearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new clearAllU();
				dispose();
			}
		});
		
	}
	
	/**
	 * Main function, the program's entry.
	 * @param args
	 */
	public static void main(String[]args) {
		@SuppressWarnings("unused")
		index in=new index();
	}
}
