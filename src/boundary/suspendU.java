/**
 * This is about suspend UI.
 * @author Yuhang Li
 */
package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;
import control.suspendC;

public class suspendU extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField jtaccNoSuspend,jtpinSuspend;
	JLabel jlAccNoSuspend,jlpinSuspend,jlinfoSuspend;
	JButton jbSubmitSuspend,jbBackSuspend;
	
	/**
	 * Create suspend UI.
	 */
	public suspendU() {
		this.setSize(460,400);
		this.setLayout(null);
		jtaccNoSuspend=new JTextField(10);
		jtpinSuspend=new JTextField(10);
		jlAccNoSuspend=new JLabel("Account No");
		jlpinSuspend=new JLabel("Pin");
		jlinfoSuspend=new JLabel("Suspend a account");
		jbBackSuspend=new JButton("Back");
		jbSubmitSuspend=new JButton("Submit");
		
		jlinfoSuspend.setFont(new java.awt.Font("Times new roman",1,20));

		jlinfoSuspend.setBounds(114,50,300,40);
		jtaccNoSuspend.setBounds(224,120,100,30);
		jtpinSuspend.setBounds(224,170,100,30);
		jlAccNoSuspend.setBounds(104,120,100,30);
		jlpinSuspend.setBounds(104,170,100,30);
		jbSubmitSuspend.setBounds(106,249,80,30);
		jbBackSuspend.setBounds(236,249,80,30);
		
		this.add(jtaccNoSuspend);
		this.add(jtpinSuspend);
		this.add(jlAccNoSuspend);
		this.add(jlpinSuspend);
		this.add(jlinfoSuspend);
		this.add(jbBackSuspend);
		this.add(jbSubmitSuspend);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("suspend account");
		jbSubmitSuspend.addActionListener(new suspendC(jtaccNoSuspend,jtpinSuspend,this) {
			
		});
		jbBackSuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminU();
				dispose();
			}
		});
	}

}
