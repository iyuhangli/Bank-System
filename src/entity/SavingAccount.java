/**
 * Entity of saving account .
 * @author Yuhang LI
 */
package entity;
import java.io.FileNotFoundException;

public class SavingAccount extends BankAccount{
	public String openTime;
	public SavingAccount() {
		
	}
	/**
	 * Saving account
	 * @param type account type
	 * @param name name
	 * @param pin account pin
	 * @throws FileNotFoundException
	 */
	public SavingAccount(String type, String name, String pin) throws FileNotFoundException {
		super(type,name,pin);
	}
}
