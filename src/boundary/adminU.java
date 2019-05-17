/**
 * This is about admin's interface.
 * @author Yuhang LI
 */

package boundary;
import java.awt.event.*;
import javax.swing.*;

import boundary.index.index;

@SuppressWarnings("serial")
public class adminU extends JFrame{
	
	JButton suspendAcc,restartAcc,backAdmin;
	/**
	 * Create the admin UI
	 */
	public adminU() {
		suspendAcc=new JButton("Suspend a account");
		restartAcc=new JButton("Unlock a account");
		backAdmin=new JButton("Back");

		suspendAcc.setBounds(100,50,200,30);
		restartAcc.setBounds(100,160,200,30);
		backAdmin.setBounds(100,270,200,30);
		this.setSize(460,400);
		this.setLayout(null);
		this.add(suspendAcc);
		this.add(restartAcc);
		this.add(backAdmin);
		this.setVisible(true);
		this.setTitle("Admin interface");
		suspendAcc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				new suspendU();
				dispose();
			}
		});
		restartAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new restartU();
				dispose();
			}
		});

		backAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new index();
				dispose();
			}
		});
	}
}
