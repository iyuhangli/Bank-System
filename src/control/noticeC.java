/**
 * The control function of notice.
 */
package control;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import boundary.customerU;
import entity.BankAccount;

public class noticeC implements ActionListener{
	private JTextField jtaccNoNotice,jtpinNotice;
	private JFrame jframeC;
	
	/**
	 * Get infomation to operation
	 * @param jtaccNoNotice account number
	 * @param jtpinNotice account pin
	 * @param jframeC
	 */
	public noticeC(JTextField jtaccNoNotice,JTextField jtpinNotice, JFrame jframeC) {
		this.jtaccNoNotice=jtaccNoNotice;
		this.jtpinNotice=jtpinNotice;
		this.jframeC=jframeC;
	}
	
	/**
	 * Action after click button.
	 */
	public void actionPerformed(ActionEvent e) {
		BankAccount de=new BankAccount();
		try {
			int id=allcheck.checkIDPIN(jtaccNoNotice.getText(), jtpinNotice.getText());
			if(id<0) {	
				JOptionPane.showMessageDialog(null, "The account "	+ "does not exist or the info is mismatch. ", "alert", JOptionPane.ERROR_MESSAGE);				
			}
			else if(!allcheck.verifySuspend(id)) {JOptionPane.showMessageDialog(null, "This account "+ "has been suspend. ", "alert", JOptionPane.ERROR_MESSAGE);			 			
			}
			else {
				de.notice(id);
				JOptionPane.showMessageDialog(null, "Notice successful ","alert", JOptionPane.INFORMATION_MESSAGE);
				new customerU();
				jframeC.dispose();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
