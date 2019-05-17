/**
 * The control function of clear cheque.
 * @author Yuhang LI
 */
package control;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.BankAccount;
import boundary.adminU;

public class clearAllC implements ActionListener{
	private JFrame jframe;
	/**
	 * Get jframe to close later
	 * @param jframe
	 */
	public clearAllC(JFrame jframe){
        this.jframe = jframe;
    }
	
	/**
	 * Action after click button.
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			new BankAccount().clearAll();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(JOptionPane.showConfirmDialog(new JFrame().getContentPane(),"Are you sure to clear all cheques in normal condition?","Confirm information",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0) {
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "All uncleared cheques are cleared except some accounts which not in normal conditon", "Clear confirmed", JOptionPane.INFORMATION_MESSAGE);
		}
		new adminU();
		jframe.dispose();
	}
}
