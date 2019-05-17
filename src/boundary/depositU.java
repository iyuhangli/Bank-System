/**
 * This is about deposit money.
 * @author Yuhang LI
 */

package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;
import control.*;

public class depositU extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	JLabel jlAccNoDeposit,jlMoneyDeposit,jlInfoDeposit;
	JTextField jtAccNoDeposit,jtMoneyDeposit;
	JButton submitDeposit,backDeposit;
	JRadioButton cash,cheque;
	ButtonGroup buttGroup;
	int numberPlus;
	
	/**
	 * Create deposit's interface.
	 */
	public depositU() {
		this.setSize(460,400);
		this.setLayout(null);
		jtAccNoDeposit=new JTextField(10);
		jtMoneyDeposit=new JTextField(10);
		jlAccNoDeposit=new JLabel("Account No");
		jlMoneyDeposit=new JLabel("Deposit money");
		jlInfoDeposit=new JLabel("Deposit money");
		submitDeposit=new JButton("Submit");
		backDeposit=new JButton("Back");
		cash=new JRadioButton("Cash");
		cheque=new JRadioButton("Cheque");
		jlInfoDeposit.setFont(new java.awt.Font("Times new roman",1,20));

		jlInfoDeposit.setBounds(160,50,300,40);
		jtAccNoDeposit.setBounds(224,120,100,30);
		jtMoneyDeposit.setBounds(224,170,100,30);
		jlAccNoDeposit.setBounds(104,120,100,30);
		jlMoneyDeposit.setBounds(104,170,100,30);
		backDeposit.setBounds(236,265,80,30);
		submitDeposit.setBounds(106,265,80,30);
		cash.setBounds(124,220,100,30);
		cheque.setBounds(244,220,100,30);
		
		this.add(jtAccNoDeposit);
		this.add(jtMoneyDeposit);
		this.add(jlAccNoDeposit);
		this.add(jlMoneyDeposit);
		this.add(jlInfoDeposit);
		this.add(submitDeposit);
		this.add(backDeposit);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("deposit");
		buttGroup=new ButtonGroup();
		cash.addMouseListener(this);
		buttGroup.add(cash);
		cheque.addMouseListener(this);
		buttGroup.add(cheque);
		this.add(cash);
		this.add(cheque);
		
		submitDeposit.addActionListener( 
				new depositC(jtAccNoDeposit, jtMoneyDeposit,cash,cheque,this) {
		});
		

		backDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
