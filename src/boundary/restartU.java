/**
 * This is about restart UI.
 * @author Yuhang LI
 */
package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;
import control.restartC;

public class restartU extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField jtaccNoRestart,jtpinRestart;
	JLabel jlAccNoRestart,jlpinRestart,jlinfoRestart;
	JButton jbSubmitRestart,jbBackRestart;
	
	/**
	 * Create restart UI.
	 */
	public restartU() {
		this.setSize(460,400);
		this.setLayout(null);
		jtaccNoRestart=new JTextField(10);
		jtpinRestart=new JTextField(10);
		jlAccNoRestart=new JLabel("Account No");
		jlpinRestart=new JLabel("Pin");
		jlinfoRestart=new JLabel("Restart a suspend account");
		jbBackRestart=new JButton("Back");
		jbSubmitRestart=new JButton("Submit");
		jlinfoRestart.setFont(new java.awt.Font("Times new roman",1,20));

		jlinfoRestart.setBounds(114,50,300,40);
		jtaccNoRestart.setBounds(224,120,100,30);
		jtpinRestart.setBounds(224,170,100,30);
		jlAccNoRestart.setBounds(104,120,100,30);
		jlpinRestart.setBounds(104,170,100,30);
		jbSubmitRestart.setBounds(106,249,80,30);
		jbBackRestart.setBounds(236,249,80,30);
		
		this.add(jtaccNoRestart);
		this.add(jtpinRestart);
		this.add(jlAccNoRestart);
		this.add(jlpinRestart);
		this.add(jlinfoRestart);
		this.add(jbBackRestart);
		this.add(jbSubmitRestart);
		this.setVisible(true);
		this.setDefaultCloseOperation(index.EXIT_ON_CLOSE);
		this.setTitle("restart account");
		jbSubmitRestart.addActionListener(new restartC(jtaccNoRestart,jtpinRestart,this) {
			
		});
		jbBackRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminU();
				dispose();
			}
		});
		
	}
}
