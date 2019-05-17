/**
 * This is about close account's interface.
 * @author Yuhang LI
 */
package boundary;
import java.awt.event.*;
import javax.swing.*;

import control.closeC;

public class closeU extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField jtaccNoClose,jtpinClose;
	JLabel jlAccNoClose,jlpinClose,jlinfoClose;
	JButton jbSubmitClose,jbBackClose;
	
	/**
	 * To create frame of close account.
	 */
	public closeU() {
		this.setSize(460,400);
		this.setLayout(null);
		jtaccNoClose=new JTextField(10);
		jtpinClose=new JTextField(10);
		jlAccNoClose=new JLabel("Account No");
		jlpinClose=new JLabel("Pin");
		jlinfoClose=new JLabel("Click button to close account");
		jbBackClose=new JButton("back");
		jbSubmitClose=new JButton("submit");
		jlinfoClose.setFont(new java.awt.Font("Times new roman",1,20));
		
		jlinfoClose.setBounds(94,50,300,40);
		jtaccNoClose.setBounds(224,120,100,30);
		jtpinClose.setBounds(224,170,100,30);
		jlAccNoClose.setBounds(104,120,100,30);
		jlpinClose.setBounds(104,170,100,30);
		jbSubmitClose.setBounds(106,249,80,30);
		jbBackClose.setBounds(236,249,80,30);
		
		this.add(jtaccNoClose);
		this.add(jtpinClose);
		this.add(jlAccNoClose);
		this.add(jlpinClose);
		this.add(jlinfoClose);
		this.add(jbBackClose);
		this.add(jbSubmitClose);
		this.setVisible(true);
		this.setTitle("close account");
		jbSubmitClose.addActionListener(new closeC(jtaccNoClose,jtpinClose,this){
		});
		jbBackClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customerU();
				dispose();
			}
		});
	}
}
