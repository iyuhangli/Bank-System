/**
 * The control function of restart account
 * @author Yuhang LI
 */
package control;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import boundary.adminU;
import entity.BankAccount;

public class restartC implements ActionListener{
	private JTextField jtaccNoRestart,jtpinRestart;
	private JFrame jframeC;
	
	/**
	 * Get info to operation
	 * @param jtaccNoRestart account number
	 * @param jtpinRestart account pin
	 * @param jframeC
	 */
	public restartC(JTextField jtaccNoRestart, JTextField jtpinRestart, JFrame jframeC) {
		this.jtaccNoRestart=jtaccNoRestart;
		this.jtpinRestart=jtpinRestart;
		this.jframeC=jframeC;
	}
	
	/**
	 * Action after click button.
	 */
	public void actionPerformed(ActionEvent e) {
		BankAccount sus=new BankAccount();
		try {
			int id=allcheck.checkIDPIN(jtaccNoRestart.getText(), jtpinRestart.getText());
			if(id<0) {	
				JOptionPane.showMessageDialog(null, "The account does not exist or the info is mismatch. ", "alert", JOptionPane.ERROR_MESSAGE);
								
			}
			else if(allcheck.verifySuspend(id)) {	
				JOptionPane.showMessageDialog(null, "This account has not been suspend. ", "ERROR", JOptionPane.ERROR_MESSAGE);			 			
			}
			else {
				if(JOptionPane.showConfirmDialog(new JFrame().getContentPane(),"Restart confirmed","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0) {
					sus.reuse(id);
					JOptionPane.showMessageDialog(new JFrame().getContentPane(), "Restart successful", "Information of success", JOptionPane.INFORMATION_MESSAGE);
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
