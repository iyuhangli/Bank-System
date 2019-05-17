/**
 * This is about get balance interface.
 * @author Yuhang LI
 */
package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;
import control.getbalanceC;

public class getBalanceU extends JFrame{

	private static final long serialVersionUID = 1L;
	JTextField jtaccNoGet,jtpinGet;
	JLabel jlAccNoGet,jlpinGet,jlinfoGet;
	JButton jbSubmitGet,jbBackGet;
	
	/**
	 * Create get balance UI.
	 */
	public getBalanceU() {
		this.setSize(460,400);
		this.setLayout(null);
		jtaccNoGet=new JTextField(10);
		jtpinGet=new JTextField(10);
		jlAccNoGet=new JLabel("Account No");
		jlpinGet=new JLabel("Pin");
		jlinfoGet=new JLabel("Check account balance");
		jbBackGet=new JButton("Back");
		jbSubmitGet=new JButton("Submit");
		jlinfoGet.setFont(new java.awt.Font("Times new roman",1,20));

		jlinfoGet.setBounds(114,50,300,40);
		jtaccNoGet.setBounds(224,120,100,30);
		jtpinGet.setBounds(224,170,100,30);
		jlAccNoGet.setBounds(104,120,100,30);
		jlpinGet.setBounds(104,170,100,30);
		jbSubmitGet.setBounds(106,249,80,30);
		jbBackGet.setBounds(236,249,80,30);
		
		this.add(jtaccNoGet);
		this.add(jtpinGet);
		this.add(jlAccNoGet);
		this.add(jlpinGet);
		this.add(jlinfoGet);
		this.add(jbBackGet);
		this.add(jbSubmitGet);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("Get banlance");
		jbSubmitGet.addActionListener(new getbalanceC(jtaccNoGet,jtpinGet,this) {
		});
		jbBackGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customerU();
				dispose();
			}
		});
		
	}
}
