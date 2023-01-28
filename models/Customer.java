package models;
import java.io.*;
import java.util.Scanner;
public class Customer implements Validation{
    
    public String name;
    public String user_name;
    private String password="";
    public int age;
    public String SSN;
    public String address;
    public String email;
    public long phone;
    private float balance=0.0f;
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public Customer()
    {
        this.name="";
        this.user_name="";
        this.age=20;
        this.SSN="";
        this.address="";
        this.email="";
        this.phone=0;
    }
    public Customer(String name,String user_name,int age,String SSN,String address,String email,long phone)
    {
        this.name=name;
        this.user_name=user_name;
        this.age=age;
        this.SSN=SSN;
        this.address=address;
        this.email=email;
        this.phone=phone;
    }
    public static boolean login(Customer c,String pass)
    {
        if(c.password.equals(pass))
            return true;
        return false;
    }
    void deposits(int dep)
    {
        balance+=dep;
        System.out.println("Balance deposited: "+dep);
        System.out.println("Current Balance: "+balance);
    }
    void withdrawal(int withdraw)
    {
        if(withdraw <= (this.balance-Account.minimumBalance)){
            this.balance -= withdraw;
            System.out.println("Balance deducted: "+withdraw);
            System.out.println("Current Balance: "+balance);
        }
        else
        {
            System.out.println("Invalid withdraw");
        }
    }
    void changepassword() throws IOException
    {    
        System.out.print("Enter old password: ");
        String s=br.readLine();
        while(true){
            if(s.equals(password)==true)
            {
                System.out.print("Enter new password: ");
                String newPassword=br.readLine();
                
                if(newPassword.equals(password)!=true){
                    password=newPassword;
                    System.out.println("Changed successfully\n");
                    return;
                }
                else
                    continue;
            }
            else{
                System.out.println("Password does'nt match\n");
                return;
            }
        }
    }
    public void alldetailscustomer()
    {
        System.out.println("Details About "+name);
        System.out.println("Name: "+name);
        System.out.println("Username: "+user_name);
        System.out.println("Age: "+age);
        System.out.println("Address: "+address);
        System.out.println("Phone number: "+phone);
        System.out.println("Email id: "+email);

    }
    public void operations(Account a)throws IOException
    {
        while(true)
        {
            System.out.println(" 1:Deposit \n 2:Withdrawal \n 3:Check balance \n 4:Edit profile \n 5:Change password \n 6:Details \n 7:Log-out \n");
            boolean f=true;
            int n=Integer.parseInt(br.readLine());
            switch(n)
            {
                case 1: System.out.print("Enter deposit amount: ");
                        int amt=Integer.parseInt(br.readLine());
                        deposits(amt);
                        break;

                case 2: System.out.print("Enter withdrawal amount: ");
                        amt=Integer.parseInt(br.readLine());
                        withdrawal(amt);
                        break;
                
                case 3:checkbalance();
                        break;
                    
                case 4:editprofile();break;
                case 5:changepassword();break;
                case 6:alldetailscustomer();break;
                case 7:f=false;
                        return;
                default:System.out.println("Wrong choice");
                        break;
            }
            if(f==false) 
                return;
        }
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public float getBalance() {
        return balance;
    }
    public boolean setBalance(float balance) {
        if(Account.minimumBalance>balance){
            System.out.println("Minimum balance is more then first deposit");
            System.out.println("Try again");
            return false;
        }
        this.balance = balance;
        return true;
    }
    void checkbalance()
    {
        System.out.println("Balance: "+balance);   
    }
    void editprofile()throws IOException
    {
        while(true){

            System.out.print("\n Edit Profile: \n 1.Change name\n2.Change address\n3.Change phone\n4.Change age\n5.Done\nEnter your option: ");
            int option = Integer.parseInt(br.readLine());
            switch(option){
                case 1:
                    System.out.print("Enter new name: ");
                    this.name = br.readLine();
                    break;
                case 2:
                    System.out.print("Enter new address: ");
                    this.address = br.readLine();
                    break;
                case 3:
                    System.out.print("Enter new phone: ");
                    this.phone = Long.parseLong(br.readLine());
                    // sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter new age: ");
                    this.age = Integer.parseInt(br.readLine());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong option choosen.");
            }
        }
    }
    @Override
    public boolean validateSSN(String SSN) {
        if(SSN.length()==9)
            return true;
        return false;
        
    }
    @Override
    public boolean validateAge(int age) {
        if(age<18)
            return false;
        return true;
        
    }
}

