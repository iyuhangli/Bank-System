/**
 * The control of withdraw money.
 * @author Yuhang LI
 */
package control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import boundary.customerU;
import entity.BankAccount;

public class withdrawC implements ActionListener{
	private JTextField jtAccNoWith,jtPinWith,jtMoneyWith;
	private JFrame jframeC;
	
	/**
	 * Get info to operation
	 * @param jtAccNoWith account number
	 * @param jtPinWith account pin
	 * @param jtMoneyWith how much money
	 * @param jframeC
	 */
	public withdrawC(JTextField jtAccNoWith, JTextField jtPinWith, JTextField jtMoneyWith,JFrame jframeC){
		this.jtAccNoWith = jtAccNoWith;
        this.jtPinWith = jtPinWith;
        this.jtMoneyWith = jtMoneyWith;
        this.jframeC=jframeC;
	}
        
	/**
	 * Action after click button.
	 */
        public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			BankAccount wd=new BankAccount();
			try {
				int temp=0;
				int userid=allcheck.checkIDPIN(jtAccNoWith.getText(),jtPinWith.getText());
				temp=allcheck.isBalanceEnough(jtAccNoWith.getText(),jtMoneyWith.getText());
				if(userid<0)
				{
					JOptionPane.showMessageDialog(null, "The account does not exist or the info is mismatch. ", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(!allcheck.verifySuspend(userid))
				{	
					JOptionPane.showMessageDialog(null, "This account has been suspend. ", "Suspend account", JOptionPane.ERROR_MESSAGE);			 			
				}
				else if(temp < 0) 
				{	
					JOptionPane.showMessageDialog(null, "This account does not have enough money", "Not enough money", JOptionPane.ERROR_MESSAGE);			 			
				}
				else if(allcheck.accountTypeConfirm(jtAccNoWith.getText()).equals("saver")) {
					int tips = allcheck.checkDayTime(jtAccNoWith.getText());
					if(tips==-1)
						JOptionPane.showMessageDialog(null, "You must notice before you withdraw money.", "Notice", JOptionPane.ERROR_MESSAGE); 
					else if(tips>0) 
					{
						JOptionPane.showMessageDialog(null, "You can withdraw money from this account after "+tips+" days.", "Notice", JOptionPane.ERROR_MESSAGE); 
					}
					else 
					{
						new BankAccount().withdraw(jtAccNoWith.getText(), jtMoneyWith.getText());
						JOptionPane.showMessageDialog(new JFrame().getContentPane(),"Withddraw success","Withdraw",JOptionPane.INFORMATION_MESSAGE);
						jtAccNoWith.setText("");
						jtPinWith.setText("");
						jtMoneyWith.setText("");
					}
					
				}		
				else if(!allcheck.accountTypeConfirm(jtAccNoWith.getText()).equals("saver")){
					new BankAccount().withdraw(jtAccNoWith.getText(), jtMoneyWith.getText());
					JOptionPane.showMessageDialog(new JFrame().getContentPane(),"withddraw success","Withdraw",JOptionPane.INFORMATION_MESSAGE);
					jtAccNoWith.setText("");
					jtPinWith.setText("");
					jtMoneyWith.setText("");
				}
				new customerU();
				jframeC.dispose();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
}
