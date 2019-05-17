/**
 * This file is about clear cheque's interface.
 * @author Yuhang LI
 */
package boundary;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import control.*;
import entity.Cheque;

public class clearAllU extends JFrame{
	private static final long serialVersionUID = 1L;
	JLabel jlinfoClear;
	JButton jbSubmitClear,jbBackClear;
	JTable jtClear;
	ArrayList<Cheque> temp=new ArrayList<Cheque>();
	
	/**
	 * To create frame of clear cheque.
	 */
	public clearAllU() {
		this.setSize(460,400);
		this.setLayout(null);
		jlinfoClear=new JLabel("Click button to clear all cheques");
		jlinfoClear.setFont(new java.awt.Font("Times new roman",1,20));
		jbBackClear=new JButton("Back");
		jbSubmitClear=new JButton("Clear");
		jtClear=new JTable();
		
		DefaultTableModel tableModel = (DefaultTableModel) jtClear.getModel();
		try {
			temp  = allcheck.getCheque();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Object[] o={"AccountNo","Money"};
		tableModel.addColumn("AccountNo");

		tableModel.addColumn("Money");
		tableModel.addRow(o);
		for(int j=0;j<temp.size();j++) {
			Object[] t={temp.get(j).accNo,temp.get(j).moneyamount};
			tableModel.addRow(t);
		}
		jtClear.setBounds(80,120,300,100);
		jlinfoClear.setBounds(94,50,300,40);
		jbSubmitClear.setBounds(100,260,80,30);
		jbBackClear.setBounds(260,260,80,30);
		this.add(jtClear);
		this.add(jlinfoClear);
		this.add(jbBackClear);
		this.add(jbSubmitClear);
		this.setVisible(true);
		this.setTitle("Clear all cheques in normal condition");
		
		jbSubmitClear.addActionListener(new clearAllC(this) {	
		});

		jbBackClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminU();
				dispose();
			}
		});
	}
}
