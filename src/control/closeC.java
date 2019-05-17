/**
 * The control function of close.
 * @author Yuhang LI
 */
package control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import boundary.customerU;
import entity.*;
public class closeC implements ActionListener{
	private JTextField jtaccNoClose,jtpinClose;
	private JFrame jframe;
	
	/**
	 * Get necessary infomation
	 * @param jtaccNoClose account number
	 * @param jtpinClose account pin
	 * @param jframe
	 */
	public closeC(JTextField jtaccNoClose,JTextField jtpinClose, JFrame jframe)
	{
		this.jtaccNoClose=jtaccNoClose;
		this.jtpinClose=jtpinClose;
		this.jframe=jframe;
	}
	
	/**
	 * Action after click button
	 */
	public void actionPerformed(ActionEvent e) {
		BankAccount de=new BankAccount();
		try {
			int id=allcheck.checkIDPIN(jtaccNoClose.getText(), jtpinClose.getText());
			if(id<0)
				JOptionPane.showMessageDialog(null, "The account doesn't exist or the info is mismatching.", "Error", JOptionPane.ERROR_MESSAGE);			
			else if(!allcheck.verifySuspend(id))
				JOptionPane.showMessageDialog(null, "This account has been suspend. ","Suspend account", JOptionPane.ERROR_MESSAGE);			 			
			else if(!allcheck.checkIsCleared(jtaccNoClose.getText()))
				JOptionPane.showMessageDialog(null, "This account has uncleared cheque(s), please contact the administrator.", "Uncleared cheque(s)", JOptionPane.ERROR_MESSAGE);			 			
			else if(new BankAccount().getBalance(jtaccNoClose.getText())!=0)
				JOptionPane.showMessageDialog(null, "This account's balance is not 0. Please try again after withdraw money", "Error", JOptionPane.ERROR_MESSAGE);			 			
			else {
				if(JOptionPane.showConfirmDialog(new JFrame().getContentPane(), "Operation cannot be undone, please confirm again", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) 
				{
					de.deleteAccount(id);
					JOptionPane.showMessageDialog(null,"Delete confirmed");
				}
				new customerU();
				jframe.dispose();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
