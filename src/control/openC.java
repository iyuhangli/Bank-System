/**
 * The control function of open account.
 * @author Yuhang LI
 */
package control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import boundary.customerU;
import entity.*;

public class openC implements ActionListener{
	private JRadioButton saverOpenAcc,currentOpenAcc,juniorOpenAcc;
	private JTextField jtOpenAcc0,jtOpenAcc1,jtOpenAcc2,jtOpenAcc3,jtOpenAcc4;
	private JFrame jframeC;
	
	/**
	 * Get infomation to operation.
	 * @param jtOpenAcc0 Account number
	 * @param jtOpenAcc1 ID	
	 * @param jtOpenAcc2 Account PIN
	 * @param jtOpenAcc3 Date of Birth
	 * @param jtOpenAcc4 Address
	 * @param saverOpenAcc Saver
	 * @param currentOpenAcc current
	 * @param juniorOpenAcc junior
	 * @param jframeC
	 */
	public openC(JTextField jtOpenAcc0,JTextField jtOpenAcc1,JTextField jtOpenAcc2,JTextField jtOpenAcc3,JTextField jtOpenAcc4,JRadioButton saverOpenAcc,JRadioButton currentOpenAcc,JRadioButton juniorOpenAcc, JFrame jframeC) {
		this.jtOpenAcc0=jtOpenAcc0;
		this.jtOpenAcc1=jtOpenAcc1;
		this.jtOpenAcc2=jtOpenAcc2;
		this.jtOpenAcc3=jtOpenAcc3;
		this.jtOpenAcc4=jtOpenAcc4;
		this.saverOpenAcc=saverOpenAcc;
		this.currentOpenAcc=currentOpenAcc;
		this.juniorOpenAcc=juniorOpenAcc;
		this.jframeC=jframeC;
	}

	/**
	 * Action after click button.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if(allcheck.check("./credit.txt", jtOpenAcc1.getText())) {
				int accNo=-1;
				String abc= jtOpenAcc0.getText()+"-"+jtOpenAcc1.getText()+"-"+jtOpenAcc3.getText()+"-"+jtOpenAcc4.getText();
				if (juniorOpenAcc.isSelected()) {
					String year= jtOpenAcc3.getText().substring(0,4);
					int age = 2019-Integer.parseInt(year);
					if(age>=16) {
						JOptionPane.showMessageDialog(null, "Only people under the age of 16 can open a junior account", "ERROR", JOptionPane.ERROR_MESSAGE); 
					}
					else {
						accNo= new BankAccount("junior",abc,jtOpenAcc2.getText()).openAccount();
						JOptionPane.showMessageDialog(null,"Success to open a junior account, please remember your account No. is "+accNo+". Pin: "+jtOpenAcc2.getText(),"Open successful", JOptionPane.INFORMATION_MESSAGE);
					}				
				}					    
				else if (saverOpenAcc.isSelected()) { 
						accNo= new SavingAccount("saver",abc,jtOpenAcc2.getText()).openAccount();
						JOptionPane.showMessageDialog(null,"Success to open a saver account, please remember your account No. is "+accNo+". Pin: "+jtOpenAcc2.getText(),"Open successful", JOptionPane.INFORMATION_MESSAGE);
				}
			    else if (currentOpenAcc.isSelected()){
			    	accNo= new CurrentAccount("current",abc,jtOpenAcc2.getText()).openAccount();
					JOptionPane.showMessageDialog(null,"Success to open a current account, please remember your account No. is "+accNo+". Pin: "+jtOpenAcc2.getText(),"Open successful", JOptionPane.INFORMATION_MESSAGE);
			    }
			    else {
					JOptionPane.showMessageDialog(null,"Please select one type.","ERROR", JOptionPane.INFORMATION_MESSAGE);
			    }
				new customerU();
				jframeC.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, 
				"Your credit status is bad in the credit database, please contact adminstrator.", "alert", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
