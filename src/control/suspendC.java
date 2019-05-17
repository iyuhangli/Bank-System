/**
 * The control function of suspend account.
 * @author Yuhang LI
 */
package control;

import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import boundary.adminU;
import entity.BankAccount;

public class suspendC implements ActionListener{
	JTextField jtaccNoSuspend,jtpinSuspend;
	JFrame jframeC;
	
	/**
	 * Get info to operation
	 * @param jtaccNoSuspend account number
	 * @param jtpinSuspend account pin
	 * @param jframeC
	 */
	public suspendC(JTextField jtaccNoSuspend, JTextField jtpinSuspend,JFrame jframeC) {
		this.jtaccNoSuspend=jtaccNoSuspend;
		this.jtpinSuspend=jtpinSuspend;
		this.jframeC=jframeC;
	}
	
	/**
	 * Action after click button.
	 */
	public void actionPerformed(ActionEvent e) {
		BankAccount sus=new BankAccount();
		try {
			int id=allcheck.checkIDPIN(jtaccNoSuspend.getText(), jtpinSuspend.getText());
			if(id<0) {	
				JOptionPane.showMessageDialog(null, "The account does not exist or the info is mismatch. ","alert", JOptionPane.ERROR_MESSAGE);
								
			}
			else if(!allcheck.verifySuspend(id)) {	
				JOptionPane.showMessageDialog(null, "This account has been suspend. ", "alert", JOptionPane.ERROR_MESSAGE);			 			
			}
			else {
				if(JOptionPane.showConfirmDialog(new JFrame().getContentPane(),"Suspend confirmed","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0) {
					sus.suspend(id);
					JOptionPane.showMessageDialog(new JFrame().getContentPane(), "Suspend successful", "Information of success", JOptionPane.INFORMATION_MESSAGE);
				}
				new adminU();
				jframeC.dispose();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
