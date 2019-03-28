import java.util.*;
/**
 * Write a description of class Bank here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bank
{
    private String bankName;
    private int numEmployees;
    private ArrayList<BankAccount> accounts;

    public Bank( String name, int emp )
    {
        bankName = name;
        numEmployees = emp;
        accounts = new ArrayList<BankAccount>();
    }

    public String getName()
    {
        return bankName;
    }

    public int getNumberOfEmployees()
    {
        return numEmployees;
    }

    public ArrayList<BankAccount> getAccounts()
    {
        return accounts;
    }

    public void addAccount( BankAccount b )
    {
        accounts.add(b);
    }
    
    public String toString()
    {
        String s = " ";
        s += "BankName=" + bankName + "\n";
        s += "NumberOfEmployees=" + numEmployees + "\n";

        for( BankAccount b : accounts)
        {
            if(b instanceof SavingsAccount)
            {
                s += "SavingsAccount=" + b.getName() + "\n";
                s += "AccountNumber=" + b.getAccountNumber() + "\n";
                s += "Balance=" + b.getBalance() + "\n";
                s += "Rate=" + ((SavingsAccount)b).getRate() + "\n";
            }
            else
            {
                s += "BankAccount=" + b.getName() + "\n";
                s += "AccountNumber=" + b.getAccountNumber() + "\n";
                s += "Balance=" + b.getBalance() + "\n";
            }
        }
        
        return s.trim();
    }    
    
    public void updateAccounts(BankAccount[] arr)
    {
        accounts = new ArrayList<BankAccount>();
        for(int i = 0; i<arr.length;i++)
        {
            accounts.add(arr[i]);
        }
    }
}

