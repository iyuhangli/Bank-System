/**
 * Entity of bank account
 * @author Yuhang LI
 */
package entity;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import control.*;

public class BankAccount {
	public int accNo;
	public String accName;
	public double balance;
	public String pin;
	public String type;
	public boolean isSuspended;
	public String openTime;
	public double overDraftLimit;
	public String noticeNeeded;
	public ArrayList<BankAccount> bankaccount = new ArrayList<BankAccount>();
	public ArrayList <Cheque> item =new ArrayList<Cheque>();
	public ArrayList <Cheque> newitem =new ArrayList <Cheque>();
	
	/**
	 * Info about a bank.
	 * @param type type of account
	 * @param name customer name
	 * @param pin account pin
	 * @throws FileNotFoundException
	 */
    public BankAccount(String type, String name, String pin ) throws FileNotFoundException{
    	this.type= type;
    	this.accName=name;
    	this.balance=0;
    	this.pin = pin; 
    	bankaccount=allcheck.get();
    	accNo = bankaccount.get((bankaccount.size()-1)).accNo+1; 
    	overDraftLimit=0;
    	isSuspended = false;
    	noticeNeeded = null;
    }
    
    /**
     * Bank account
     */
	public BankAccount() {
		
	}
	
	/**
	 * Before open account to do
	 * @return accNo account number
	 */
    public int openAccount() {
    	Date dateOfNow=new Date();
    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    	openTime=dateFormat.format(dateOfNow);

    	String fname="./account.txt";
    	try {
    		FileWriter fw=new FileWriter(fname,true);
    		BufferedWriter bw=new BufferedWriter(fw);
    		bw.write(type+" "+accNo+" "+accName+" "+pin+" "+openTime+" "+
        	balance+" "+overDraftLimit+" "+ isSuspended+" "+ noticeNeeded+"\n");
    		bw.close();
    		fw.close();
    	}
    	catch(IOException e) {
    		System.out.println("Error in I/O moudle");
    		System.exit(1);
    	}
    	return accNo;
    }
    
    /**
     * Delete account function
     * @param id account id
     * @throws FileNotFoundException
     */
    public void deleteAccount (int id) throws FileNotFoundException{
    	bankaccount=allcheck.get();
    	id++;
    	for(int i=0;i<bankaccount.size();i++){
    		if(bankaccount.get(i).accNo==id) {
    			bankaccount.get(i).pin= bankaccount.get(i).pin+"1l1ldelete1l1l1laccount1l1l";
    		}
		}
    	allcheck.set(bankaccount);
    }
    
    /**
     * Suspend a account
     * @param id account id
     * @throws FileNotFoundException
     */
    public void suspend(int id) throws FileNotFoundException{
    	item=allcheck.getCheque();
    	bankaccount=allcheck.get();
    	bankaccount.get(id).isSuspended=true;
    	allcheck.set(bankaccount);
    }
    
    /**
     * Restart a account 
     * @param id account id
     * @throws FileNotFoundException
     */
	public void reuse(int id) throws FileNotFoundException {
		bankaccount=allcheck.get();
    	bankaccount.get(id).isSuspended=false;
    	allcheck.set(bankaccount);		
	}
	
	/**
	 * Deposit money
	 * @param id account id
	 * @param much money amount
	 * @throws FileNotFoundException
	 */
	public void inCash(String id, String much) throws FileNotFoundException {
    	double money = 0;
    	int accNo=0;
    	try {
    		accNo=Integer.parseInt(id.trim());
        	money = Double.valueOf(much.toString());
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	bankaccount=allcheck.get();
    	for(int i=0;i<bankaccount.size();i++){
    		if(bankaccount.get(i).accNo==accNo) {
    			bankaccount.get(i).balance+= money;
    		}
		}
    	allcheck.set(bankaccount);  	
    }
	
	/**
	 * Notice
	 * @param id account id
	 * @throws FileNotFoundException
	 */
	public void notice(int id) throws FileNotFoundException {
    	Date dateOfNow=new Date();
    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    	bankaccount=allcheck.get();
    	for(int i=0;i<=id;i++){
    		if(i==id)
    			bankaccount.get(i).noticeNeeded=dateFormat.format(dateOfNow);
		}
    	allcheck.set(bankaccount);  	
    }
	
	/**
	 * Deposit in cheque
	 * @param id account id
	 * @param much money amount 
	 * @throws IOException
	 */
    public void inCheque(String id, String much) throws IOException {
    	double money = 0;
    	int accNo=10;
    	try {
    		accNo=Integer.parseInt(id.trim());
        	money = Double.valueOf(much.toString());
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	FileWriter fw= new FileWriter("./cheque.txt", true); 
    	BufferedWriter bw= new BufferedWriter(fw);
    	bw.write(accNo+" "+money+"\n");
    	bw.close(); 
    	fw.close();  	
    }
    
    /**
     * Withdraw money
     * @param id account id
     * @param much money amount
     * @throws FileNotFoundException
     */
	public void withdraw(String id,String much) throws FileNotFoundException {
    	double money = 0;
    	int accNo=0;
    	try {
    		accNo=Integer.parseInt(id.trim());
        	money = Double.valueOf(much.toString());
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	bankaccount=allcheck.get();
    	for(int i=0;i<bankaccount.size();i++){
    		if(bankaccount.get(i).accNo==accNo) {
    			bankaccount.get(i).balance-= money;
    		}
		}
    	allcheck.set(bankaccount); 
	}
	
	/**
	 * Get account balance
	 * @param id account id
	 * @return balance balance
	 * @throws FileNotFoundException
	 */
	public double getBalance(String id) throws FileNotFoundException {
		int accNo=10;
		Double balance = 0.0;
    	try {
    		accNo=Integer.parseInt(id.trim());
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	bankaccount=allcheck.get();
    	for(int i=0;i<bankaccount.size();i++){
    		if(bankaccount.get(i).accNo==accNo) {
    			balance = bankaccount.get(i).balance;
    		}
		}
    	return balance;
	}	
	
	/**
	 * Clear cheques
	 * @throws IOException
	 */
    public void clearAll() throws IOException {
    	bankaccount=allcheck.get();
    	item.clear();
    	item  = allcheck.getCheque();   
    	newitem.clear();
    	for(int j=0;j<item.size();j++){
    		for(int i=0;i<bankaccount.size();i++){
    			if((bankaccount.get(i).accNo==item.get(j).accNo)&&(bankaccount.get(i).isSuspended==false)) {
    				bankaccount.get(i).balance+= item.get(j).moneyamount;
    			}
    			if((bankaccount.get(i).accNo==item.get(j).accNo)&&(bankaccount.get(i).isSuspended==true)) {
    				Cheque c = new Cheque();
    				c.accNo = item.get(j).accNo;
    				c.moneyamount = item.get(j).moneyamount;
    				newitem.add(c);
    			}  			
    		}
    	}
    	allcheck.set(bankaccount);
    	allcheck.putToCheque(newitem);
    }
}
