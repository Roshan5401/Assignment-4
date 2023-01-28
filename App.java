import java.io.*;
// import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import javax.lang.model.util.ElementScanner14;

import models.*;
public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Object> mp1=new HashMap<>();
        HashMap<String,Object> mp2=new HashMap<>();
        System.out.println("\t\t\t\tWelcome To The Bank");
        while(true)
        {
            System.out.println("Enter\n 1:Create Bank Account \n 2:Log-in Bank Acoount \n ");
            int n=Integer.parseInt(br.readLine());
            switch(n)
            {
                case 1: Customer c=new Customer();
                        System.out.print("Enter name: ");
                        c.name=br.readLine();
                        System.out.print("Enter username: ");
                        c.user_name=br.readLine();
                        String user_name=c.user_name;
                        if(mp1.containsValue(user_name)==true)
                        {
                            System.out.println("User Name already exists");
                            break;
                        }
                        System.out.print("Enter password: ");
                        String password=br.readLine();
                        c.setPassword(password);
                        System.out.print("Enter age: ");
                        c.age=Integer.parseInt(br.readLine());
                        if(c.validateAge(c.age)!=true){
                            System.out.println("Below 18\n");
                            break;
                        }
                        System.out.print("Enter SSN: ");
                        c.SSN=br.readLine();
                        if(c.validateSSN(c.SSN)!=true){
                            System.out.println("SSN Length not equal to 9\n");
                            break;
                        }
                        System.out.print("Enter Address: ");
                        c.address=br.readLine();
                        System.out.print("Enter Email: ");
                        c.email=br.readLine();
                        System.out.print("Enter Phone: ");
                        c.phone=Long.parseLong(br.readLine());
                        
                        System.out.println("Enter 1:Savings 2:Current");
                        int k=Integer.parseInt(br.readLine());
                        if(k==1){
                            Account a=new Savings();
                            a.display();
                            System.out.print("Enter amount for first deposit: ");
                            
                            float d=Float.parseFloat(br.readLine());
                            System.out.println();
                            if(c.setBalance(d)==false)
                                break;
                            mp2.put(user_name,a);
                        }
                        else
                        if(k==2)
                        {
                            Account a=new Current();
                            a.display();
                            System.out.print("Enter amount for first deposit: ");
                            float d=Float.parseFloat(br.readLine());
                            System.out.println();
                            if(c.setBalance(d)==false)
                                break;
                            mp2.put(user_name,a);
                        }
                        
                        mp1.put(user_name,c);
                        break;

                case 2: System.out.print("Enter username: ");
                        String us_name=br.readLine();
                        System.out.print("Enter password: ");
                        String us_pass=br.readLine();
                        if(mp1.containsKey(us_name)!=true)
                        {
                            System.out.println("Account Not Found");
                            break;
                        }
                        Customer op1=(Customer) mp1.get(us_name);
                        Account op2=(Account) mp2.get(us_name);

                        if(Customer.login(op1,us_pass)){
                            System.out.println("Log-in Successful\n");
                            op1.operations(op2);

                        }
                        else
                            System.out.println("Log-in Failed\n");
                        break;
                default:System.out.println("Wrong choice\n");
                        return;
            }
        }
    }
}
