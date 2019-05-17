/**
 * It contains all check function of this program, it is an useful class.
 */
package control;
import java.io.*;
import java.text.*;
import java.util.*;
import entity.*;

public class allcheck {
	static ArrayList<BankAccount> bankaccount = new ArrayList<BankAccount>();
	static ArrayList <Cheque> chequeItem =new ArrayList<Cheque>();
	
	/**
	 * This get all cheque not cleared from .txt, and return a arraylist.
	 * @return chequeITem An arraylist of cheque.
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Cheque> getCheque() throws FileNotFoundException{
		chequeItem.clear();
		File fr= new File("./cheque.txt");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(fr);
		while(s.hasNext()) 
		{
			Cheque a =new Cheque();
			a.accNo=s.nextInt();
			a.moneyamount=s.nextDouble();
			chequeItem.add(a);
		}
		return chequeItem;
	}
	
	/**
	 * It get the bank account infomation from account.txt, and return an arraylist.
	 * @return bankaccount An arraylist contains infomation of bankaccount
	 * @throws FileNotFoundException
	 */
	public static ArrayList<BankAccount> get() throws FileNotFoundException{
		bankaccount.clear();
		File fr= new File("./account.txt");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(fr);
		while(s.hasNext()) 
		{		
				BankAccount a =new BankAccount();
				a.type=s.next();
				a.accNo=s.nextInt();
				a.accName=s.next();
				a.pin=s.next();
				a.openTime=s.next();
				a.balance=s.nextDouble();
				a.overDraftLimit=s.nextDouble(); 
				a.isSuspended=s.nextBoolean();  
				a.noticeNeeded=s.next(); 
				bankaccount.add(a);			
		}
		return bankaccount;		
	}
	
	/**
	 * Write the info about account to file account.txt
	 * @param account The info about account.
	 */
	public static void set(ArrayList<BankAccount> account) {
		try { 
        	FileWriter fileWriter= new FileWriter("./account.txt"); 
        	BufferedWriter bufferedWriter= new BufferedWriter(fileWriter); 
        	for(int j=0;j<account.size();j++) {
        		bufferedWriter.write(account.get(j).type+" "+account.get(j).accNo
        		+" "+account.get(j).accName+" "+account.get(j).pin+" "+account.get(j).openTime+" "
        		+account.get(j).balance+" "+account.get(j).overDraftLimit+" "
        	    + account.get(j).isSuspended+" "+ account.get(j).noticeNeeded+"\n"); 
        	}     	
        	bufferedWriter.close(); 
        	fileWriter.close(); 
        }
        catch (IOException e) { 
        	System.out.println("Error at I/O module"); 
        	System.exit(1); 
         }		
	}
	
	/**
	 * Put infomation about cheque not cleared to chque.txt
	 * @param acc Info about account
	 */
	public static void putToCheque(ArrayList<Cheque> acc) {
		try { 
        	FileWriter fileWriter= new FileWriter("./cheque.txt"); 
        	BufferedWriter bufferedWriter= new BufferedWriter(fileWriter); 
        	for(int i=0;i<acc.size();i++) {
        		bufferedWriter.write(acc.get(i).accNo
        		+" "+acc.get(i).moneyamount+"\n"); 
        	}     	
        	bufferedWriter.close(); 
        	fileWriter.close(); 
        }
        catch (IOException e) { 
        	System.out.println("Errors occured in I/O module"); 
        	System.exit(1); 
         }		
	}
	
	/**
	 * Check is balance enough when user wanna to withdraw money.
	 * @param id user's id
	 * @param much Money wanna to withdraw
	 * @return j return true of false
	 * @throws FileNotFoundException
	 */
	public static int isBalanceEnough(String id, String much) throws FileNotFoundException {
		bankaccount = allcheck.get();
		double money = 0;
    	int accNo=10;
    	try {
    		accNo=Integer.parseInt(id.trim());
        	money = Double.valueOf(much.toString());
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
		for(int j=0;j<bankaccount.size();j++){
    		if(bankaccount.get(j).accNo==accNo&&bankaccount.get(j).balance-money+bankaccount.get(j).overDraftLimit>=0) {
    			bankaccount.clear();
    			return j; 			
    		}	
	    }
		bankaccount.clear();
		return -1;	
    }
	
	/**
	 * Confirm the account type
	 * @param id account ID
	 * @return b Account type
	 * @throws FileNotFoundException
	 */
	public static String accountTypeConfirm(String id) throws FileNotFoundException {
		bankaccount=allcheck.get();		
    	int accNo=10;
    	String a="";
    	try {
    		accNo=Integer.parseInt(id.trim());       	
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
		for(int j=0;j<bankaccount.size();j++){
    		if(bankaccount.get(j).accNo==accNo) {
    			String b = bankaccount.get(j).type;
    			bankaccount.clear();
    			return b;   			
    		}	
	    }
		bankaccount.clear();
		return a;	
    }
	
	/**
	 * Check daytime when saveraccount want to withdraw money.
	 * @param id Account id
	 * @return tips Left how many days
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static int checkDayTime(String id) throws FileNotFoundException, ParseException {
		int day =-1;
		String date_str="";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");      
		bankaccount=allcheck.get();	
    	int accNo=0;
    	try {
    		accNo=Integer.parseInt(id.trim());      	
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
		for(int j=0;j<bankaccount.size();j++){
    		if(bankaccount.get(j).accNo==accNo) {
    			date_str = bankaccount.get(j).noticeNeeded;
    			day = 7;					
    		}	
	    }
		if(date_str.equals("null"))
			return -1;
		Date date1 = dateFormat.parse(date_str);
		int tips =day-diffDays(date1); 
		    return tips;	
    }
	
	/**
	 * To check different days
	 * @param date1 days to check
	 * @return secondd-firstd The days
	 */
	public static int diffDays(Date date1)
    {
        Calendar calendarone = Calendar.getInstance();
        calendarone.setTime(date1);
        Date date2 = new Date();
        Calendar calendartwo = Calendar.getInstance();
        calendartwo.setTime(date2);
        int firstd= calendarone.get(Calendar.DAY_OF_YEAR);
        int secondd = calendartwo.get(Calendar.DAY_OF_YEAR);        
        int firsty = calendarone.get(Calendar.YEAR);
        int secondy = calendartwo.get(Calendar.YEAR);
        if(firsty != secondy)   
        {
            int timeaaa = 0 ;
            for(int i = firsty ; i < secondy ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)           
                    timeaaa += 366;
                else    
                    timeaaa += 365;
            }
            return timeaaa + (secondd-firstd) ;
        }
        else    
            return secondd-firstd;
    }
	
	/**
	 * To check is account is suspend
	 * @param id Account id
	 * @return trueorfalse The status of account
	 * @throws FileNotFoundException
	 */
	public static boolean isStringSuspend(String id) throws FileNotFoundException {
		int accNo = 0;
    	try {
    		accNo=Integer.parseInt(id.trim());
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	bankaccount=allcheck.get();
    	for(int i=0;i<bankaccount.size();i++) {
    		if((bankaccount.get(i).accNo==accNo)&&(bankaccount.get(i).isSuspended==false)){ 
    			bankaccount.clear();
    			return true;
    		}
    	}	
   		bankaccount.clear();
    	return false;	
	}
	
	/**
	 * To check is suspend
	 * @param id Account id
	 * @return trueorfalse status
	 * @throws FileNotFoundException
	 */
	public static boolean verifySuspend(int id) throws FileNotFoundException {
    	bankaccount=allcheck.get();   		
    	if((bankaccount.get(id).isSuspended==false)){			 
    		bankaccount.clear();
    		return true;
    	}
    	else {
    		bankaccount.clear();
    		return false;
    	}	
	}
	
	/**
	 * To generate random number.
	 * @return No Random number
	 */
	public static String randomGenerate(){
    	int randomNum = 1000+(int)(Math.random()*1000);
    	String No = randomNum+"";
    	return No;
	}
	
	/**
	 * To find is account no in file
	 * @param fileName file name
	 * @param id account id
	 * @return boolean in or not in
	 * @throws IOException
	 */
	public static boolean check(String fileName, String id) throws IOException {
		File fr= new File(fileName);
		@SuppressWarnings("resource")
		Scanner s = new Scanner(fr);
		while(s.hasNext()) {
			if(id.equals(s.next())&&s.next().equals("bad")) {
				return false;
			}			
		}
		return true;		
	}
	
	/**
	 * To check is the account and pin is match.
	 * @param id account id
	 * @param pin account pin
	 * @return i Is match
	 * @throws FileNotFoundException
	 */
	public static int checkIDPIN(String id, String pin) throws FileNotFoundException {
    	int accNo=0;
    	try {
    		accNo=Integer.parseInt(id.trim());
    	}
    	catch(NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	bankaccount=allcheck.get();
    	for(int i=0;i<bankaccount.size();i++) {		
    		if((bankaccount.get(i).accNo==accNo)&&(bankaccount.get(i).pin.equals(pin))){
    			bankaccount.clear();
    			return i;
    		}
    	}
    	bankaccount.clear();
		return -1;	
	}

	/**
	 * To check is cheque is cleared.
	 * @param accnoa Account No
	 * @return boolean Is cleared
	 * @throws FileNotFoundException
	 */
	public static boolean checkIsCleared(String accnoa) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int accNo=0;
    	try {
    		accNo=Integer.parseInt(accnoa.trim());
    	}
    	catch(NumberFormatException e) {

    	    e.printStackTrace();
    	}
    	chequeItem=allcheck.getCheque();
    	for(int i=0;i<chequeItem.size();i++) {
    		if((chequeItem.get(i).accNo==accNo)){ 
    			bankaccount.clear();
    			return false;
    		}
    	}	
   		bankaccount.clear();
    	return true;	
	}
	
}


