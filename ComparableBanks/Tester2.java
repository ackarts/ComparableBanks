import java.util.*;
/**
 * Write a description of class Tester2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester2
{
    public static void main(String[] args)
    {
        Bank b = new Bank("Bank of OSSM", 2);
        
        b.addAccount( new BankAccount("Bob", 1000, 8));
        b.addAccount( new SavingsAccount("Bob", 400, 0.04,1));
        b.addAccount( new BankAccount("John", 250, 5));
        b.addAccount( new SavingsAccount("Dean", 500, 0.05,9));
        b.addAccount( new SavingsAccount("Bob", 400, 0.04,2));
        
        
        BankAccount[] accounts = new BankAccount[1];
        accounts = b.getAccounts().toArray(accounts);
        
        //sort
        AccountNameComp anc = new AccountNameComp();
        Arrays.sort( accounts, anc);
        
        System.out.println(b);
        
        for(int i = 0; i<accounts.length;i++)
        {
            System.out.println(accounts[i]);
        }
    }
}
