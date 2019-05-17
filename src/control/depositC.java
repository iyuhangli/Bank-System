/**
 * The control of deposit.
 * @author Yuhang LI
 */
package control;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import boundary.customerU;
import entity.BankAccount;

public class depositC implements ActionListener{
	private JTextField jtAccNoDeposit,jtMoneyDeposit;
	private JRadioButton cash,cheque;
	private JFrame jframeC;
	
	/**
	 * Get infomation of operation
	 * @param jtAccNoDeposit account number
	 * @param jtMoneyDeposit account pin
	 * @param cash cash
	 * @param cheque cheque
	 * @param jframeC
	 */
	public depositC(JTextField jtAccNoDeposit, JTextField jtMoneyDeposit,JRadioButton cash,JRadioButton cheque, JFrame jframeC) {
		this.jtAccNoDeposit=jtAccNoDeposit;
		this.jtMoneyDeposit=jtMoneyDeposit;
		this.cash=cash;
		this.cheque=cheque;
		this.jframeC=jframeC;
	}
	
	/**
	 * Action after click button of submit.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if(!allcheck.isStringSuspend(jtAccNoDeposit.getText())) {
				JOptionPane.showMessageDialog(null, "This account is in suspend or not exist","alert",JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (cash.isSelected()) {
					try {
						new BankAccount().inCash(jtAccNoDeposit.getText(), jtMoneyDeposit.getText());
						JOptionPane.showMessageDialog(new JFrame().getContentPane(), "Deposit success","Info",JOptionPane.INFORMATION_MESSAGE);
						jtAccNoDeposit.setText("");
						jtMoneyDeposit.setText("");
					}catch(FileNotFoundException err) {
						err.printStackTrace();
					}
				}									    
				else if (cheque.isSelected()) {
					try {
						new BankAccount().inCheque(jtAccNoDeposit.getText(), jtMoneyDeposit.getText());;
						JOptionPane.showMessageDialog(new JFrame().getContentPane(),"Deposit success","infocheque",JOptionPane.INFORMATION_MESSAGE);
						jtAccNoDeposit.setText("");
						jtMoneyDeposit.setText("");
					}catch(IOException errr) {
						errr.printStackTrace();
					}
				}
				new customerU();
				jframeC.dispose();
			}
		}catch (HeadlessException err0) {
			err0.printStackTrace();
		}catch (FileNotFoundException err1){
			err1.printStackTrace();
		}
	}

}
