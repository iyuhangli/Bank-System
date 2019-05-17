/**
 * The control function of get balance.
 * @author Yuhang LI 
 */
package control;

import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

import boundary.customerU;
import entity.BankAccount;


public class getbalanceC implements ActionListener{
	private JTextField jtaccNoGet,jtpinGet;
	private JFrame jframec;
	
	/**
	 * Get information to operation
	 * @param jtaccNoGet account number
	 * @param jtpinGet account pin
	 * @param jframe
	 */
	public getbalanceC(JTextField jtaccNoGet,JTextField jtpinGet,JFrame jframe) {
		this.jtaccNoGet=jtaccNoGet;
		this.jtpinGet=jtpinGet;
		this.jframec=jframe;
	}
	
	/**
	 * Action after click button.
	 */
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unused")
		BankAccount de=new BankAccount();
		try {
			int id=allcheck.checkIDPIN(jtaccNoGet.getText(), jtpinGet.getText());
			if(id<0) 
			{	
				JOptionPane.showMessageDialog(null, "The account doen't exist or the info is mismatching.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(!allcheck.verifySuspend(id)) {	
				JOptionPane.showMessageDialog(null, "This account has been suspend.","Suspend account", JOptionPane.ERROR_MESSAGE);			 			
			}
			else {
				JOptionPane.showMessageDialog(null, "This account balance is "+new BankAccount().getBalance(jtaccNoGet.getText())+".","Account balance",JOptionPane.INFORMATION_MESSAGE);
				new customerU();
				jframec.dispose();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
