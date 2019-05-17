/**
 * This is about notice to withdraw money.
 * @author Yuhang LI
 */
package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;
import control.noticeC;

public class noticeU extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtaccNoNotice,jtpinNotice;
	JLabel jlAccNoNotice,jlpinNotice,jlinfoNotice;
	JButton jbSubmitNotice,jbBackNotice;
	
	/**
	 * Create notice UI
	 */
	public noticeU() {
		this.setSize(460,400);
		this.setLayout(null);
		jtaccNoNotice=new JTextField(10);
		jtpinNotice=new JTextField(10);
		jlAccNoNotice=new JLabel("Account No");
		jlpinNotice=new JLabel("Pin");
		jlinfoNotice=new JLabel("Notice account");
		jbBackNotice=new JButton("Back");
		jbSubmitNotice=new JButton("Submit");
		jlinfoNotice.setFont(new java.awt.Font("Times new roman",1,20));

		jlinfoNotice.setBounds(144,50,300,40);
		jtaccNoNotice.setBounds(224,120,100,30);
		jtpinNotice.setBounds(224,170,100,30);
		jlAccNoNotice.setBounds(104,120,100,30);
		jlpinNotice.setBounds(104,170,100,30);
		jbSubmitNotice.setBounds(106,249,80,30);
		jbBackNotice.setBounds(236,249,80,30);
		
		this.add(jtaccNoNotice);
		this.add(jtpinNotice);
		this.add(jlAccNoNotice);
		this.add(jlpinNotice);
		this.add(jlinfoNotice);
		this.add(jbBackNotice);
		this.add(jbSubmitNotice);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("Notice");
		jbSubmitNotice.addActionListener(new noticeC(jtaccNoNotice,jtpinNotice,this) {
			
		});
		jbBackNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customerU();
				dispose();
			}
		});
		
	}
}
