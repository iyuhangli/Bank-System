/**
 * This is about withdraw UI
 * @author Yuhang LI
 */
package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;
import control.withdrawC;

public class withdrawU extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jlAccNoWith,jlPinWith,jlMoneyWith,jlInfoWith;
	JTextField jtAccNoWith,jtPinWith,jtMoneyWith,jtInfoWith;
	JButton jbSubmitWith,jbBackWith;
	
	/**
	 * Create withdraw UI.
	 */
	public withdrawU() {
		this.setSize(460,400);
		this.setLayout(null);
		jtAccNoWith=new JTextField(10);
		jtPinWith=new JTextField(10);
		jtMoneyWith=new JTextField(10);
		jlAccNoWith=new JLabel("Account No");
		jlPinWith=new JLabel("pin");
		jlMoneyWith=new JLabel("money");
		jlInfoWith=new JLabel("Withdraw money");
		jbBackWith=new JButton("back");
		jbSubmitWith=new JButton("submit");
		jlInfoWith.setFont(new java.awt.Font("Times new roman",1,20));
		jlInfoWith.setBounds(140,50,300,40);
		jtAccNoWith.setBounds(224,120,100,30);
		jtPinWith.setBounds(224,170,100,30);
		jlAccNoWith.setBounds(104,120,100,30);
		jlPinWith.setBounds(104,170,100,30);
		jlMoneyWith.setBounds(104,220,100,30);
		jtMoneyWith.setBounds(224,220,100,30);
		jbBackWith.setBounds(236,265,80,30);
		jbSubmitWith.setBounds(106,265,80,30);
		
		this.add(jtAccNoWith);
		this.add(jtPinWith);
		this.add(jtMoneyWith);
		this.add(jlAccNoWith);
		this.add(jlPinWith);
		this.add(jlMoneyWith);
		this.add(jlInfoWith);
		this.add(jbBackWith);
		this.add(jbSubmitWith);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("withdraw money");
		
		jbSubmitWith.addActionListener(new withdrawC(jtAccNoWith, jtPinWith, jtMoneyWith,this) {	
		});
		jbBackWith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customerU();
				dispose();
			}
		});
	}

}
