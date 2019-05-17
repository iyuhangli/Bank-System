/**
 * Eneiey of current account
 * @author Yuhang LI
 */
package entity;
import java.io.FileNotFoundException;

public class CurrentAccount extends BankAccount{
	/**
	 * Current Account
	 * @param type account type
	 * @param name name
	 * @param pin account pin
	 * @throws FileNotFoundException
	 */
	public CurrentAccount(String type, String name, String pin) throws FileNotFoundException {
		super(type, name, pin);
		overDraftLimit=500;	
	}
	
	public CurrentAccount(){
	}

}
