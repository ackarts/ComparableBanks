import java.util.*;
import java.io.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args)throws IOException
    {
        String blah[] = ReadFromFile.readFile("E:/temp_nerd/Bank Of OSSM.txt");
        Bank OSSM = new Bank("Bank Of OSSM", 2);
        FileWriter fw = new FileWriter("E:/temp_nerd/Bank Of OSSM.out");
        PrintWriter pw = new PrintWriter(fw);
        
        BankAccount b = new BankAccount( "Tom", 600); 
        BankAccount c = new BankAccount( "Tom", 600);
        SavingsAccount yup = new SavingsAccount("Robin", 800, .3);
        SavingsAccount yu = new SavingsAccount("Robin", 800, .3);
        OSSM.addAccount(b);
        OSSM.addAccount(c);
        OSSM.addAccount(yup);
        OSSM.addAccount(yu);
        
        for(int i = 0; i<blah.length;i++)
        {
            String s = blah[i];
            if(s.contains("SavingsAccount"))
            {
                String name = s.substring(15);
                String accnum = blah[i+1].substring(14);
                int acc = Integer.parseInt(accnum);
                String balance = blah[i+2].substring(8);
                Double bal = Double.parseDouble(balance);
                String Rate = blah[i+3].substring(5);
                Double ra = Double.parseDouble(Rate);
                SavingsAccount k = new SavingsAccount(name, bal, ra);
                OSSM.addAccount(k);
                i+=3;
            }
            else if(s.contains("BankAccount"))
            {
                String name = s.substring(12);
                String num = blah[i+1].substring(14);
                int acc1 = Integer.parseInt(num);
                String balance = blah[i+2].substring(8);
                Double bal2 = Double.parseDouble(balance);
                BankAccount k = new BankAccount(name,bal2,acc1);
                OSSM.addAccount(k);
                i += 3;
            }
        }
        
        String s = "";

        while( !(s.equals("Finished")))
        {
            System.out.println("Do you want to add an account or are you finished?");
            System.out.println("If finished type \"Finished\".");
            System.out.println("To add account type\"Add account\".");
            Scanner sc1 = new Scanner(System.in);
            s = sc1.nextLine();
            
            if(s.equals("Add account"))
            {
                System.out.println("Will the account be a bank account or a savings account?");
                Scanner sc6 = new Scanner(System.in);
                
                s = sc6.nextLine();
                if( s.equalsIgnoreCase("Bank account") )
                {
                    System.out.println("What is the name on the account?");
                    Scanner sc8 = new Scanner(System.in);
                    String o = sc8.next();
                    System.out.println("What is intial deposit?");
                    Scanner sc7 = new Scanner(System.in);
                    String k = sc7.next();
                    BankAccount t = new BankAccount(o, Double.parseDouble(k));
                    OSSM.addAccount(t);
                }
                else if( s.equalsIgnoreCase("Savings Account"))
                {
                    System.out.println("What is the name on the account?");
                    Scanner sc10 = new Scanner(System.in);
                    String l = sc10.next();
                    System.out.println("What is intial deposit?");
                    Scanner sc11 = new Scanner(System.in);
                    String w = sc11.next();
                    System.out.println("What is the rate?");
                    Scanner sc12 = new Scanner(System.in);
                    String x = sc12.next();
                    SavingsAccount p = new SavingsAccount(l, Double.parseDouble(w),Double.parseDouble(x) );
                    OSSM.addAccount(p);
                }
                else
                    break;
            }
        }
        
        
        System.out.println("How do you want the accounts sorted?");
        System.out.println("1. Ascending sort by account number.");
        System.out.println("2. Ascending sort by account name.");
        System.out.println("3. Sort by account type.");
        Scanner poo = new Scanner(System.in);
        String sort = poo.next();
        BankAccount[] accounts = new BankAccount[1];
        
        accounts = OSSM.getAccounts().toArray(accounts);
        switch(Integer.parseInt(sort))
        {
        case 1:  AccountNumComp anc = new AccountNumComp();
        Arrays.sort( accounts, anc );
                     break;
            case 2:  AccountNameComp flower = new AccountNameComp();
        Arrays.sort( accounts, flower );
                     break;
            case 3:   AccountTypeComp glitch = new AccountTypeComp();
        Arrays.sort( accounts, glitch );
                     break;
        
        }
        OSSM.updateAccounts(accounts);
        
        String d = OSSM.toString();
        Scanner sca = new Scanner(d);
        while(sca.hasNext())
        {
            pw.println(sca.nextLine());
        }
        
        pw.close();
        fw.close();
    }
}
